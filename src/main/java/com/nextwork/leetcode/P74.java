package com.nextwork.leetcode;

public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n=matrix[0].length;
        if(n==1 && m==1) return matrix[0][0]==target;
        int topR = 0,topC = 0;
        int botR = m-1,botC=n-1;
        while(topR<=botR && topC<=botC){
            int midR = (topR+botR)/2;
            int midC = (topC+botC)/2;
            int val = matrix[midR][midC];
            if((topR+1==botR&& topC+1==botC)
               || (topR==botR&& topC+1==botC)
                    || (topR+1==botR&& topC==botC)
            ){
                if(matrix[topR][topC]==target || matrix[botR][botC]==target) return true;
                if((topR+1<m && matrix[topR+1][topC]==target) || (topC+1<n && matrix[topR][topC+1]==target)) return true;
                return false;
            }
            if(val==target) return true;
            else if(val > target){
                botR = midR;
                botC = midC;
            }else{
                topR = midR;
                topC = midC;
            }
        }
        return false;
    }
    public boolean searchMatrixV2(int[][] matrix, int target) {
        int rows = matrix.length - 1, columns = 0;
        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                return true;
            } else if (num > target) {
                rows--;
            } else {
                columns++;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int nums[][] = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        P74 p74 = new P74();
        System.out.println(p74.searchMatrix(nums,5));
        //System.out.println(p74.searchMatrix(nums,3));
        int nums2[][] = new int[][]{{1,1}};
       // System.out.println(p74.searchMatrix(nums2,0));

    }
}
