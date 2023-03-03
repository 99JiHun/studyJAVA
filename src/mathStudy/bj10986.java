package mathStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
public class bj10986 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] tree; static int count = 0; static int M = 1;
    public static int init(int start, int end, int node, Integer[] arr){
        if(start==end){
            return tree[node] = arr[start];
        }
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2, arr) + init(mid+1, end, node*2+1, arr);
    }
    public static void Hap(int start,int end,int left,int right,int node,Integer[] arr){
        if(left > end || right < start){
            return;
        }
        if(left <=start && right >= end){
            if(tree[node]%M==0){
                count++;
            }   
        }
        if(start == end){
            return;
        }
        int mid = (start+end)/2;
        Hap(start, mid, left, right, node*2, arr);
        Hap(mid+1, end, left, right, node*2+1, arr);

    }
    public static void main(String[]args)throws IOException{
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        tree = new int[N*4];
        Integer[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        init(0, arr.length-1, 1, arr);
        Hap(0, arr.length-1, 0, arr.length-1, 1, arr);
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
