package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
public class bj1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;
    static String[] arr;
    static ArrayDeque que = new ArrayDeque<String>();
    static Stack st = new Stack<String>();
    static int fin = 0;
    static String sign = "+"; //basic data
    static int carry = 1;
    static private void solve(){
        if(sign.equals("+")){
            while(!st.isEmpty()){
                fin = fin + carry*Integer.parseInt((String) st.pop());
                carry*=10;
            }
        }
        else{
            while(!st.isEmpty()){
                fin = fin - carry*Integer.parseInt((String) st.pop());
                carry*=10;
            }
        }
        carry = 1;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        str = br.readLine();
        que.clear();
        st.clear();
        arr = str.split("");
        for(String n : arr){
            que.add(n);
        }
        while(!que.isEmpty()){
            String n = (String) que.poll();
            if(n.equals("+")){
                solve();
                if(sign.equals("-")){
                    sign = "-";
                }
                else{
                    sign = "+";
                }
            }
            else if(n.equals("-")){
                solve();
                sign = "-";
            }
            else{//숫자일때
                st.add(n);
            }
        }
        solve();
        bw.write(String.valueOf(fin));
        bw.flush();
        bw.close();
    }
}
