package treeStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class segementTree {
    static long[] tree; static long[] arr;
    static public long init(int start, int end, int node){
        if(start==end){
            return tree[node] = arr[start];
        }
        int mid = (start + end)/2;
        return tree[node] = init(start, mid, node*2) + init(mid+1,end,node*2+1);
    }
    static public long sum(int start, int end,int node,int left,int right){
        if(left > end || right < start){
            return 0;
        }
        if(left <=start && right >= end){
            return tree[node];
        }
        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }
    static public void update(int start, int end, int node, int index, long dif){
        if(index < start || index > end){
            return;
        }
        tree[node] += dif;
        if(start == end){
            return;
        }
        int mid = (start+end)/2;
        update(start, mid, node*2, index, dif);
        update(mid+1, end, node*2+1, index, dif);
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] mnk = br.readLine().split(" ");
        int N = Integer.parseInt(mnk[0]); //수의 개수
        int M = Integer.parseInt(mnk[1]); //수의 변경이 일어나는 수
        int K = Integer.parseInt(mnk[2]); //구간의 합을 구하는 횟수
        arr = new long[N];
        tree = new long[N*4];
        for(int i=0;i<N;i++){
            long n = Long.parseLong(br.readLine());
            arr[i] = n;
        }
        init(0, arr.length-1, 1);
        for(int i=0;i<M+K;i++){
            String[] order = br.readLine().split(" ");
            if("1".equals(order[0])){
                int index = Integer.parseInt(order[1])-1;
                long dif = Long.parseLong(order[2]) - arr[index];
                update(0, arr.length-1, 1, index, dif);
                arr[index] = Long.parseLong(order[2]);
            }
            else{
                int left = Integer.parseInt(order[1])-1;                
                int right = Integer.parseInt(order[2])-1;
                bw.write(String.valueOf(sum(0, arr.length-1, 1, left, right))+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}