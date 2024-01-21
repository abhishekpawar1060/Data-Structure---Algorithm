// Non-comparison sorting algorithm
//Small numbers.

import java.util.Arrays;
import java.util.HashMap;

public class CountSort {
    
    public static void countSort(int[] arr){
        if(arr == null &&  arr.length <= 1){
            return;
        }
        
        int max = arr[0];
        for(int val : arr){
            if(val > max){
               max = val; 
            }
        }

        int[] countArray = new int[max + 1];
        for(int it : arr){
            countArray[it]++;
        }

        int idx = 0;
        for(int i = 0; i <= max; i++){
            while(countArray[i] > 0){
               arr[idx] = i;
               idx++;
               countArray[i]--; 
            }
        }
    }

    public static void countSortHash(int[] arr){
        if(arr == null && arr.length < 1){
            return;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int idx = 0;
        for (int i = min; i <= max; i++) {
           int count = map.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                arr[idx] = i;
                idx++;
            }
        }


    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,0,3,1,5,1,6};

        countSort(arr);

        //countSortHash(arr);

        
        System.out.println(Arrays.toString(arr));
    }
}