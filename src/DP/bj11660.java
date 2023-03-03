package DP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
public class bj11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] value; static long[][] sumData;
    public static void main(String[] args) throws IOException{
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]); //크기 1 ~ 1024
        int M = Integer.parseInt(NM[1]); //합 구해야 하는 횟수 1 ~ 100_000
        value = new int[N][N];
        sumData = new long[N][N];
        for(int i=0;i<N;i++){
            String[] data = br.readLine().split(" ");
            long sum=0;
            for(int j=0;j<N;j++){
                int curData = Integer.parseInt(data[j]);
                value[i][j] = curData;
                sum+=curData;
                sumData[i][j] = sum;
            }
        }
        for(int i=0;i<M;i++){
            Integer[] doit = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            //index (0, 1), (2, 3) >> (x1, y1), (x2, y2) (X)
            //index (1, 0), (3, 2)
            long sum=0;
            for(int j=doit[0]-1;j<doit[2];j++){
                int doit0Data = doit[1]-2;
                if(doit0Data<0){//제일 앞 1 1 일때
                    sum = sum + sumData[j][doit[3]-1];
                }
                else{
                    sum = sum + sumData[j][doit[3]-1] - sumData[j][doit[1]-2];
                }
                
            }
            bw.write(String.valueOf(sum)+"\n");
        }
        bw.flush();
        bw.close();
    }
}