package treeStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj2357 {
    static long[] tree; static long[] arr; static long[] tree2;
    static private long Max(long a,long b){
        if(a > b){
            return a;
        }
        else{
            return b;
        }
    }
    static private long Min(long a,long b){
        if(a < b){
            return a;
        }
        else{
            return b;
        }
    }
    static private void init(int start,int end,int node){
        if(start==end){
            tree[node] = arr[start];
            tree2[node] = arr[end];
            return;
        }
        init(start, (start+end)/2, node*2);
        init((start+end)/2+1, end, node*2+1);
        tree[node] = Min(tree[node*2], tree[node*2+1]);
        tree2[node] = Max(tree2[node*2], tree2[node*2+1]);
    }
    static private long searchMin(int start,int end,int node,int left,int right){
        if(left > end || right < start){
            return -1;
        }
        if(left<=start&&right>=end){
            return tree[node];
        }
        long data1,data2;
        data1 = searchMin(start, (start+end)/2, node*2, left, right);
        data2 = searchMin((start+end)/2+1, end, node*2+1, left, right);
        if(data1==-1){
            return data2;
        }
        if(data2==-1){
            return data1;
        }
        return Min(data1,data2);
    }
    static private long searchMax(int start,int end,int node,int left,int right){
        if(left > end || right < start){
            return -1;
        }
        if(left<=start&&right>=end){
            return tree2[node];
        }
        long data1,data2;
        data1 = searchMax(start, (start+end)/2, node*2, left, right);
        data2 = searchMax((start+end)/2+1, end, node*2+1, left, right);
        if(data1==-1){
            return data2;
        }
        if(data2==-1){
            return data1;
        }
        return Max(data1,data2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        arr = new long[N];
        tree = new long[N*4];
        tree2 = new long[N*4];
        for(int i=0;i<N;i++){
            long data = Long.parseLong(br.readLine());
            arr[i] = data;
        }
        init(0, arr.length-1, 1);
        for(int i=0;i<M;i++){
            String[] order = br.readLine().split(" ");
            int left = Integer.parseInt(order[0])-1;
            int right = Integer.parseInt(order[1])-1;
            long min = searchMin(0, arr.length-1, 1, left, right);
            long max = searchMax(0, arr.length-1, 1, left, right);
            bw.write(String.valueOf(min)+" "+String.valueOf(max)+"\n");
        }
        bw.flush();
        bw.close();
    }
}