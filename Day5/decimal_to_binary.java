import java.util.*;
class decimal_to_binary{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println("conversion: "+conversion(x));
    }
    public static String conversion(int x){
        String s="";
        while(x!=1){
            int y=x%2;
            String h=String.valueOf(y);
            s=h+s;
            x=x/2;
        }
        return "1"+s;
    }
}