package BIT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
public class bj1062 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] alp; static int[] alpCount;
    public static void main(String[] args)throws IOException{
        Integer[] NK = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        alp = new boolean[NK[0]][26]; // 0~26 a ~ z
        alpCount = new int[26];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<NK[0];i++){
            String[] sentence = Stream.of(br.readLine().split("")).distinct().toArray(String[]::new);
            for(String data : sentence){
                if(data.equals("a")||data.equals("n")||data.equals("t")||data.equals("i")||data.equals("c"))continue;
                alp[i][data.charAt(0)-97] = true; alpCount[data.charAt(0)-97]++;
            }
            
        }

    }
}
