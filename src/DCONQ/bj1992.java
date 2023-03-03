package DCONQ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] arr;
    public static String solve(int N,int size,int ipivot,int jpivot) throws IOException{
        if(size==1){
            if(arr[ipivot][jpivot]){
                return "1";
            }
            else{
                return "0";
            }
        }
        String a = solve(N, size/2, ipivot, jpivot);
        String b = solve(N, size/2, ipivot, jpivot+size/2);
        String c = solve(N, size/2, ipivot+size/2, jpivot);
        String d = solve(N, size/2, ipivot+size/2, jpivot+size/2);
        String ans = "";
        if(a.equals("1")&&b.equals("1")&&c.equals("1")&&d.equals("1")){
            ans = "1";
        }
        else if(a.equals("0")&&b.equals("0")&&c.equals("0")&&d.equals("0")){
            ans = "0";
        }
        else{
            ans = "(" + a + b + c + d + ")";
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split("");
            int j = 0;
            for(String data : str){
                if("1".equals(data)){
                    arr[i][j] = true;
                }
                j++;
            }
        }
        bw.write(solve(N, N, 0, 0));
        bw.flush();
        bw.close();
    }
}