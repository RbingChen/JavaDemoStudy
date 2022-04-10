package com.nextwork.leetcode;

import java.util.Stack;
/**
 * https://www.bilibili.com/video/BV13g41157hK?p=6
 * 递归式都可以使用栈来实现
 * https://blog.csdn.net/woshinidadaye_/article/details/111866332
 * */
public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      public void preOrderSimple(TreeNode node){
            if(node==null) return;
            System.out.println(node.val);
            preOrderSimple(node.left);
            preOrderSimple(node.right);
      }
      public void midOrderSimple(TreeNode node){
            if(node==null) return;
            midOrderSimple(node.left);
            System.out.println(node.val);
            midOrderSimple(node.right);
      }
      public void afterOrderSimple(TreeNode node){
            if(node==null) return;
            afterOrderSimple(node.left);
            afterOrderSimple(node.right);
            System.out.println(node.val);
      }
      public void allOrder(TreeNode node){

            Stack<TreeNode> st = new Stack<>();
            while(node!=null){
                  st.push(node);
                  node = node.left;
            }
            while(!st.isEmpty()){
                  TreeNode t = st.peek();
                  TreeNode nr = t.right;
                  st.pop();
                  while(nr!=null){
                        st.push(nr);
                        nr = nr.left;
                  }
            }
      }
      public void preOrder(TreeNode node){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            while(!stack.isEmpty()){
                  TreeNode t = stack.pop();
                  System.out.println(t.val);
                  if(t.right!=null) stack.push(t.right);
                  if(t.left!=null) stack.push(t.left);

            }
      }


      public void midOrder(TreeNode node){

      }

      public void afterOrder(TreeNode node){
            /*
             *  if(t.left!=null) xxxx
             *  if(t.right!=null) xxxx
             * */
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(node);
            while(!stack1.isEmpty()){
                  TreeNode t = stack1.pop();
                  stack2.push(t);
                  if(t.left!=null){
                        stack1.push(t.left);
                  }
                  if(t.right!=null){
                        stack1.push(t.right);
                  }
            }
            while(!stack2.isEmpty()){
                  System.out.println(stack2.pop().val);
            }
      }


  }