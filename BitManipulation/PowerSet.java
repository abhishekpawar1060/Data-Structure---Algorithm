import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;
        int subsets = 1 << n; // 2^n
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < subsets; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    temp.add(arr[j]);
                }
            }
            list.add(temp);
        }

        System.out.println(list.toString());
    }
}
