package SEGMENTTREE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
public class bj11505 {
    static final int DIVVAL = 1_000_000_007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr; static long[] segTree;
    static long init(int left,int right,int node){
        if(left==right){
            return segTree[node] = arr[left] % DIVVAL;
        }
        int mid = (left+right)/2;
        return segTree[node] = (init(left,mid,node*2) % DIVVAL * init(mid+1, right, node*2+1) % DIVVAL) % DIVVAL;
    }
    static long returnSeg(int start, int end, int left,int right,int node){
        if(right < start || left > end){
            return 1;
        }
        if(left <= start && right >= end){
            return segTree[node];
        }
        int mid = (start+end)/2;
        return (returnSeg(start, mid, left, right, node*2)% DIVVAL * returnSeg(mid+1, end, left, right, node*2+1)% DIVVAL)% DIVVAL;
    }
    static long updataSegData(int start,int end,int node, int data, int index){
        if(index < start || index > end){
            return segTree[node];
        }
        if(start == end && start == index){
            return segTree[node] = data;
        }
        int mid = (start + end)/2;
        return segTree[node] = (updataSegData(start, mid, node*2, data, index)% DIVVAL * updataSegData(mid+1, end, node*2+1, data, index)% DIVVAL)% DIVVAL;
    }
    public static void main(String[] args) throws IOException{
        Integer[] nmk = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        arr = new int[nmk[0]];
        segTree = new long[nmk[0]*4];
        for(int i=0;i<nmk[0];i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(0, nmk[0]-1, 1);
        for(int i=0;i<nmk[1]+nmk[2];i++){
            String[] order = br.readLine().split(" ");
            int b = Integer.parseInt(order[1]);
            int c = Integer.parseInt(order[2]);
            if(order[0].equals("1")){
                updataSegData(0,nmk[0]-1,1,c,b-1);
            }
            else{
                long data = returnSeg(0, nmk[0]-1, b-1, c-1, 1);
                bw.write(String.valueOf(data)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}