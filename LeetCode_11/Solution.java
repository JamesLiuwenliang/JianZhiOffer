class Solution {
    public static int minArray(int[] numbers) {

        if(numbers == null || numbers.length<=0){
            return -1;
        }

        int start = 0;
        int end = numbers.length-1;
        int mid = start;

        while(numbers[start] >= numbers[end]){
            
            if(end - start == 1){
                mid = end;
                break;
            }
            mid = (start+end)/2;

            //特殊情况下，如[1,0,1,1,1]
            if(numbers[start] == numbers[end] && numbers[mid] == numbers[end]){
                return MinInOrder(numbers,start,end);
            }


            if(numbers[mid]>=numbers[start]){
                start = mid;
            }else if(numbers[mid] <= numbers[end]){
                end = mid;
            }

        }
        return numbers[mid];

    }

    private static int MinInOrder(int[] numbers , int start,int end){
        int res = numbers[start];

        for (int i = start; i <= end; i++) {
            if(numbers[i] < res){
                res = numbers[i];
            }
        }

        return res;
    }

}