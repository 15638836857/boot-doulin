//package com.youlan.WxCommons.order;
//
//import com.alibaba.fastjson.JSONObject;
//import com.palmble.entity.*;
//import com.palmble.service.ApiLogsService;
//import com.palmble.service.ConsigneeService;
//import com.palmble.service.OrderService;
//import com.palmble.service.ProductService;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.interceptor.TransactionAspectSupport;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.math.BigDecimal;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
///*@Controller
//@RequestMapping("/wx")*/
//public class WxOrderParentController {
//    @Autowired
//    private OrderService orderService;
//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private ConsigneeService consigneeService;
//    @Autowired
//    private ApiLogsService apiLogsService;
//    protected Integer type;
//    protected Logger logger;
//
//    @Autowired
//    private ThreadPoolTaskExecutor poolTaskExecutor;
//
//    @Value("${brc.appid}")
//    private String appid;
//    @Value("${brc.secret}")
//    private String secret;
//    @Value("${create-order-api}")
//    private String createOrderUrl;
//    @Value("${pay_back_url}")
//    private String payBackUrl;
//    @Value("${pay_url}")
//    private String payUrl;
//    @RequestMapping("/confirm")
//    @ResponseBody
//    @Transactional
//    public Result<Integer> confirm(Integer productid, Integer quantity, Integer cid, HttpServletRequest request){
//        Result<Integer> result=new Result<>();
//        MemberUser user=(MemberUser)request.getSession().getAttribute("userInfo");
//
//        Callable<PProduct> productCallable=new Callable<PProduct>() {
//            @Override
//            public PProduct call() throws Exception {
//                PProduct product=productService.getById(productid);
//                /*if(type==1){
//                    product=productService.getOfProxyByIdAndCityId(productid,user.getProxyCityId());
//                }else{
//                    product=productService.getById(productid);
//                }*/
//                return product;
//            }
//        };
//
//        Callable<Consignee> consigneeCallable=new Callable<Consignee>() {
//            @Override
//            public Consignee call() throws Exception {
//                return consigneeService.getByIdAndIsDeleted(cid,0);
//            }
//        };
//
//        Callable<String> orderNumberCallable=new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return orderService.getOrderNumber();
//            }
//        };
//
//        Future<PProduct> productFutureTask=poolTaskExecutor.submit(productCallable);
//        Future<Consignee> consigneeFutureTask=poolTaskExecutor.submit(consigneeCallable);
//        Future<String> orderNumberFutureTask=poolTaskExecutor.submit(orderNumberCallable);
//
//        PProduct product=null;
//        Consignee consignee=null;
//        String orderNumber=null;
//        try {
//             product=productFutureTask.get();
//             consignee=consigneeFutureTask.get();
//             orderNumber=orderNumberFutureTask.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//
//        BigDecimal totalAmount=product.getPrice().multiply(new BigDecimal(quantity));
//        if(type==1){
//            BigDecimal minusPrice=product.getMinusPrice();
//            Integer satisfyQuantity=product.getSatisfyQuantity();
//            if(minusPrice!=null&&satisfyQuantity!=null&&satisfyQuantity!=0){
//                totalAmount=totalAmount.subtract(minusPrice.multiply(new BigDecimal(quantity/satisfyQuantity)));
//            }
//        }
//
//
//        if(orderNumber==null){
//            int r=(int)((Math.random()*9+1)*100);
//            Date date=new Date();
//            DateFormat format=new SimpleDateFormat("yyMMddHHmmss");
//            orderNumber=r+format.format(date);
//        }
//
//        String uuid= UUID.randomUUID().toString();
//
//        long timestamp=System.currentTimeMillis()/1000;
//
//        String time=String.valueOf(timestamp);
//
//        String subTime=time.substring(time.length()-6);
//        String token= DigestUtils.md5Hex(appid+subTime+secret);
//
//        //博尔诚方订单
//        ThirdOrder thirdOrder=new ThirdOrder();
//        thirdOrder.setAddress(consignee.getProvince()+consignee.getCity()+consignee.getAddressInfo());
//        thirdOrder.setAppid(appid);
//        thirdOrder.setCreateAt(String.valueOf(timestamp));
//        thirdOrder.setMobile(consignee.getPhone());
//        thirdOrder.setName(consignee.getName());
//        thirdOrder.setPrice(product.getPrice());
//        thirdOrder.setQuantity(quantity);
//        thirdOrder.setSecretKey(uuid);
//        thirdOrder.setSfcode(product.getProductNumber());
//        thirdOrder.setThirdOrderNo(orderNumber);
//        thirdOrder.setToken(token);
//        thirdOrder.setTime(time);
//        thirdOrder.setUserId(user.getId());
//        thirdOrder.setTotalPrice(totalAmount);
//        thirdOrder.setBackUrl(payBackUrl+orderNumber);
//
//        //我方订单
//        Date createTime=new Date();
//        OrderInfo order=new OrderInfo();
//        order.setOrderNumber(orderNumber);
//        order.setPaymentMethod(1);
//        order.setOrderStatus(0);
//        order.setTotalAmount(totalAmount);
//        order.setCreateTime(createTime);
//        order.setUpdateTime(createTime);
//        order.setUserId(user.getId());
//        order.setProductId(productid);
//        order.setProductPrice(product.getPrice());
//        order.setQuantity(quantity);
//        order.setType(type);
//        order.setConsigneeId(cid);
//        order.setSecretKey(uuid);
//        order.setThirdTime(time);
//        order.setThirdToken(token);
//        order.setType(type);
//
//
//        Callable<JSONObject> thirdOrderCallable=new Callable<JSONObject>() {
//            @Override
//            public JSONObject call() throws Exception {
//
//                return orderService.createThirdOrder(thirdOrder,createOrderUrl);
//            }
//        };
//        Callable<Integer> orderInsertCallable=new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return orderService.insert(order);
//            }
//        };
//        Future<JSONObject> thirdOrderFuture=poolTaskExecutor.submit(thirdOrderCallable);
//        Future<Integer> orderInsertFuture=poolTaskExecutor.submit(orderInsertCallable);
//
//        JSONObject thirdResult= null;
//        int orderInsertStat=0;
//        try {
//            thirdResult = thirdOrderFuture.get();
//            orderInsertStat=orderInsertFuture.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        ApiLogs log=new ApiLogs();
//        log.setCreateTime(createTime);
//        log.setApi(createOrderUrl);
//        log.setParams(thirdOrder.toString());
//        log.setThirdResult(thirdResult.toJSONString());
//        Integer errcode=null;
//        try {
//             errcode=(Integer)thirdResult.get("errcode");
//            if(errcode==0){
//                log.setType("info");
//            }else {
//                log.setType("error");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            log.setType("error 空指针");
//        }
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                apiLogsService.insert(log);
//            }
//        };
//        poolTaskExecutor.execute(runnable);
//        if(errcode==0&&orderInsertStat>0){
//            result.ok("");
//            result.setData(order.getId());
//        }else{
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            logger.error("订单创建失败! 博尔泰方返回数据:"+result);
//            result.error("网络繁忙，请重试！");
//        }
//        return result;
//    }
//    @RequestMapping("/confirmPage")
//    public String confirmPage(Integer orderid, Model model, HttpServletRequest request, Integer cid){
//        if(cid!=null){
//            OrderInfo o=new OrderInfo();
//            o.setId(orderid);
//            o.setConsigneeId(cid);
//            orderService.updateById(o);
//        }
//        OrderInfo orderInfo=orderService.getById(orderid);
//        if(orderInfo.getConsignee()==null){
//            MemberUser memberUser=(MemberUser)request.getSession().getAttribute("userInfo");
//            List<Consignee> consigneeList=consigneeService.getConsigneeListByUid(memberUser.getId());
//            if(consigneeList!=null&&consigneeList.size()!=0){
//                if(type==1){
//                    return "redirect:/proxy/wx/consignee/listPage?orderid="+orderid;
//                }else{
//                    return "redirect:/wx/consignee/listPage?orderid="+orderid;
//                }
//            }
//            if(type==1){
//                return "redirect:/proxy/wx/consignee/add?orderid="+orderid;
//            }else{
//                return "redirect:/wx/consignee/add?orderid="+orderid;
//            }
//        }
//        String time=String.valueOf(System.currentTimeMillis()/1000);
//        String subTime=time.substring(time.length()-6);
//        String token= DigestUtils.md5Hex(appid+subTime+secret);
//        String payurl=new String(payUrl);
//        payurl=payurl.replace("{third_order_no}",orderInfo.getOrderNumber());
//        payurl=payurl.replace("{time}",time);
//        payurl=payurl.replace("{token}",token);
//        payurl=payurl.replace("{appid}",appid);
//
//        model.addAttribute("order",orderInfo);
//        model.addAttribute("product",orderInfo.getProduct());
//        model.addAttribute("quantity",orderInfo.getQuantity());
//        model.addAttribute("consignee",orderInfo.getConsignee());
//        model.addAttribute("payUrl",payurl);
//        return "order_confirm";
//    }
//
//    @RequestMapping("/noPayList")
//    public String noPayList(HttpServletRequest request, Model model){
//        MemberUser memberUser=(MemberUser)request.getSession().getAttribute("userInfo");
//        Map<String,Object> params=new HashMap<>();
//        params.put("userId",memberUser.getId());
//        params.put("orderStatus","0");
//        params.put("type",type);
//        List<OrderInfo> orderList=orderService.findUnitePro(params);
//        model.addAttribute("orderList",orderList);
//        return "order_list_no_pay";
//    }
//    @RequestMapping("/alreadyPayList")
//    public String alreadyPayList(HttpServletRequest request, Model model){
//        MemberUser memberUser=(MemberUser)request.getSession().getAttribute("userInfo");
//        Map<String,Object> params=new HashMap<>();
//        params.put("userId",memberUser.getId());
//        params.put("alreadyPay","1");
//        params.put("type",type);
//        List<OrderInfo> orderList=orderService.findUnitePro(params);
//        model.addAttribute("orderList",orderList);
//        return "order_list_already_pay";
//    }
//    @RequestMapping("/info")
//    public String info(Integer id, Model model){
//        OrderInfo orderInfo=orderService.getById(id);
//        model.addAttribute("order",orderInfo);
//        return "order_info";
//    }
//    @RequestMapping("/wait")
//    public String wait(String orderNumber, Model model){
//        model.addAttribute("orderNumber",orderNumber);
//        return "order_wait";
//    }
//    @RequestMapping("/getOrderStatus")
//    @ResponseBody
//    public Integer getOrderStatus(String orderNumber){
//        OrderInfo order=orderService.getByOrderNumber(orderNumber);
//        return order.getOrderStatus();
//    }
//}
