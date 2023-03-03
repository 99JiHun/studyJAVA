package baekjunTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj20364 {
    static int canNum(int index,int wantNum){ //first index value is 1  
        if(visit[index]==1){
            return index;
        }
        while(index>0){
            index = index/2;
            if(index>0&&visit[index]==1){
                visitNum = index;
            }
        }
        if(visitNum == 0){
            visit[wantNum] = 1;
            return 0;
        }
        else{
            return visitNum;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;
    static String[] arr;
    static int[] visit;
    static int visitNum = 0;
    public static void main(String[]args) throws NumberFormatException, IOException{
        str = br.readLine();
        arr = str.split(" ");
        int N = Integer.parseInt(arr[0]); //땅 개수
        int Q = Integer.parseInt(arr[1]); //오리 수
        visit = new int[N+1];
        for(int i=0;i<Q;i++){
            int wantNum = Integer.parseInt(br.readLine());
            visitNum = 0;
            int fin = canNum(wantNum,wantNum);
            bw.write(String.valueOf(fin)+"\n");    
        }
        bw.flush();
        bw.close();
    }
}