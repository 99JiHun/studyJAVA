package gameTheory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj9655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        while(true){
            int method1 = N - 6;
            int method2 = N - 4;
            int method3 = N - 2;
            if(method1 >= 4){
                N = N -6;
            }
            else if(method2 >= 4){
                N = N - 4;
            }
            else if(method3 >= 4){
                N = N - 2;
            }
            if(N == 1){
                bw.write("SK");
                break;
            }
            if(N == 2){
                bw.write("CY");
                break;
            }
            if(N==3){
                bw.write("SK");
                break;
            }
            if(N == 4){
                bw.write("CY");
                break;
            }
            if(N == 5){
                bw.write("SK");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
