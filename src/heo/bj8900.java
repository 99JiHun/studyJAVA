package heo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
class Square implements Comparable<Square>{
    int x; //왼쪽 아래점
    int y; //왼쪽 아래점
    int lastX; //오른쪽 위점 
    int lastY; //오른쪽 위점
    Square(int x,int y,int lastX,int lastY){
        this.x = x;
        this.y = y;
        this.lastX = lastX;
        this.lastY = lastY;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getLX(){
        return this.lastX;
    }
    public int getLY(){
        return this.lastY;
    }
    @Override
    public int compareTo(Square o) {
        int x = getX() - o.getX();
        if(x==0){
            return getY() - o.getY();
        }
        return x;
    }
}
public class bj8900 {
    static List<Square> sqr = new ArrayList<>();
    static int[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws NumberFormatException, IOException{
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            dp = new int[N];
            for(int j=0;j<N;j++){
                Integer[] data = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
                sqr.add(new Square(data[0],data[1],data[2],data[3]));
            }
            
            Collections.sort(sqr); //높이를 기준으로 정렬
            
            for(int j=0;j<N;j++){
                int x = sqr.get(j).x;
                int y = sqr.get(j).y;
                int lenx = sqr.get(j).lastX;
                int leny = sqr.get(j).lastY;
                if(j!=0){
                    if(sqr.get(j-1).x <lenx && sqr.get(j-1).lastX > x){
                        sqr.get(j).y = sqr.get(j-1).lastY;
                        sqr.get(j).lastY=sqr.get(j).lastY - y + sqr.get(j-1).lastY;
                    } //이전 값이 x와 lastX사이면
                    else{
                        sqr.get(j).y = 0;
                        sqr.get(j).lastY-=y;
                    }
                }
                else{
                    sqr.get(j).y = 0;
                    sqr.get(j).lastY-=y;
                }
            }
            Collections.sort(sqr,new Comparator<Square>() {
                @Override
                public int compare(Square a, Square b){
                    return a.getLX() - b.getLX();
                }
            }); 
            for(int j=0;j<N;j++){
                int x = sqr.get(j).x;
                int y = sqr.get(j).y;
                int lenx = sqr.get(j).lastX;
                int leny = sqr.get(j).lastY;
                if(j!=0){
                    if(sqr.get(j-1).y <leny && sqr.get(j-1).lastY > y){
                        sqr.get(j).x = sqr.get(j-1).lastX;
                        sqr.get(j).lastX=sqr.get(j).lastX - x + sqr.get(j-1).lastX;
                    } //이전 값이 x와 lastX사이면
                    else{
                        sqr.get(j).x = 0;
                        sqr.get(j).lastX-=x;
                    }
                }
                else{
                    sqr.get(j).x = 0;
                    sqr.get(j).lastX-=x;
                }
            }
            int maxX = 0;
            int maxY = 0;
            for(int j=0;j<N;j++){
                if(sqr.get(j).lastX > maxX){
                    maxX = sqr.get(j).lastX;
                }
                if(sqr.get(j).lastY > maxY){
                    maxY = sqr.get(j).lastY;
                }
            }
            bw.write(String.valueOf(maxX) + " " + String.valueOf(maxY) +"\n");
            sqr.clear();
        }
        bw.flush();
        bw.close();
    }
}
