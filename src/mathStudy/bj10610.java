package mathStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream; 
public class bj10610 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static boolean multiTwo(Integer[] number){
        for(int data : number){
            if(data%2==0){
                return true;
            }
        }
        return false;
    }
    public static boolean multiThree(Integer[] number){
        int sum = 0;
        for(int data : number){
            sum+=data;
        }
        if(sum%3==0){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean multiFive(Integer[] number){
        for(int data : number){
            if(data==5||data==0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        Integer[] number = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int fin = 0;
        if(!multiTwo(number)){
            fin = -1;
            bw.write(String.valueOf(fin));
        }
        if(!multiThree(number)){
            fin = -1;
            bw.write(String.valueOf(fin));
        }
        if(!multiFive(number)){
            fin = -1;
            bw.write(String.valueOf(fin));
        }
        if(fin!=-1){
            Arrays.sort(number,Collections.reverseOrder());
            if(number[number.length-1]==0){
                for(int data : number){
                    bw.write(String.valueOf(data));
                }
            }
            else{
                bw.write("-1");
            }
        }
        bw.flush();
        bw.close();
    }
}