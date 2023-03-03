package treeStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj10999_lazyPropagation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] tree; static long[] arr; static long dif = 0; static long sum = 0;
    static boolean[] lazyExist; static long[] lazyValue;
    public static long init(int start,int end,int node){
        if(start==end){
            return tree[node] = arr[start];
        }
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2)+init(mid+1, end, node*2+1);
    }
    public static long update(int start, int end, int node,int left,int right,long dif){
        if(right < start || left > end){
            return tree[node];
        }
        if(start==end){
            return tree[node] = tree[node] + dif;
        }
        if(start >= left && end <= right){
            lazyExist[node] = true;
            lazyValue[node] += dif;
            return tree[node] = tree[node] + dif * (end - start + 1);
        }
        int mid = (start + end)/2;
        if(lazyExist[node]){ //영역에 완전히 들어가는 것이 아니라 겹칠 때
            lazyExist[node] = false;
            pushDown(lazyValue[node], node*2, start, mid);
            pushDown(lazyValue[node], node*2+1, mid+1, end);
            lazyValue[node] = 0;
        }
        long leftVal = update(start, mid, node*2,left,right, dif);
        long rightVal = update(mid+1, end, node*2+1,left,right, dif);
        return tree[node] = leftVal + rightVal;
    }
    public static long sumData(int start,int end,int left, int right, int node){
        if(left > end || right < start){
            return 0;
        }
        if(left <= start && right >= end){
            return tree[node];
        }
        int mid = (start+end)/2;
        if(lazyExist[node]){
            lazyExist[node] = false;
            pushDown(lazyValue[node], node*2, start, mid);
            pushDown(lazyValue[node], node*2+1, mid+1, end);
            lazyValue[node] = 0;
        }
        return sumData(start, mid, left, right, node*2) + sumData(mid+1, end, left, right, node*2+1);
    }
    public static long pushDown(long newValue, int node, int left, int right){
        if(left==right){
            return tree[node] = tree[node] + newValue;//만약 구간이 left, right 같아진다면 >> leaf 노드를 선택한다면 lazy가 아닌 바로 업데이트
        }
        lazyExist[node] = true;
        lazyValue[node] += newValue;
        return tree[node] = tree[node] + newValue * (right - left + 1);
    }
    public static void main(String[] args) throws IOException{
        String[] NMK = br.readLine().split(" ");
        int N = Integer.parseInt(NMK[0]); 
        int M = Integer.parseInt(NMK[1]); // 변경이 일어나는 횟수
        int K = Integer.parseInt(NMK[2]); // 구간의 합을 구하는 횟수 
        arr = new long[N];
        tree = new long[N*4];
        lazyExist = new boolean[N*4];
        lazyValue = new long[N*4];
        for(int i = 0; i <N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, arr.length-1, 1);
        for(int i=0;i<M+K;i++){
            String[] order = br.readLine().split(" ");
            int b = 0; 
            int c = 0;
            long d = 0;
            if("1".equals(order[0])){ //구간 업데이트
                b = Integer.parseInt(order[1])-1; // b에서
                c = Integer.parseInt(order[2])-1; // c까지
                d = Long.parseLong(order[3]); // d를 더함
                update(0, arr.length-1,1, b, c, d);
            }
            else{ //구간 합
                b = Integer.parseInt(order[1])-1; // b에서
                c = Integer.parseInt(order[2])-1; // c까지 더함
                long fin = sumData(0, arr.length-1, b, c, 1);
                bw.write(String.valueOf(fin)+"\n");
                sum = 0;
            }
        }
        bw.flush();
        bw.close();
    }
}