package di_con;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.Year;
public class bj2447 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] starMap;
    static void solveStar(int x, int y, int N, boolean blank){
        if(blank){
            for(int i = x;i<x+N;i++){
                for(int j=y;j<y+N;j++){
                    starMap[i][j] = " ";
                }
            }
            return;
        }
        if(N==1){
            starMap[x][y] = "*";
            return;
        }
        int count = 0;
        int size = N/3;
        for(int i=x;i<x+N;i+=size){
            for(int j=y;j<y+N;j+=size){
                count++;
                if(count==5){
                    solveStar(i, j, size, true);
                }
                else{
                    solveStar(i,j,size,false);
                }
            }
        }
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        starMap = new String[N][N];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        solveStar(0,0,N,false);
        for(String[] arr : starMap){
            for(String data : arr){
                bw.write(data);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}