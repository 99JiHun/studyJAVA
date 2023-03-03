package DCONQ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
public class bj1629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static long solve(long a,long b, long mode){
        if(b == 1){
            return a % mode;
        }
        long midL = b/2;
        long midR = b - midL;
        return (solve(a, midL, mode)%mode * solve(a, midR, mode)%mode)%mode;
    }
    public static void main(String[] args) throws IOException{
        Integer[] abc = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        long fin = solve(abc[0], abc[1], abc[2]);
        bw.write(String.valueOf(fin));
        bw.flush();
        bw.close();
    }
}
