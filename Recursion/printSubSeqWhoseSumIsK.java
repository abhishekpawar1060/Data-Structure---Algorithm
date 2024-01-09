import java.util.ArrayList;

public class printSubSeqWhoseSumIsK {

    public static void printAllSubSeq(int idx,int[] arr,ArrayList<Integer> list,int s,int sum){
        int n = arr.length;
        if(idx == n){
            if(s == sum){
                for (int val : list) {
                    System.out.print(val+ " ");
                }    
                System.out.println();
            }
            return;
        }
        list.add(arr[idx]);
        s += arr[idx];

        printAllSubSeq(idx+1, arr, list, s, sum);

        s -= arr[idx];
        list.remove(list.size()-1);

        printAllSubSeq(idx+1, arr, list, s, sum);

    }

    public static int countSubSeq(int idx,int[] arr,int s,int sum){
        int n = arr.length;
        
        if(s > sum){
            return 0;
        }

        if(idx == n){
            if(s == sum){
                return 1;
            }
            else{
                return 0;
            }
        }

        s += arr[idx];

        int left = countSubSeq(idx+1, arr, s, sum);

        s -= arr[idx];

        int right = countSubSeq(idx+1, arr, s, sum);


        return left + right;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int n = arr.length;
        int sum = 2;
        ArrayList<Integer> list = new ArrayList<>();

        printAllSubSeq(0,arr,list,0,sum);


        System.out.println("The count of SubSequence : " +countSubSeq(0, arr, 0, sum));
    }
}