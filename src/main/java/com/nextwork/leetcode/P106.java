package com.nextwork.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P106 {
    Map<Integer,Integer> ind = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 && postorder.length==0) return null;
        for(int i=0;i<inorder.length;i++){
            ind.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode helper(int[] inorder,int ib,int ie,int []postorder,int pb,int pe){
        if(pb<pe) return null;
        int val = postorder[pe];
        int mid = ind.get(val);
        TreeNode root = new TreeNode(val);
        root.left = helper(inorder,ib,mid-1,postorder,pb,pb+mid-ib-1);
        root.right = helper(inorder,mid+1,ie,postorder,pb+mid-ib,pe-1);
        return root;
    }


    public static void main(String args[]){

    }
}
