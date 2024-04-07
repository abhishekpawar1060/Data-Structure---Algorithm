public class MaxPointsYouCanObtainsFromCards{
    public static int maxScore(int[] var0, int var1) {
       int var2 = 0;
       int var3 = 0;
       int var4 = 0;
 
       int var5;
       for(var5 = 0; var5 < var1; ++var5) {
          var3 += var0[var5];
          var2 = var3;
       }
 
       var5 = var0.length - 1;
 
       for(int var6 = var1 - 1; var6 >= 0; --var6) {
          var3 -= var0[var6];
          var4 += var0[var5];
          --var5;
          var2 = Math.max(var2, var3 + var4);
       }
 
       return var2;
    }
 
    public static void main(String[] var0) {
       int[] var1 = new int[]{2, 2, 2};
       byte var2 = 2;
       System.out.println(maxScore(var1, var2));
    }
 }