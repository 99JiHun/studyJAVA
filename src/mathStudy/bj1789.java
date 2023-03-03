package mathStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj1789 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws NumberFormatException, IOException{
        long num = Long.parseLong(br.readLine());
        long data = 0;
        int i = 0;
        for(i = 1;;i++){
            data+=i;
            if(data>num){
                break;
            }
        }
        bw.write(String.valueOf(i-1));
        bw.flush();
        bw.close();
    }
}
