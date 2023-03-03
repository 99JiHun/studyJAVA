package structure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
public class bj1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        PriorityQueue pQue = new PriorityQueue<Integer>();
        pQue.clear();
        for(int i = 0; i<N; i++){
            int data = Integer.parseInt(br.readLine());
            pQue.add(data);
        }
        int sum = 0;
        
        while(pQue.size()!=1){
            int sumData = (int) pQue.poll() + (int) pQue.poll();
            sum+=sumData;
            pQue.add(sumData);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}