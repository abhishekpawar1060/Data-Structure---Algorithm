public class XORofNumInRange {
    private static int calculateXor(int n){
        if(n % 4 == 1){
            return 1;
        }else if(n % 4 == 2){
            return n+1;
        }else if(n % 4 == 3){
            return 0;
        }else{
            return n;
        }
    }
    public static void main(String[] args) {

        // For 1 to N xor opeartion;
        int N = 7;
        int xor = calculateXor(6);

        System.out.println("Xor of 1 to N is: " +xor);

        //XOR of in range L to R is 
        int L = 4;
        int R = 8;

        int xor1 = calculateXor(L-1) ^ calculateXor(R);

        System.out.println("XOR of L to R Range is: "+xor1);
    }
}
