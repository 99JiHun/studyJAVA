package GRP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;
class Node{
    int i;
    int j;
    boolean visit;
    Node(int i,int j){
        this.i = i;
        this.j = j;
        this.visit = false;
    }
}
public class bj2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // data is 0 : already visited
    static boolean[][] visit; static Integer[][] map; static Queue que = new ArrayDeque<Object>();
    static List mapList = new ArrayList<Node[]>(); static List homeList = new ArrayList<>();
    static Node addNode(int i,int j){
        return new Node(i, j);
    }
    static int searchHome(int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(((Node[]) mapList.get(i))[j].visit)continue;
                ((Node[]) mapList.get(i))[j].visit = true;
                que.add(((Node[]) mapList.get(i))[j]);
                int curCount = 0;
                while(!que.isEmpty()){
                    curCount++;
                    Node curData = (Node) que.poll();
                    curData.visit=true;
                    int iIndex = curData.i;
                    int jIndex = curData.j;
                    boolean up,left,right,down;
                    up = true; left = true; right = true; down = true;
                    if(iIndex-1<0){
                        up = false;
                        down = true;
                    }
                    if(iIndex+1>=size){
                        up = true;
                        down = false;
                    }
                    if(jIndex-1<0){
                        left = false;
                        right = true;
                    }
                    if(jIndex+1>=size){
                        left= true;
                        right = false;
                    }
                    if(up){
                        boolean curUpVisited = ((Node[])mapList.get(iIndex-1))[jIndex].visit;
                        if(!curUpVisited){
                            que.add(((Node[])mapList.get(iIndex-1))[jIndex]);
                            ((Node[])mapList.get(iIndex-1))[jIndex].visit = true;
                        }
                    }
                    if(down){
                        boolean curDownVisited = ((Node[])mapList.get(iIndex+1))[jIndex].visit;
                        if(!curDownVisited){
                            que.add(((Node[])mapList.get(iIndex+1))[jIndex]);
                            ((Node[])mapList.get(iIndex+1))[jIndex].visit = true;
                        }
                    }
                    if(left){
                        boolean curLeftVisited = ((Node[])mapList.get(iIndex))[jIndex-1].visit;
                        if(!curLeftVisited){
                            que.add(((Node[])mapList.get(iIndex))[jIndex-1]);
                            ((Node[])mapList.get(iIndex))[jIndex-1].visit = true;
                        }
                    }
                    if(right){
                        boolean curRightVisited = ((Node[])mapList.get(iIndex))[jIndex+1].visit;
                        if(!curRightVisited){
                            que.add(((Node[])mapList.get(iIndex))[jIndex+1]);
                            ((Node[])mapList.get(iIndex))[jIndex+1].visit = true;
                        }
                    }
                }
                homeList.add(curCount);
            }
        }
        return homeList.size();
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        map = new Integer[N][N];
        visit = new boolean[N][N];
        que.clear();
        for(int i=0;i<N;i++){
            map[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            int index = 0;
            Node[] curNodeArr = new Node[N];
            for(int data : map[i]){
                Node curData = new Node(i, index);
                if(data == 0)curData.visit=true;
                curNodeArr[index] = curData;
                index++;
            }
            mapList.add(curNodeArr);
        }
        int fin = searchHome(N);
        Collections.sort(homeList);
        bw.write(String.valueOf(fin)+"\n");
        for(int i=0;i<homeList.size();i++){
            bw.write(String.valueOf(homeList.get(i))+"\n");
        }
        bw.flush();
        bw.close();
    }
}
