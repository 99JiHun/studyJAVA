package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj10821 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws NumberFormatException, IOException{
        bw.write(String.valueOf(br.readLine().split(",").length));
        bw.flush();
        bw.close();
    }
}
