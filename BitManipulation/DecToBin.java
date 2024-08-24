public class DecToBin {

    static private String Binary(int n){
        StringBuilder res = new StringBuilder();
        while(n != 1){
            int val = n % 2;
            res.append(val);
            n = n / 2;
        }
        res.append(n);
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(Binary(4));
    }    
}

