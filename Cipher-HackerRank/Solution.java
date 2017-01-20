import java.util.*;

public class Solution {
    public static String decode(String s, int n, int k){
        StringBuilder sb = new StringBuilder();
        int head = 0;
        boolean oddOnes = false;
        char c = s.charAt(head++);
        sb.append(c);
        if( c == '1' ) { 
            oddOnes = true;
        }
        
        while( head < n && head < k ) {
            c = s.charAt(head);
            
            sb.append(( oddOnes ^ ( c == '1' ) )?'1':'0');
            
            c = sb.charAt(head);
            if( c == '1' ) {
                oddOnes = !oddOnes;
            }
            head++;
        }
        int tail = 0;
        while(head < n) {
            c = sb.charAt(tail++);
            if( c == '1' ) { 
                oddOnes = !oddOnes;
            }
            
            c = s.charAt(head);
            
            sb.append(( oddOnes ^ ( c == '1' ) )?'1':'0');
            
            c = sb.charAt(head);
            if( c == '1' ) {
                oddOnes = !oddOnes;
            }
            head++;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        System.out.println(decode(s, n, k));
    }
}