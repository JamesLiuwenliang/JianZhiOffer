

import DataStruct.ThreadedBinaryTree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {4,5,1,2,2,7,3,8};
        int[] result = getLeastNumbers_Book(nums,4);



        System.out.println(Arrays.toString(result));

    }

    // 这种算法最大的问题是改变了原来的数组
    public static int[] getLeastNumbers(int[] arr, int k) {

        if(arr == null || arr.length<k){
            return null;
        }

        int[] result = new int[k];
        int index = 0;

        Arrays.sort(arr);

        for (int i = 0; i < k; i++) {
            result[index++] = arr[i];
        }

        return result;

    }

    // O(nlogk),用二叉树实现替换操作是O(logk)
    public static int[] getLeastNumbers_Book(int[] arr, int k){


        if(arr == null || arr.length<k || k==0){
            return new int[0];
        }

        int[] result = new int[k];


        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);


        for (int i = 0; i < arr.length; i++) {
            if(i<k){
                pq.offer(arr[i]);
            }else{

                if(pq.peek() > arr[i]){
                    pq.poll();
                    pq.offer(arr[i]);
                }

            }

        }

        int index = 0;
        for (Integer integer : pq) {
            result[index++] = integer;
        }


        return result;


    }
}
