package WebTest.Offer.chap06;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 滑动窗口
public class offer57_02 {


    public static void main(String[] args) {

        int[][] res = findContinuousSequence(15);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static int[][] findContinuousSequence(int target) {

        if(target<= 0){
            return null;
        }

        List<int[]> linkedList = new ArrayList<>();

        int leftIndex = 1,rightIndex ;

        while(leftIndex <= target/2){

            int total = leftIndex;
            rightIndex = leftIndex+1;

            while(rightIndex < target){
                total += rightIndex;

                if(total < target){
                    rightIndex++;
                }else if(total == target){

                    int[] tmp = new int[rightIndex-leftIndex+1];
                    for (int i = 0; i < tmp.length; i++) {
                        tmp[i] = leftIndex+i;
                    }
                    linkedList.add(tmp);
                }else{
                    leftIndex++;
                    break;
                }


            }

        }


        return linkedList.toArray(new int[linkedList.size()][]);


    }

    // 速度快些
    public int[][] findContinuousSequence_LeetCode(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }





}
