package com.doulin.entity.edo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @className MenuTree
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/21 15:42
 * @Version 1.0
 */
public class MenuTree<T> {
    /**
     * 节点ID
     */
    private String id;
    /**
     * 显示节点文本
     */
    private String info;
    private String icon;
    private Integer sort;
    /**
     * 节点状态，open closed
     */
    private Map<String, Object> state;
    /**
     * 节点是否被选中 true false
     */
    private boolean checked = false;
    /**
     * 节点属性
     */
    private Map<String, Object> attributes;

    /**
     * 节点的子节点
     */
    private List<MenuTree<T>> childList = new ArrayList<MenuTree<T>>();
    private String view;
    private String name;

    public List<MenuTree<T>> getChildList() {
        return childList;
    }

    /**
     * 父ID
     */
    private String parentId;
    /**
     * 是否有父节点
     */
    private boolean hasParent = false;
    /**
     * 是否有子节点
     */
    private boolean hasChildren = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }



    public void setChildList(List<MenuTree<T>> childList) {
        this.childList = childList;
    }

    public boolean isHasParent() {
        return hasParent;
    }

    public void setHasParent(boolean isParent) {
        this.hasParent = isParent;
    }


    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setChildren(boolean isChildren) {
        this.hasChildren = isChildren;
    }
    public List<MenuTree<T>> getChildren() {
        return childList;
    }

    public void setChildren(List<MenuTree<T>> children) {
        this.childList = children;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public MenuTree(String id, String info, Map<String, Object> state, boolean checked, Map<String, Object> attributes,
                List<MenuTree<T>> childList, boolean isParent, boolean isChildren, String parentID) {
        super();
        this.id = id;
        this.info = info;
        this.state = state;
        this.checked = checked;
        this.attributes = attributes;
        this.childList = childList;
        this.hasParent = isParent;
        this.hasChildren = isChildren;
        this.parentId = parentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getView() {
        return view;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public void setView(String view) {
        this.view = view;
    }

    public MenuTree() {
        super();
    }

    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
