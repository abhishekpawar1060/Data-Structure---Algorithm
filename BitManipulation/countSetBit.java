public class countSetBit {
    public static void main(String[] args) {
        int count = 0;
        int num = 30;

        // while(num > 1){
        //     count += num & 1;
        //     num = num >> 1;
        // }
        // if(num == 1){
        //     count++;
        // }

        while (num != 0) {
            num = num & num-1;
            count++;
        }

        System.out.println(count);
    }
}
