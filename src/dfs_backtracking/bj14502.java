package dfs_backtracking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class dataNode{
    int i;
    int j;
    dataNode(int i,int j){
        this.i = i;
        this.j = j;
    }
}
public class bj14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] virus; static boolean visit[][];
    bj14502(){
        
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        new bj14502();
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        virus = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0;i<N;i++){
            String str = br.readLine();
            arr = str.split(" ");
            for(int j=0;j<M;j++){
                
            }
        }
    }
}
