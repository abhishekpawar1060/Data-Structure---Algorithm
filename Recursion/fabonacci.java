public class fabonacci {
    public static int fab(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return fab(n-1)+fab(n-2);
    }

    public static void main(String[] args) {
       System.out.println(fab(5));
    }
}
