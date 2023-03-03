package TWOPOINTER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);
        st = new StringTokenizer(br.readLine());
        int[] iArr = new int[N];
        int sIndex = 0;
        int eIndex = 0;
        for(int i=0;i<N;i++){
            iArr[i] = Integer.parseInt(st.nextToken());
        }
        int sumData = iArr[0];
        int count = 0;
        while(true){
            if(eIndex==N || sIndex==N){
                break;
            }
            if(sumData == M){
                count++;
                if(eIndex!=N-1){
                    sumData+=iArr[++eIndex];
                }
                else{
                    eIndex++;
                }
                continue;
            }
            if(sumData > M){
                if(sIndex!=N){
                    sumData-=iArr[sIndex++];
                }
                else{
                    sIndex++;
                }
                continue;
            }
            if(sumData < M){
                if(eIndex!=N-1){
                    sumData+=iArr[++eIndex];
                }
                else{
                    eIndex++;
                }
                continue;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}