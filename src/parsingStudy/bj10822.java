package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
public class bj10822 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        Integer[] arr = Stream.of(br.readLine().split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int sum=0;
        for(int data : arr)sum+=data;
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}