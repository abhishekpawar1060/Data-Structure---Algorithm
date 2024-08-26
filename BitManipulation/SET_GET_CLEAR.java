public class SET_GET_CLEAR {
    public static void main(String[] args) {
        int num = 70;
        int i = 3; //ith Bit

        int Get = (num & (1 << i-1)) != 0 ? 1 : 0;
        
        int Set = num | (1 << i-1);
        
        int Clear = num & ~(1 << i-1);
        
        int Toggle = num ^ (1 << i-1);
        
        int removeLastSetBit = (num & num-1);    //RightMost 1 into 0;
        
        System.out.print("GET : "+Get+ " SET: " +Set+ " Clear: " +Clear+ " Toggle: "+Toggle);
    }
}
