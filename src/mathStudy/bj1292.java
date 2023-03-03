package mathStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj1292 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int index = 1;
    public static void inserData(int[] map,int data){
        for(int i=0;i<data;i++){
            if(index>1000)return;
            map[index++] = data;
        }
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        int[] map = new int[1001];
        int i = 1;
        while(true){
            if(index > 1000){
                break;
            }
            inserData(map, i++);
        }
        String[] order = br.readLine().split(" ");
        int A = Integer.parseInt(order[0]); int B = Integer.parseInt(order[1]);
        int sum = 0;
        for(i = A;i<=B;i++){
            sum+=map[i];
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}