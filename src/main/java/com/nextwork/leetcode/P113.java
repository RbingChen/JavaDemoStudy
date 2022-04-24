package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P113 {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        support(root,targetSum,new ArrayList());
        return result;
    }

    public void support(TreeNode root, int left, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        if(left-root.val==0 && root.left==null && root.right==null){

            List<Integer> lt = new ArrayList();
            lt.addAll(list);
            result.add(lt);
        }
        if(root.left!=null){
            support(root.left,left - root.val,list);
        }
        if(root.right!=null){
            support(root.right,left - root.val,list);
        }
        list.remove(list.size()-1);

    }
    public static void main(String args[]){
        P113 p113 = new P113();
        TreeNode t = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(11);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(2);
        t.left = t1;
        t1.left=t2;
        t2.left=t3;
        t2.right=t4;
        Print.printIntListListNode(p113.pathSum(t,22));

    }
}
