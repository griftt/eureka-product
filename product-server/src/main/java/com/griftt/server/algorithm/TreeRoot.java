package com.griftt.server.algorithm;

public class TreeRoot {

    private TreeNode treeNode;

    public TreeRoot(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public static TreeRoot createNewRoot(TreeNode treeNode){
        return new TreeRoot(treeNode);
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }
}
