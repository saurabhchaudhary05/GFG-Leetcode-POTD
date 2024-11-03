//ek string given h aur ek pattern to hmko batana h wo pattern kon konse index pr present h
/*import java.util.*;
public class pattern_searching_in_strings{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string:");
        String str = sc.nextLine();
        System.out.println("enter pattern:");
        String pat = sc.nextLine();

        int index = str.indexOf(pat);
//        jb pehli baar pattern match krega string m
//        ab while loop lagake dekhenge aur kitti baar krega patter match
        while (index >= 0) {
            System.out.println(index);
            index = str.indexOf(pat, index + 1);

        }
    }
}*/


//digits after decimal
import java.util.*;
public class pattern_searching_in_strings{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter digits string:");
        String str = sc.nextLine();

        System.out.println("digits after decimal:" + digitsafterdecimal(str));
    }

    public static String digitsafterdecimal(String str){
         int index = str.indexOf('.');

        if(index<0){
            return "no digits after decimal";
        }
        else{
            return str.substring(index+1);
        }
    }
}