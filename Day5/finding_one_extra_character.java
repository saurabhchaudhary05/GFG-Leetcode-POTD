import java.util.*;
public class finding_one_extra_character{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println("extra character: "+extra(s1,s2));
    }
    public static char extra(String s1,String s2){
        int res=0;
        int n1=s1.length();
        int n2=s2.length();
        int n=0;
        if(n1<n2){
            n=n1;
        }
        else{
            n=n2;
        }
        for(int i=0;i<n;i++){
            res=res^s1.charAt(i)^s2.charAt(i);
        }
        res=res^s2.charAt(n);
        return (char)(res);
    }
}

//hmko do string given h ...ek string dusri string se ek character bdi h bss..to hmko wo hi extra character
//nikalna h...so hm for loop chalayenge chotii wali string k length tak phir unko bitwise xor krwa denge
//phir ek bdi wali string ka ek character bach gaya ..ab uske sath xor krwa denge...to res aa jayega phir
//usko convert into char krke ans aa jayega

//bitwise xor = agr same ho to 0 aata h aur different ho to 1 aata h....
// s1=abcd
//s2=abced
// a aur a zero ho gaya ...b aur b zero ho jayega ..aise hi same element zero ho jayega...ab bacha
// ek extra element usko agr zero k sath xor krayenge to wo element hi aayega ...