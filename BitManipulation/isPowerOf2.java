public class isPowerOf2 {
    
    static public boolean isPowOf2(int n){
        if((n & n-1) == 0){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(isPowOf2(4));
        System.out.println(isPowOf2(6));
    }
}
