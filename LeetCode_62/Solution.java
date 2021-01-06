import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {

//        lastRemaining(5,3);
//        System.out.println(lastRemaining_Mine(70866,116922));
//        System.out.println(lastRemaining_Mine(10,17));

        System.out.println(lastRemaining_LeetCode02(70866,116922));
        System.out.println(lastRemaining_LeetCode02(10,17));
        System.out.println("=====================================");
        System.out.println(lastRemaining_Mine(70866,116922));
        System.out.println(lastRemaining_Mine(10,17));


    }
    public static int lastRemaining_LeetCode02(int n, int m) { 
        if (n <= 1 || m <= 1) { 
            return n - 1; 
        }
        
        int pos = 0; // 最后一个元素在第 0 位
        
        for (int i = 2; i <= n; ++i) {
            // 思路应该自顶向下分析，代码则是自底向上计算
            // 本循环从计算还剩两个数字的时候，胜利者在第几位开始
            pos = (pos + m) % i;
        }
        return pos;

    }


    public static int lastRemaining_LeetCode(int n, int m) {

        if(n <= 0 || m <= 0){
            return -1;
        }else if(n == 1){
            return 0;
        }else if(m == 1){
            return n-1;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        int i = 0;

        while(arrayList.size() > 1){
            /**
             *  f(n,m) = [f(n-1,m)+m] % n , n>1
             *         = 0   , n=1
             *  时间复杂度是O(n)，空间复杂度是O(1)
             */
            i = (i + m - 1) % arrayList.size();

            arrayList.remove(i);
        }

        return arrayList.get(0);

    }

    static class Node62{
        int val ;
        Node62 next;
        Node62(int val){
            this.val = val;
        }
    }



    public static int lastRemaining_Mine(int n, int m) {

        if(n <= 0 || m <= 0){
            return -1;
        }

        if(n == 1){
            return 0;
        }

        if(m == 1){
            return n-1;
        }

        Node62 head = new Node62(0);
        Node62 tmp = head;
        for (int i = 1; i < n; i++) {
            tmp.next = new Node62(i);
            tmp = tmp.next;
        }
        tmp.next = head;

        int total = n;

        Node62 pDelete = head;
        Node62 pHelper = head;

        while(--total != 0){

            for (int i = 1; i < m-1;i++ ) {
                pHelper = pHelper.next;
                pDelete = pDelete.next;
            }
            pDelete = pDelete.next;


            pHelper.next = pDelete.next;
            pDelete = pDelete.next;
            pHelper = pDelete;


        }

        
        return pDelete.val;
        


    }


}
