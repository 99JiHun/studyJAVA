package mathStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj2590 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] confetti; static int[] con123456;
    public static void main(String[] args)throws IOException{
        confetti = new boolean[6][6];
        int N = Integer.parseInt(br.readLine());
        con123456 = new int[N];
        for(int i=0;i<5;i++){
            con123456[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i=4;i>=0;i--){
            if(i==4){
                count+=con123456[i];
            }
            else{
                if(con123456[i]==0)continue;
                for(int j=0;j<con123456[i];j++){
                    
                }
            }
        }
    }
}
