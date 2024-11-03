//pangram: a string which contains all the alphabetic letters whether they r in lowercase or in uppercase.
import java.util.*;

public class pangram_checking{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();
        if(s.length()<26){
            System.out.println("string is not pangram");
        }
        String s2=s.toLowerCase();
        boolean f=true;
        for(char ch='a';ch<='z';ch++){
            String str=""+ch;
            if(!s2.contains(str)){
                f=false;
            }
        }
        if(f){
            System.out.println("string is pangram");
        }
        else{
            System.out.println("string is not pangram");
        }
    }
}