public class selectionSort {

    private static void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int idx = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[idx]){
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,6,9,6,8,1,3,7};

        sort(arr);

        for (int it : arr) {
            System.out.print(it+ " ");
        }




    }
    
}
