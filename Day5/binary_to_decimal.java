import java.util.*;
class binary_to_decimal{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String x=sc.nextLine();
        System.out.println("conversion: "+conversion(x));
    }
    public static int conversion(String x){
        int x1=0;
        int j=0;
        for(int i=x.length()-1;i>=0;i--){
            char ch=x.charAt(i);
            int a=ch-'0';
            x1=x1+a*(int)Math.pow(2,j);
            j++;
        }
        return x1;
    }
}