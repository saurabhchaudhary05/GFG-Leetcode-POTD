import java.util.*;
public class isomorphic{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string1: ");
        String x1=sc.nextLine();
        System.out.println("enter the string2: ");
        String x2=sc.nextLine();
        if(isisomorphic(x1,x2)){
            System.out.println("strings are isomorphic");
        }
        else{
            System.out.println("strings are not isomorphic");
        }

    }
    public static boolean isisomorphic(String x1,String x2){
        int map[]=new int[256];
        Boolean b[]=new Boolean[256];
        Arrays.fill(b,Boolean.FALSE);
        Arrays.fill(map,-1);
        if(x1.length()!=x2.length()){
            return false;
        }
        for(int i=0;i<x1.length();i++){
            if(map[x1.charAt(i)]==-1){
                if(b[x2.charAt(i)]==true){
                    return false;
                }
                b[x2.charAt(i)]=true;
                map[x1.charAt(i)]=x2.charAt(i);

            }
            else if(map[x1.charAt(i)]!=x2.charAt(i)){
                    return false;
            }
        }
        return true;
    }
}
// Input:  str1 = “aab”, str2 = “xxy”
//Output: True
//Explanation: ‘a’ is mapped to ‘x’ and ‘b’ is mapped to ‘y’.
//
//Input:  str1 = “aab”, str2 = “xyz”
//Output: False
//Explanation: One occurrence of ‘a’ in str1 has ‘x’ in str2 and other occurrence of ‘a’ has ‘y’.
// sbse pehle dekhenge ki wo char 1st baar aaya h kya s1 m ...agr first baar aaya h to uske corresponding
// m dekhenge dusri string m bhi pehli baar aana chhiye wo char ...agr first baar nhi aaya h to false return
// kr denge ...agr first baar aaya h to usko true kr denge aur s1 k us char ki positon pr s2 k char ko
//store kr denge .....agr pehli baar nhi aaya h to s1 k array m uss positon pr jo element store h wo...iss
//particular index pr s2 k char k equal hona chhiye agr nhi h to false return kr denge.