package dfs_backtracking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws NumberFormatException, IOException{
        int comNum = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[][] virus = new boolean[comNum][comNum];
        for(int i=0;i<comNum;i++){
            String[] arr = br.readLine().split(" ");
            int com1 = Integer.parseInt(arr[0]);
            int com2 = Integer.parseInt(arr[1]);
            virus[com1][com2] = true;
        }
        for(int i=0;i<comNum;i++){
            if(virus[0][i]){
                for(int j=0;j<N;j++){

                }
            }
        }
    }
}
