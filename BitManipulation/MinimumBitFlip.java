public class MinimumBitFlip {
    public static void main(String[] args) {
        int num = 30;
        int goal = 35;

        int n = num ^ goal;
        int count = 0;
        while(n > 0){
            count += n & 1;
            n = n >> 1;
        }

        System.out.println(count);
    }
}
