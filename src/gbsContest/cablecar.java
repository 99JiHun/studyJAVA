package gbsContest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class cablecar{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;
    static String[] arr;
    static long memo[];
    static int hei[];
    static long Min(long a,long b){
        if(a<=b){
            return a;
        }
        else{
            return b;
        }
    }
        public static void main(String[]args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        arr = new String[N];
        str = br.readLine();
        arr = str.split(" ");
        memo = new long[N];
        hei = Arrays.asList(arr).stream().mapToInt(Integer :: parseInt).toArray(); //String to int
        memo[0] = 0;
        memo[1] = (int) Math.pow((hei[0] - hei[1]), 2) + (int) Math.pow((hei[0] + hei[1]), 2);
        long sum = hei[0] + 2*hei[1];
        for(int i=2;i<N;i++){
            memo[i] = Min(memo[i-1] + (long) Math.pow((hei[i-1] - hei[i]), 2) + (long) Math.pow((hei[i-1] + hei[i]), 2),(long) Math.pow(sum + hei[i],2) + (long) Math.pow(hei[i] - hei[0], 2));
            sum = sum + 2*hei[i];
        }
        bw.write(String.valueOf(memo[N-1]));
        bw.flush();
        bw.close();
    }
}