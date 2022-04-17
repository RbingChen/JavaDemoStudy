package com.nextwork.leetcode;

public class P98 {
    public boolean isValidBST(TreeNode root) {

        return support(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean support(TreeNode root,long lower,long high){
        if(root==null) return true;
        if(root.val <= lower || root.val >= high) return false;
        return support(root.left,lower,root.val) && support(root.right,root.val,high);
    }

    public static void main(String args[]){

    }
}
