package baekjunTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj20364_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;
    static String[] arr;
    static int[] visit;
    static int visitNum = 0;
    public static void main(String[]args) throws NumberFormatException, IOException{
        str = br.readLine();
        arr = str.split(" ");
        // int a = 5;
        // System.out.print(5 >> 2);
        int N = Integer.parseInt(arr[0]); //땅 개수
        int Q = Integer.parseInt(arr[1]); //오리 수
        visit = new int[N+1];
        //부모 찾는거는 >> 1 하면 됨
        for(int i=0;i<Q;i++){
            int cur = Integer.parseInt(br.readLine());
            int oriNum = cur;
            visitNum = 0;
            while(cur != 0){ 
                if(visit[cur]==1){
                    visitNum = cur;
                }
                cur = cur >> 1;
            }
            if(visitNum ==0 ){
                visit[oriNum] = 1;
                bw.write("0"+"\n");
            }
            else{
                bw.write(String.valueOf(visitNum)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}