package com.griftt.server.algorithm;

import lombok.Data;

@Data
public class TreeNode {

    private Integer value;
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;

    public TreeNode(Integer value) {
        this.value = value;
    }
}
