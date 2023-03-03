package GRP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
public class bj1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);
        boolean[] visit = new boolean[100001];
        visit[K] = true;
        Queue que = new ArrayDeque<>();
        que.clear();
        visit[N] = true;
        que.add(N); int count = 0;
        while(!que.isEmpty()){
            if(N==K){
                break;
            }
            int size = que.size();
            for(int i=0;i<size;i++){
                int curData = (int) que.poll();
                int xM1 = curData - 1;
                int xP1 = curData + 1;
                int xM2 = curData * 2;
                if(xM1 == K || xP1 == K || xM2 == K){
                    que.clear();
                    break;
                }
                if(xM1 >= 0&&!visit[xM1]){
                    visit[xM1] = true;
                    que.add(xM1);
                }
                if(xP1<=K && !visit[xP1]){
                    visit[xP1] = true;
                    que.add(xP1);
                }
                if(xM2<=K+1 && !visit[xM2]){
                    visit[xM2] = true;
                    que.add(xM2);
                }
            }
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}