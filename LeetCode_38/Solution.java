package WebTest.Offer.chap04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* 
递归回溯：那么我们首先让 a 在第 0 位，再让 b 在第 0 位，再让 c 在第 0 位。

       - a 在第 0 位，那么还剩 bc。我们先放 b 在第 1 位，再让 c 在第 1 位。
              b 在第 1 位，那么还剩 c。最终结果：abc。
              c 在第 1 位，那么还剩 b。最终结果：acb。
       - b 在第 0 位，那么还剩 ac。我们先放 a 在第 1 位，再让 c 在第 1 位。
              a 在第 1 位，那么还剩 c。最终结果：bac。
              c 在第 1 位，那么还剩 a。最终结果：bca。
       - c 在第 0 位，那么还剩 ba。我们先放 b 在第 1 位，再让 a 在第 1 位。
              b 在第 1 位，那么还剩 c。最终结果：cba。
              a 在第 1 位，那么还剩 a。最终结果：cab。
*/


public class Solution {

    public static List<String> res = new LinkedList<>();
    public static char[] c;

    public static void main(String[] args) {

        String s = "abcd";
        String[] strings = permutation(s);

//        for (String string : strings) {
//            System.out.println(string);
//        }

        System.out.println("Hello");

    }


    public static String[] permutation(String s) {

        if(s == null){
            return null;
        }

        c = s.toCharArray();
        permutationMain(0);

        return res.toArray(new String[res.size()]);

    }
    // beginS1 代表字符串的固定位
    public static void permutationMain(int beginS1){

        // 代表所有位已经固定，可以添加字符串
        if(beginS1 == c.length-1){
            System.out.println(String.valueOf(c));
            res.add(String.valueOf(c)); // 添加排列
            return;
        }

        HashSet<Character> set = new HashSet<>();

        // 将beginS1与i字符相互交换
        for (int i = beginS1 ; i < c.length; i++) {

            // 剪枝
            if(set.contains(c[i])){
                continue;
            }

            set.add(c[i]);
//            System.out.print(c[i]+" "+c[beginS1]+" ");
//            System.out.println(i+" "+beginS1);
            swap(i,beginS1);

            // 这个函数代表进入下一层递归，也就是控制第二个固定位
            permutationMain(beginS1+1);

            /*
             * 返回时交换回来，这样保证到达第1层的时候，一直都是abc。这里捋顺一下，开始一直都是abc，那么第一位置总共就3个交换
             * 分别是a与a交换，这个就相当于 x = 0, i = 0;
             *      a与b交换            x = 0, i = 1;
             *      a与c交换            x = 0, i = 2;
             * 就相当于上图中开始的三条路径
             * 第一个元素固定后，每个引出两条路径,
             *     b与b交换            x = 1, i = 1;
             *     b与c交换            x = 1, i = 2;
             */
            swap(i,beginS1);
        }




    }

    public static void swap(int a ,int b){

        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }







}
