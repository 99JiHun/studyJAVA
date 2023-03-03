package treeStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj10868 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] tree; static long[] arr; static long min = -1;
    public static long Min(long a,long b){
        if(a==-1){
            return b;
        }
        if(b==-1){
            return a;
        }
        if(a < b){
            return a;
        }
        else{
            return b;
        }
    }
    public static long init(int start,int end,int node){
        if(start==end){
            return tree[node] = arr[start];
        }
        int mid = (start+end)/2;
        return tree[node] = Min(init(start, mid, node*2),init(mid+1, end, node*2+1));
    }
    public static Long minData(int start,int end,int node, int left,int right){
        if(left > end || right < start){
            return (long) -1;
        }
        if(left <= start && right >= end){
            return tree[node];
        }
        int mid = (start+end)/2;
        return Min(minData(start, mid, node*2, left, right), minData(mid+1, end, node*2+1, left, right));
    }
    public static void main(String[] args) throws IOException{
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]); 
        int M = Integer.parseInt(NM[1]);
        arr = new long[N];
        tree = new long[N*4];
        for(int i = 0; i <N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, arr.length-1, 1);
        for(int i=0;i<M;i++){
            String[] order = br.readLine().split(" ");
            int a = Integer.parseInt(order[0]); 
            int b = Integer.parseInt(order[1]);
            long fin = 0;
            fin = minData(0, arr.length-1, 1, a-1, b-1);
            bw.write(String.valueOf(fin)+"\n");
            min = -1;
        }
        bw.flush();
        bw.close();
    }
}
