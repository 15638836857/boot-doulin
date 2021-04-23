package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.BuildTree;
import com.doulin.common.MyException;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysMenu;
import com.doulin.entity.edo.MenuTree;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysMenuMapper;
import com.doulin.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 系统菜单业务事项类
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public IPage<SysMenu> page(VQuery query) {
        IPage<SysMenu> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public Set<String> listPerms(Long userId) {
        List<String> perms = menuMapper.listUserPerms(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public void addAndUpdateParam(String oper,SysMenu sysMenu) throws MyException {
        if(StrUtil.isEmpty(sysMenu.getName())){
            throw new MyException(SysContent.ERROR_MENU_NAME);
        }else if(null==sysMenu.getType()){
            throw new MyException(SysContent.ERROR_MENU_TYPE);
        }
        if(SysContent.OPER_ADD.equals(oper)){
            if(null!=getOneByMenuNameOrId(null,sysMenu.getName(),sysMenu.getType())){
                throw new MyException(SysContent.ERROR_MENU_EXSIS);
            }
        }else if(SysContent.OPER_EDIT.equals(oper)){
            if(null==sysMenu.getId()){
                throw new MyException(SysContent.ERROR_ID);
            }else{
                SysMenu sm=getOneByMenuNameOrId(null,sysMenu.getName(),sysMenu.getType());
                if(null!=sm && sysMenu.getId().equals(sm.getId())){
                    throw new MyException(SysContent.ERROR_MENU_EXSIS);
                }
            }
        }

    }

    @Override
    public SysMenu getOneByMenuNameOrId(Integer id, String menuName,Integer type) {
        QueryWrapper<SysMenu> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
        if(null!=id) {
            queryWrapper.eq(SysContent.ID_STR, id);
        }
        if(StrUtil.isNotEmpty(menuName)){
            queryWrapper.eq(SysContent.NAME_STR, menuName);
            queryWrapper.eq(SysContent.TYPE_STR, type);
        }
        return getOne(queryWrapper);
    }

    @Override
    public SysMenu getInfoById(Integer id) {
        return menuMapper.selectInfoById(id);
    }

    @Override
    public List<SysMenu> getListByPid(Integer pid) {
        return menuMapper.selectByPid(pid);
    }

    @Override
    public MenuTree<SysMenu> getTree(){
        List<MenuTree<SysMenu>> trees = new ArrayList<MenuTree<SysMenu>>();
        List<SysMenu> menuDOs =list(new QueryWrapper<SysMenu>().eq(SysContent.DEL_FLAG,SysContent.INTGER_0));
        for (SysMenu sysMenuDO : menuDOs) {
            MenuTree<SysMenu> tree = new MenuTree<SysMenu>();
            tree.setId(sysMenuDO.getId().toString());
            tree.setParentId(sysMenuDO.getParentId().toString());
            tree.setName(sysMenuDO.getName());
            tree.setInfo(sysMenuDO.getInfo());
            tree.setView(sysMenuDO.getView());
            tree.setIcon(sysMenuDO.getIcon());
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        MenuTree<SysMenu> t = BuildTree.buildMenu(trees);
        return t;
    }

}