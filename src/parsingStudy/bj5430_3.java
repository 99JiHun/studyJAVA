package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
public class bj5430_3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String p;
    static int n;
    static String str;
    static Stack st = new Stack<Integer>();
    static int[] nArr;
    public static void main(String[] args) throws NumberFormatException, IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st.clear();

            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            nArr = new int[n];
            
            str = br.readLine();
            String[] nStringArr = str.split("");
            int sum = 0;
            int carry = 1;
            int index = 0;
            int mini = 0;
            int maxi = nArr.length;
            boolean direction = true; // 방향 true 면 왼쪽 에서 오른쪽(>>), false 면 오른쪽 에서 왼쪽 (<<)
            for(String s : nStringArr){
                if(s.equals("[")||s.equals("]")||s.equals(",")){
                    while(!st.isEmpty()){
                        sum = sum + carry * (int) st.pop();
                        carry*=10;
                    }
                    if(carry!=1){
                        nArr[index] = sum;
                        index++;
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
                    if(maxi<=0||mini>=maxi){
                        bw.write("error\n");
                        err = 1;
                        break;
                    }
                    if(direction){
                        mini++;
                    }
                    else{
                        maxi--;
                    }
                }
            }
            if(err == 0){
                bw.write("[");
                if(direction){
                    for(int j = mini;j<maxi;j++){
                        bw.write(String.valueOf(nArr[j]));
                        if(j!=maxi-1){
                            bw.write(",");
                        }
                    }
                }
                else{
                    for(int j = maxi-1;j>mini-1;j--){
                        bw.write(String.valueOf(nArr[j]));
                        if(j!=mini-1){
                            bw.write(",");
                        }
                    }
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
    }
}