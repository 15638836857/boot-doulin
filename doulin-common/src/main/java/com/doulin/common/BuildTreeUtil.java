package com.doulin.common;


import com.doulin.entity.edo.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTreeUtil {

    public static <T> TreeUtil<T> build(List<TreeUtil<T>> nodes) {

        if (nodes == null) {
            return null;
        }
        List<TreeUtil<T>> topNodes = new ArrayList<TreeUtil<T>>();

        for (TreeUtil<T> children : nodes) {
            String pid = children.getParent();
            if (pid == null || "0".equals(pid)) {
                topNodes.add(children);
                continue;
            }

            for (TreeUtil<T> parent : nodes) {
                String id = parent.getValue();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                    continue;
                }
            }

        }

        TreeUtil<T> root = new TreeUtil<T>();
        if (topNodes.size() == 1) {
            root = topNodes.get(0);
        } else {
            root.setId("-1");
            root.setLabel("顶级节点");
            root.setHasParent(false);
            root.setChildren(true);
            root.setChildren(topNodes);
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
        }
        return root;
    }


}