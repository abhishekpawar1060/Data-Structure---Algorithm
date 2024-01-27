//Maximum Subarray sum

import java.util.ArrayList;

public class kadanesAlgorithm{

    public static int bruteForce(int[] arr){
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }


    public static long kadaneAlgo(int[] arr){ 
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum > maxSum){
                maxSum = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        if(maxSum < 0){
            return 0;
        }

        return maxSum;
    }

    //Print arr of maximum subarray sum
    public static ArrayList<Integer> printMaxSubArrSum(int[] arr){ 
        ArrayList<Integer> res = new ArrayList<>();
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        int startIdx = -1;
        int endIdx = -1;
        int start = -1;


        for (int i = 0; i < arr.length; i++) {

            if(sum == 0){
                start = i;
                
            }

            sum += arr[i];

            if(sum > maxSum){
                maxSum = sum;
                startIdx = start;
                endIdx = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        
        for (int i = startIdx; i <= endIdx; i++) {
            res.add(arr[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {-2,-3, 4, -1, -2, 1, 5, -3};

        System.out.println("Max Sum of SubArray : " +bruteForce(arr));

        System.out.println("Max subArray sum is : " +kadaneAlgo(arr));


        System.out.println(printMaxSubArrSum(arr));
    }
}