package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
public class bj8595 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack st = new Stack<Integer>();
    static long sum = 0;
    public static void solve(){
        int carry = 1;
        while(!st.isEmpty()){
            int value = (int)st.pop();
            sum+=value*carry;
            carry*=10;
        }
    }
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split("");
        boolean continuePivot = false;
        
        st.clear();
        for(int i=0;i<N;i++){
            if(!continuePivot&&!st.isEmpty()){
                solve();
            }
            if(data[i].charAt(0)>=48&&data[i].charAt(0)<=57){
                continuePivot = true;
                st.add(Integer.parseInt(data[i]));
            }
            else{
                continuePivot=false;
            }
        }
        if(!st.isEmpty())solve();
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}