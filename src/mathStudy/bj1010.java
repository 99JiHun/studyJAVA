package mathStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj1010 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] num; static long[] deno;
    static private long combi(int n, int r){
        num = new long[r];
        deno = new long[r];
        int size = r;
        for(int i=0;i<size;i++){
            num[i] = n--;
            deno[i] = r--;
        }
        int fin = 1;
        for(int i=0;i<num.length;i++){
            for(int j=0;j<deno.length;j++){
                if(deno[j]==1)continue;
                if(num[i]%deno[j]==0){
                    num[i]/=deno[j];
                    deno[j] = 1;
                }
            }
            fin*=num[i];
        }
        for(int i=0;i<deno.length;i++){
            if(deno[i]==1)continue;
            fin/=deno[i];
        }
        return fin;
    }
    public static void main(String[]args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String[] order = br.readLine().split(" ");
            int n = Integer.parseInt(order[1]);
            int r = Integer.parseInt(order[0]);
            if(r > n-r){
                r = n-r;
            }
            long data = combi(n, r);

            bw.write(String.valueOf(data)+"\n");
        }
        bw.flush();
        bw.close();
    }
}