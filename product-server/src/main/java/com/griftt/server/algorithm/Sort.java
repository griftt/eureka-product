package com.griftt.server.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    private static List<Integer> list=new ArrayList<>();

    public void heapSort(){
        int[] array = new int[]{167,5,34,32,78,31};

    }
    /**
     * 动态创建二叉查找树
     */
    public static  TreeNode buildTree(){
        int[] array = new int[]{17,5,34,32,78,31};
        TreeRoot newRoot = TreeRoot.createNewRoot(new TreeNode(array[0]));
        TreeNode node=newRoot.getTreeNode();
        for (int i=1;i<array.length;i++){
            insertNode(node,array[i]);
        }
        return node;

    }

    /**
     * 中序遍历二叉树
     */
    public static  List<Integer> getRange(TreeNode root){
        TreeNode leftTreeNode = root.getLeftTreeNode();
        TreeNode rightTreeNode = root.getRightTreeNode();
        Integer value = root.getValue();


        if(leftTreeNode!=null){
            //递归
            getRange(leftTreeNode);
        }
        Integer rootValue = root.getValue();
        list.add(rootValue);
        if(rightTreeNode!=null){
            //递归
            getRange(rightTreeNode);
        }
        return list;
    }

    /**
     * 插入子节点
     * @param treeNode
     * @param value
     * @return
     */
    public static  TreeNode insertNode(TreeNode treeNode, Integer value){
        TreeNode newNode = null;
        //判断左子树
        Integer treeNodeValue = treeNode.getValue();
        TreeNode treeNodeLocation = value.compareTo(treeNodeValue) >= 0 ? treeNode.getRightTreeNode() : treeNode.getLeftTreeNode();
        if(treeNodeLocation==null){
            treeNodeLocation=new TreeNode(value);
            if(value.compareTo(treeNodeValue) >= 0 ){
                treeNode.setRightTreeNode(treeNodeLocation);
            }else {
                treeNode.setLeftTreeNode(treeNodeLocation);
            }
        }else {
            newNode=insertNode(treeNodeLocation,value);
        }
        return newNode;
    }

    public static void main(String[] args) {
        TreeNode node = buildTree();
        List<Integer> range = getRange(node);
        System.out.println(range);
    }


}
