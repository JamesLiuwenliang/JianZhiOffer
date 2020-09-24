import java.util.*;

public class Solution{

    public static void main(String[] args) {
        PrintToMaxOfNDigits(3);

        // 递归实现
        printToMaxOfDigits(2);
    }


    public static void PrintToMaxOfNDigits(int n){
        if(n<=0){
            return ;
        }

        char[] number = new char[n];

        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }

        while(!Increment(number)){
            PrintNum(number);
        }

    }

    public static boolean Increment(char[] number){
        boolean isOverflow = false;
        int nTakeOver = 0 ; // 进位
        for (int i = number.length-1; i >= 0  ; i--) {

            int nSum = number[i]-'0'+nTakeOver;
            if(i == number.length-1){
                nSum ++;
            }

            if(nSum >= 10){
                if(i==0){
                    isOverflow = true;
                }else{
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0'+ nSum);
                }
            }else{
                number[i] = (char) ('0'+nSum);
                break;
            }

        }

        return isOverflow;

    }

    public static void PrintNum(char[] number){
        boolean isBeginning = true;
        for (int i = 0; i < number.length; i++) {
            if(isBeginning && number[i] != '0'){
                isBeginning = false;
            }
            if(!isBeginning){
                System.out.print(number[i]);
            }
        }

        System.out.println();

    }

    // 递归实现
    public static void printToMaxOfDigits(int n){
        if(n<=0){
            return ;
        }

        char[] number = new char[n];

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i+'0');
            printToMaxOfDigitsRecursively(number,0);

        }


    }

    public static void  printToMaxOfDigitsRecursively(char[] number,int index){
        if(index == number.length-1){
            PrintNum(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index+1] = (char) (i+'0');
            printToMaxOfDigitsRecursively(number,index+1);
        }
    }




}

