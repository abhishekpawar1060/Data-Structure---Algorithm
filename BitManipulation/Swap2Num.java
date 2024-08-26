public class Swap2Num {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        System.out.println("Before swaping a : "+a+ " And b : "+b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swaping a : "+a+ " And b : "+b);

    }
}
