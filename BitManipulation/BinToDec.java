import java.lang.Math;
public class BinToDec {

    static private int Dec(String s){
        int res = 0;
        int p2 = 1;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                res += p2;
            }
            p2 = p2 * 2;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Dec("1000"));
    }
}
