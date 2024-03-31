public class fabonacciNo {
    public static int fabonacci(int n){
        
        // int[] dp = new int[n+1];
        // dp[0] = 0;
        // dp[1] = 1;

        int prevOfprev = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            //dp[i] = dp[i-1] + dp[i-2];

            int temp = prev + prevOfprev;
            prevOfprev = prev;
            prev = temp;
        }

        //return dp[dp.length-1];
        return prev;
    }

    public static void main(String[] args) {
        
        System.out.println(fabonacci(6));
    }
}
