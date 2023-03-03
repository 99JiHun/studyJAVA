package DCONQ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] arr; static int whiteCount = 0; static int blueCount = 0;
    public static int solve(int size, int ipivot, int jpivot){
        if(size==1){
            if(arr[ipivot][jpivot]){
                return 1;
            }
            else{
                return 0;
            }
        }
        int a = solve(size/2, ipivot, jpivot);
        int b = solve(size/2, ipivot, jpivot+size/2);
        int c = solve(size/2, ipivot+size/2, jpivot);
        int d = solve(size/2, ipivot+size/2, jpivot+size/2);
        int wORb = -1;
        if(a==1&&b==1&&c==1&&d==1){
            return 1;
        }
        else if(a==0&&b==0&&c==0&&d==0){
            return 0;
        }
        else{
            if(a==0)whiteCount++;
            if(b==0)whiteCount++;
            if(c==0)whiteCount++;
            if(d==0)whiteCount++;
            if(a==1)blueCount++;
            if(b==1)blueCount++;
            if(c==1)blueCount++;
            if(d==1)blueCount++;
            wORb = -1;
        }
        return wORb;
    }
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split(" ");
            int j = 0;
            for(String data : str){
                if("1".equals(data)){
                    arr[i][j] = true;
                }
                j++;
            }
        }
        solve(N, 0, 0);
        if(whiteCount==0&&blueCount==0){
            if(!arr[0][0])whiteCount=1;
            else blueCount=1;
        }
        bw.write(String.valueOf(whiteCount)+"\n");
        bw.write(String.valueOf(blueCount));
        bw.flush();
        bw.close();
    }
}
