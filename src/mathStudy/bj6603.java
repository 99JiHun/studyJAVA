package mathStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream; 
public class bj6603 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int LENGTH = 6; static boolean[] visit; static int size = 5;
    public static void rotto(Integer[] arr,int s) throws IOException{
        int count = 0;
        for(int i=s;i<arr.length;i++){
            if(visit[i])continue;
            if(count!=size){
                count++;
                bw.write(String.valueOf(arr[i])+" ");
            }
            else{
                
            }
        }
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        
        while(true){
            String data = br.readLine();
            if("0".equals(data)){
                break;
            }
            Integer[] arr = Stream.of(data.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            int N = arr[0];
            visit = new boolean[N+1]; // index 0 은 무시
            for(int i=1;i<=N-LENGTH+1;i++){//길이가 6 이하가 되면 안 볼거임
                rotto(arr,i);
            }
        }
    }
}
