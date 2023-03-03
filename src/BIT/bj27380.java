package BIT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
public class bj27380 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] bArr;
    public static long solve(long data){
        String[] dataArr = Long.toBinaryString(data).split("");
        int carryIndex =dataArr.length-1;
        for(int i=0;i<dataArr.length;i++){
            if("1".equals(dataArr[i])){
                return carryIndex;
            }
            carryIndex--;
        }
        return -1;
    }
    public static long minOrMax(long a,long b,int index){
        long preData = bArr[index-1];
        if(a<=b){
            if(preData <= a && (preData|a) == b){
                return a;
            }
            else{
                if((preData|b)!=b){
                    return -1;
                }
                return b;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        bArr = new long[N];
        Long[] aArr = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).boxed().toArray(Long[]::new);
        bArr[0] = (long) Math.pow(2, solve(aArr[0]));
        boolean p = false;
        for(int i=1;i<N;i++){
            if(aArr[i-1] - bArr[i-1]<0){
                bw.write("No");
                p = true;
                break;
            }
            if((aArr[i-1] - bArr[i-1])==0){
                if(i==N-1){
                    bArr[i] = aArr[i-1];
                    if(bArr[i]<bArr[i-1]){
                        p=true;
                        bw.write("No");
                    }
                    break;
                }
                bArr[i] = aArr[i-1];
                continue;
            }
            long curData = minOrMax(aArr[i-1] - bArr[i-1], aArr[i-1],i);
            if(curData==-1){
                p=true;
                bw.write("No");
                break;
            }
            bArr[i] = curData;
        }
        if(!p){
            bw.write("Yes\n");
            for(long data : bArr){
                bw.write(String.valueOf(data)+" ");
            }
        }
        bw.flush();
        bw.close();
    }
}   