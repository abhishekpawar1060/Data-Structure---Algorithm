import java.sql.Array;
import java.util.Arrays;

public class SingleNo {

    private static int singleNo_I(){
        int[] arr = {1, 2, 4, 6, 2, 1, 6};
        int res = 0;
        for(int it : arr){
            res = res ^ it;
        }
        return res;
    }

    private static int singleNo_II(){
        int[] arr = {1, 3, 4, 1, 4, 3, 1, 3, 6, 4, 6, 6, 5};
        // int res = 0;
        // for(int bitIdx = 0; bitIdx <= 31; bitIdx++){
        //     int cnt = 0;
        //     for(int i = 0; i < arr.length; i++){
        //         if((arr[i] & (1 << bitIdx)) != 0){
        //             cnt++;
        //         }
        //     }
        //     if(cnt % 3 == 1){
        //         res = (res | (1 << bitIdx));
        //     }
        // }
        // return res;

        //Second Solution
        // Arrays.sort(arr);
        // for(int i = 1; i < arr.length; i+=3){
        //     if(arr[i] != arr[i-1]){
        //         return arr[i-1];
        //     }
        // }
        // return arr[arr.length-1];


        //3rd Solution
        int ones = 0;
        int twos = 0;

        for(int i = 0; i < arr.length; i++){
            ones = (ones ^ arr[i]) & ~twos;
            twos = (twos ^ arr[i]) & ~ones;
        }

        return ones;
    }
    public static void main(String[] args) {
        System.out.println(singleNo_I());
        System.out.println(singleNo_II());
    }
}
