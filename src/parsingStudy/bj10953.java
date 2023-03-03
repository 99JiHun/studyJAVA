package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj10953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] arr = new String[2];
    private static int Sum(int a,int b){
        return a + b;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            arr = br.readLine().split(",");
            bw.write(String.valueOf(Sum(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])))+"\n");
        }
        bw.flush();
        bw.close();
    }
}