package GRP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class bj1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] value; static int v; static int e; static Deque que;
    static void searchRoad(int k) throws IOException{//정점 k = k - 1
        for(int i=0;i<v;i++){
            if(i==k){
                bw.write("0\n");
                continue;
            }
            for(int j=0;j<v;j++){
                if(value[j][i]==-1)continue;
                if(j==i)continue;
                que.add(value[j][i]);
            }    
            while(!que.isEmpty()){
                int data = (int)que.poll();
            }
        }
    }
    public static void main(String[] args) throws IOException{
        String[] VE = br.readLine().split(" "); // 노드 : V , 간선개수 : E
        v = Integer.parseInt(VE[0]);
        e = Integer.parseInt(VE[1]);
        int K = Integer.parseInt(br.readLine()); //시작 정점
        value = new int[v][v];
        que = new ArrayDeque<Integer>();
        for(int i=0;i<v;i++){
            Arrays.fill(value[i],-1);
            value[i][i] = 0;
        }
        for(int i=0;i<e;i++){
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int vTo = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);
            value[u-1][vTo-1] = w;
        }
        searchRoad(K-1);
    }
}
