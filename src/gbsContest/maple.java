package gbsContest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class maple {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws NumberFormatException, IOException{
    int N = Integer.parseInt(br.readLine());
    if(N>=200&&N<=205){
        bw.write("1");
    }
    else if(N>=206&&N<=217){
        bw.write("2");
    }
    else if(N>=218&&N<=228){
        bw.write("3");
    }
    else{
        bw.write("4");
    }
    bw.flush();
    bw.close();
    }
}
