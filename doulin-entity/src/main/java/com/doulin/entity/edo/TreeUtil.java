package com.doulin.entity.edo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * tree TODO <br>
 * 
 * @author kangxu2 2017-1-7
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeUtil<T> {
	/**
	 * 节点ID
	 */
	private String id;
	/**
	 * 显示节点文本
	 */
	private String label;

	private String value;

	private String parent;

	private List<TreeUtil<T>> children = new ArrayList<TreeUtil<T>>();
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



	public List<TreeUtil<T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeUtil<T>> children) {
		this.children = children;
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




	@Override
	public String toString() {

		return JSON.toJSONString(this);
	}

}