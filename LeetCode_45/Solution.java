import javax.jnlp.ClipboardService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static int[] nums ;

    public static List<String> list = new LinkedList<>();

    public static String minString;

    public static void main(String[] args) {
        int[]  nums = {9,3,5,34,30};

        // 回溯算法
        System.out.println(minNumber(nums));

        System.out.println("---------------");
        // 贪心算法

        System.out.println(minNumber_Book(nums));



    }

  


    public static String minNumber(int[] numbers) {

        if(numbers == null){
            return new String();
        }
        nums = numbers;

        minString = myToString(nums);
        minNumber_Helper(0);

        return minString;

    }

    private static void minNumber_Helper(int beginIndex){

        if(beginIndex == nums.length-1){
            String tmp = myToString(nums);

            if(minString.compareTo(tmp) > 0 ){
                minString = tmp;
            }
            list.add(myToString(nums));


            return ;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = beginIndex; i < nums.length; i++) {

            if(hashSet.contains(nums[i])){
                continue;
            }
            hashSet.add(nums[i]);

            swap(i,beginIndex);
            minNumber_Helper(beginIndex+1);
            swap(i,beginIndex);

        }

    }


    public static void swap(int a ,int b){

        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private static String myToString(int[] nums){


        StringBuffer stringBuffer = new StringBuffer();
        for (int num : nums) {
            stringBuffer.append(num);
        }
        return stringBuffer.toString();
    }

    public static String minNumber_Book(int[] numbers){

        if(numbers == null || numbers.length==0){
            return new String();
        }

        String[] strings = new String[numbers.length];


        for (int i = 0; i < numbers.length; i++) {
            strings[i] = Integer.toString(numbers[i]);
        }

        qSort(strings);

        StringBuffer stringBuffer = new StringBuffer();


        for (int i = 0; i < strings.length ; i++) {
            stringBuffer.append(strings[i]);
        }


        return stringBuffer.toString();


    }

    private static void qSort(String[] strings){

        // 冒泡排序,排出来是从小到大的 [30,3,34,5,9],直接从0开始append就可以
        for (int i = 0; i < strings.length-1; i++) {

            for (int j = 0; j < strings.length-i-1; j++) {
                String s1 = strings[j] + strings[j+1];
                String s2 = strings[j+1] + strings[j];
                // 是利用贪心算法总结出来的下面的公式
                // s1 < s2 ==> strings[i] < strings[j]
                if(s1.compareTo(s2) > 0){
                    String tmp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = tmp;

                }
            }

        }

    }

}
