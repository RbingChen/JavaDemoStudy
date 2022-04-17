package com.nextwork.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int currentSize=1;
        List<List<Integer>> result = new LinkedList<>();
        boolean flag = true;
        while(!queue.isEmpty()){
            int count=0;
            LinkedList<Integer> lt = new LinkedList<>();
            for(int i=0;i<currentSize;i++ ){
                TreeNode tmp = queue.poll();
                if(flag){
                    lt.offerLast(tmp.val);
                }else{
                    lt.offerFirst(tmp.val);
                }
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                    count++;
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                    count++;
                }
            }
            flag = !flag;
            result.add(lt);
            currentSize=count;
        }

        return result;
    }

    public static void main(String args[]){
        P103 p103 = new P103();
        TreeNode t = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        t.left = t1;
        t.right=t2;
        t2.left=t3;
        t2.right=t4;
        Print.printIntListListNode(p103.zigzagLevelOrder(t));

    }
}
