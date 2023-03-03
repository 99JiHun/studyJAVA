package BIT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class bj24389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
        Integer n = Integer.parseInt(br.readLine());
        String[] nBit = n.toBinaryString(n).split("");
        boolean[] bitSet = new boolean[32];
        boolean[] bitDoit = new boolean[32];
        Arrays.fill(bitDoit, true);
        int bitIndex = 31;
        for(int i=nBit.length-1;i>=0;i--){
            if("0".equals(nBit[i])){
                bitIndex--;
                continue;
            }
            bitDoit[bitIndex]=!bitDoit[bitIndex];
            bitSet[bitIndex--]=true;
        }
        if(bitDoit[31]==false)bitDoit[31]=true;
        else{
            bitDoit[31]=false;
            for(int i=30;i>=0;i--){
                if(bitDoit[i]==false){
                    bitDoit[i]=true;
                    break;
                }
                bitDoit[i]=!bitDoit[i];
            }
        }
        int count = 0;
        for(int i = 0;i<32;i++){
            if(bitSet[i]^bitDoit[i])count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}