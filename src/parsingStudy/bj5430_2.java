package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
public class bj5430_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String p;
    static int n;
    static String str;
    static Stack st = new Stack<Integer>();
    static ArrayDeque que = new ArrayDeque<Integer>();
    static void DR(){
        que.pollLast();
    }
    static void DL(){
        que.poll();
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st.clear();
            que.clear();
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            str = br.readLine();
            String[] nStringArr = str.split("");
            int sum = 0;
            int carry = 1;
            boolean direction = true; // 방향 true 면 왼쪽 에서 오른쪽(>>), false 면 오른쪽 에서 왼쪽 (<<)
            for(String s : nStringArr){
                if(s.equals("[")||s.equals("]")||s.equals(",")){
                    while(!st.isEmpty()){
                        sum = sum + carry * (int) st.pop();
                        carry*=10;
                    }
                    if(carry!=1){
                        que.add(sum);
                        sum = 0;
                        carry = 1;
                    }
                    continue;
                }
                else{
                    st.add(Integer.parseInt(s));
                }
            }//문자열 받아서 숫자만 뽑아오기
            int err = 0;
            for(String AC : p.split("")){
                if(AC.equals("R")){
                    direction = !direction;
                }
                else if(AC.equals("D")){
                    if(que.isEmpty()){
                        bw.write("error\n");
                        err = 1;
                        break;
                    }
                    if(direction){ // >>
                        DL(); //제일 왼쪽 팝
                    }
                    else{ // <<
                        DR(); //제일 오른쪽 팝
                    }
                }
            }
            if(err == 0 && que.isEmpty()){
                bw.write("[]\n");
            }
            if(!que.isEmpty())
            bw.write("[");
            while(!que.isEmpty()){
                if(direction){
                    bw.write(String.valueOf(que.poll()));
                }
                else{
                    bw.write(String.valueOf(que.pollLast()));
                }
                if(!que.isEmpty()){
                    bw.write(",");
                }
                else{
                    bw.write("]\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}