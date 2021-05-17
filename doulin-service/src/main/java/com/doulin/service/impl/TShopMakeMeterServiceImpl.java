package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.common.zxing.ZXCodeUtil;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.TShopMakeMeter;
import com.doulin.entity.image.ImgDoConfig;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopMakeMeterMapper;
import com.doulin.service.ShopToTreeService;
import com.doulin.service.TShopHomeBaseInfoService;
import com.doulin.service.TShopMakeMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
* TShopMakeMeterServiceImpl
* @Author malinging
* @Date 2021-05-04
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopMakeMeterServiceImpl extends ServiceImpl<TShopMakeMeterMapper, TShopMakeMeter> implements TShopMakeMeterService {
    @Autowired
    private TShopMakeMeterMapper tShopMakeMeterMapper;
    @Autowired
    private ImgDoConfig imgDoConfig;
    @Autowired
    private TShopHomeBaseInfoService tShopHomeBaseInfoService;
    @Autowired
    private ShopToTreeService shopToTreeService;

    @Override
    public IPage<TShopMakeMeter> page(VQuery query) {
        IPage<TShopMakeMeter> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void saveAndUpdate(String oper, TShopMakeMeter tShopMakeMeter) throws Exception {
        //商家编码
        String shopHomeCode = tShopMakeMeter.getShopHomeCode();
        //定制类型
        String type = tShopMakeMeter.getDzType();
        TShopMakeMeter smm = getInfoByShopHomeCodeAndTypeId(shopHomeCode, type);
        makeQrcodeByHomeCode(oper,tShopMakeMeter);
        if (SysContent.OPER_ADD.equals(oper)) {
            if (null != smm) {
                throw new Exception(SysContent.ERROR_EXISIS);
            }
            save(tShopMakeMeter);
        } else if (SysContent.OPER_EDIT.equals(oper)) {
            if (null == tShopMakeMeter.getId()) {
                throw new Exception(SysContent.ERROR_ID);
            } else if (!tShopMakeMeter.getId().equals(smm.getId())) {
                throw new Exception(SysContent.ERROR_EXISIS);
            } else {
                updateById(tShopMakeMeter);
            }
        } else {
            throw new Exception(SysContent.ERROR_OPER);
        }

    }

    @Override
    public TShopMakeMeter getInfoByShopHomeCodeAndTypeId(String shopHomeCode, String type) {

        return tShopMakeMeterMapper.selectInfoByShopHomeCodeAndTypeId(shopHomeCode,type);
    }

    @Override
    public void  makeQrcodeByHomeCode(String oper,TShopMakeMeter tShopMakeMeter) throws Exception {
        /************************正式******************/
//        String sykQrCodeId=tShopMakeMeter.getQrcodeIds(),   merSn=tShopMakeMeter.getAddBy();
//        Integer typeId=SysContent.OPER_ADD.equals(oper)?SysContent.INTGER_0:SysContent.INTGER_1;
//       // {"detail_error_code":"","detail_error_des":"","sn":"BBN286L60","ImgUrl":"a.xfpay.cn/Qrcode/20/BBN286L60.jpg"}
//        Map<String,Object> map=shopToTreeService.qrcode(typeId,sykQrCodeId,merSn);
//        String sn=map.get("sn").toString();
//        String imgUrl=map.get("ImgUrl").toString();
//        tShopMakeMeter.setQrcode(imgUrl);
//        tShopMakeMeter.setQrcodeIds(sn);


        /************************测试******************/
        //二维码内容
        String content="http://wwww.baidu.com";
        //图片类型
        String imagType="png";
        //图片路径  真实路径+商家编码+物料类型+二维码图片名称.png
        String realPath=tShopMakeMeter.getShopHomeCode()
                        +"/"+tShopMakeMeter.getDzType()+"/"
                        +tShopMakeMeter.getShopHomeCode()+"."
                        +imagType;
        //存入数据库路径
        String dburl=imgDoConfig.getPrefix()+realPath;
        //存入硬盘路径
        String dirpath=imgDoConfig.getFilePath()+realPath;
        //查询 商家logo
        TShopHomeBaseInfo tShopHomeBaseInfo=tShopHomeBaseInfoService.getInfoByShopHomeCode(tShopMakeMeter.getShopHomeCode());
        //设置商家二维码logo
        String logoPath=tShopHomeBaseInfo.getShopLogo().replace(imgDoConfig.getPrefix(),imgDoConfig.getFilePath());
        //制作商家二维码
        ZXCodeUtil.encodeImage(dirpath,imagType,content,300,300,logoPath);
        tShopMakeMeter.setQrcode(dburl);

    }

    @Override
    public IPage<TShopMakeMeter> pageInfo(Map<String, Object> map) {
        List<TShopMakeMeter> list=getPageList(map);
        Integer total=getCount(map);
        IPage<TShopMakeMeter> page=new Page<>();
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setTotal(Long.valueOf(total));
        page.setRecords(list);
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        return page;
    }
    @Override
    public List<TShopMakeMeter> getPageList(Map<String, Object> map) {
        return  tShopMakeMeterMapper.selectPageList(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return tShopMakeMeterMapper.selectPageCount(map);
    }

}