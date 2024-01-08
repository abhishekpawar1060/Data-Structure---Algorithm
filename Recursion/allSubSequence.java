import java.util.ArrayList;

public class allSubSequence {

    public static void subSeq(int idx,ArrayList<Integer> list,int[] arr,int n){
        if(idx == n){
            for(int val : list){
                System.out.print(val+ " ");
            }
            if(list.size() == 0){
                System.out.print("{}");
            }
            System.out.println();
            return;
        }

        list.add(arr[idx]);
        subSeq(idx+1, list, arr,n);
        list.remove(list.size()-1);
        subSeq(idx+1, list, arr,n);

    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        subSeq(0, list, arr,n);

    }    
}
