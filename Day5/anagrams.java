//anagrams=characters of one string should present in another string
// listen .....silent....yes
//aabc......baca.......yes
//aab...aca.........no
import java.util.*;
/// naive approach
/*public class anagrams{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string1: ");
        String x1=sc.nextLine();
        System.out.println("enter the string2: ");
        String x2=sc.nextLine();
        if(isanagram(x1,x2)){
            System.out.println("strings are anagrams");
        }
        else{
            System.out.println("strings are not angrams");
        }

    }
    public static boolean isanagram(String x1,String x2){
        char ch1[]=x1.toCharArray();
        Arrays.sort(ch1);
        String s1=new String(ch1);
        char ch2[]=x2.toCharArray();
        Arrays.sort(ch2);
        String s2=new String(ch2);
        return s1.equals(s2);
    }
}*/


//optimal solution
import java.util.*;
public class anagrams{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string1: ");
        String x1=sc.nextLine();
        System.out.println("enter the string2: ");
        String x2=sc.nextLine();
        if(isanagram(x1,x2)){
            System.out.println("strings are anagrams");
        }
        else{
            System.out.println("strings are not angrams");
        }

    }
    public static boolean isanagram(String x1,String x2){
        int count[]=new int[255];
        if(x1.length()!=x2.length()){
            return false;
        }
        for(int i=0;i<x1.length();i++){
            count[x1.charAt(i)]++;
            count[x2.charAt(i)]--;
        }
        for(int j=0;j<255;j++){
            if(count[j]!=0){
                return false;
            }
        }
        return true;
    }
}
//hmare paas 2 string h..unko check krna h ki wo palindrome h ya nhi
//to hmne ek array create ki 255 length ki....ab hm loop iterate krenge string ki length k barabar
//count ek standard function h jo uss index pr frequency bada dega....jo concept ye h ki
//example listen ...silent....to first iteration mai jaha l aayega array m waha frequency bad jayegi aur s
//jaha aayega uss index ki frequency -1 ho jayegi...to aise jitti frequency indexes pr bdegi utti hi gategi
// to final array ki sbhi indexes zero hongi agr koi bhi index zero nhi h to wo strings anagram nhi hongi
