package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
public class bj5430 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Stack number = new Stack<Integer>();
    private static ArrayDeque que1 = new ArrayDeque<Integer>();
    private static ArrayDeque que2 = new ArrayDeque<Integer>();

    private static void R(){//배열에 있는 수 순서 뒤집기
        if(que1.isEmpty()&&que2.isEmpty()){//두 스택 다 비어있을때
            return;
        }
        else{//하나라도 차있을 때
            if(que1.isEmpty()){
                while(!que2.isEmpty()){
                    que1.push(que2.pop());
                }
            }
            else{
                while(!que1.isEmpty()){
                    que2.push(que1.pop());
                }
            }
        }
    }
    private static void D() throws IOException{//첫 번째 수 버리기, 배열이 비어 있는데 사용하면 Error
        if(que1.isEmpty()&&que2.isEmpty()){//두 큐
            bw.write("error\n");
            return;
        }
        else{
            if(!que1.isEmpty()){
                que1.poll();
            }
            else{
                que2.poll();
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        int T = Integer.parseInt(br.readLine()); //maximum == 100
        String p = null;//수행할 함수 1 ~ 100000
        int n = 0;//배열이 들어있는 수의 개수 0 ~ 100000
        String str = null;
        que1.clear();
        que2.clear();
        number.clear();
        for(int i=0;i<T;i++){
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            str = br.readLine();
            int sum = 0;
            int carry = 1;
            for(String N : str.split("")){
                if(N.equals("[")||N.equals("]")||N.equals(",")){
                    if(number.isEmpty()){
                        continue;
                    }
                    while(!number.isEmpty()){
                        sum = sum + carry * (int) number.pop(); 
                        carry*=10;
                    }
                    que1.add(sum);
                    sum=0;
                    carry = 1;
                    continue;
                }
                else{
                    number.push(Integer.parseInt(N));
                    }
                }
            //정보 읽어서 숫자만 뽑아내기
            for(String P : p.split("")){
                if(P.equals("R")){
                    R();
                }
                else if(P.equals("D")){
                    D();
                }
            }
            if(!que1.isEmpty()){
                bw.write("[");
                while(!que1.isEmpty()){
                    bw.write(String.valueOf(que1.poll()));
                    if(que1.isEmpty())
                    continue;
                    bw.write(",");
                }
                bw.write("]");
                bw.write("\n");
            }
            if(!que2.isEmpty()){
                bw.write("[");
                while(!que2.isEmpty()){
                    bw.write(String.valueOf(que2.poll()));
                    if(que2.isEmpty())
                    continue;
                    bw.write(",");
                }
                bw.write("]");
                bw.write("\n");
            }
            
        }
        bw.flush();
        bw.close();
    }
}