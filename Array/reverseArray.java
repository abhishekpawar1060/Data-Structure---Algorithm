public class reverseArray {

    public static void revArray(int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int  temp = arr[i]; 
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i -1] = temp;
        }


        for (int val : arr) {
            System.out.print(val+ " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,6};

        revArray(arr);
    }
    
}
