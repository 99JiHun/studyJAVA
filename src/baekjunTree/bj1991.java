package baekjunTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class bj1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;
    static String[][] arr;
    static String[] tree;
    static void setChild(String parent,String left, String right){
        if(left.equals(".")&&right.equals(".")){
            return;
        }
        for(int i=0;i<tree.length;i++){
            if(tree[i] == null)continue;
            if(tree[i].equals(parent)){
                if(!left.equals(".")){
                    tree[i*2+1] = left;
                }
                if(!right.equals(".")){
                    tree[i*2+2] = right;
                }
                break;
            }
        }
    }
    static void preorderTraversal() throws IOException{ //전위 순회
        bw.write(tree[0]); // root node
        if(tree.length==2)return;
        if(tree[1] != null){
            leftChild(tree[1], 1);
        }
        if(tree[2] != null){
            rightChild(tree[2], 2);
        }
    }
    static void leftChild(String cur, int index) throws IOException{
        bw.write(cur);
        if(index*2+2>=tree.length)return;
        if(tree[index*2+1] != null){
            leftChild(tree[index*2+1], index*2+1);
        }
        if(tree[index*2+2] != null){
            rightChild(tree[index*2+2], index*2+2);
        }
    }
    static void rightChild(String cur, int index) throws IOException{
        bw.write(cur);
        if(index*2+2>=tree.length)return;
        if(tree[index*2+1] != null){
            leftChild(tree[index*2+1], index*2+1);
        }
        if(tree[index*2+2] != null){
            rightChild(tree[index*2+2], index*2+2);
        }
    }
    static void inorderTraversal() throws IOException{ //중위 순회
        if(tree.length==2){
            bw.write(tree[0]);
            return;}
        if(tree[1] != null){
            leftChild2(tree[1], 1);
        }
        bw.write(tree[0]);
        if(tree[2] != null){
            rightChild2(tree[2], 2);
        }
    }
    static void leftChild2(String cur, int index) throws IOException{ //중위 순회용
        
        if(index*2+2>=tree.length){
            bw.write(tree[index]);
            return;}
        if(tree[index*2+1] != null){
            leftChild2(tree[index*2+1], index*2+1);
        }
        bw.write(cur);
        if(tree[index*2+2] != null){
            rightChild2(tree[index*2+2], index*2+2);
        }
    }
    static void rightChild2(String cur, int index) throws IOException{
        
        if(index*2+2>=tree.length){
            bw.write(tree[index]);
            return;}
        if(tree[index*2+1] != null){
            leftChild2(tree[index*2+1], index*2+1);
        }
        bw.write(cur);
        if(tree[index*2+2] != null){
            rightChild2(tree[index*2+2], index*2+2);
        }
    }
    static void postorderTraversal() throws IOException{ //후위 순회
        if(tree.length==2){
            bw.write(tree[0]);
            return;}
        if(tree[1] != null){
            leftChild3(tree[1], 1);
        }
        if(tree[2] != null){
            rightChild3(tree[2], 2);
        }
        bw.write(tree[0]);
    }
    static void leftChild3(String cur, int index) throws IOException{ //후위 순회용
        
        if(index*2+2>=tree.length){
            bw.write(tree[index]);
            return;}
        if(tree[index*2+1] != null){
            leftChild3(tree[index*2+1], index*2+1);
        }
        
        if(tree[index*2+2] != null){
            rightChild3(tree[index*2+2], index*2+2);
        }
        bw.write(cur);
    }
    static void rightChild3(String cur, int index) throws IOException{
        if(index*2+2>=tree.length){
            bw.write(tree[index]);
            return;}
        if(tree[index*2+1] != null){
            leftChild3(tree[index*2+1], index*2+1);
        }
        
        if(tree[index*2+2] != null){
            rightChild3(tree[index*2+2], index*2+2);
        }
        bw.write(cur);
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        
        
        int N = Integer.parseInt(br.readLine());
        tree = new String[(int) (Math.pow(2, N))];
        str = br.readLine();
        arr = new String[N][3];
        arr[0] = str.split(" "); //A에 대한 정보 먼저 받기
        tree[0] = arr[0][0];
        if(!arr[0][1].equals(".")){
            tree[1] = arr[0][1];
        }
        if(!arr[0][2].equals(".")){
            tree[2] = arr[0][2];
        }
        for(int i=1;i<N;i++){
            str = br.readLine();
            arr[i] = str.split(" ");
        }
        for(int i=1;i<N;i++){
            Arrays.sort(arr,(o1, o2)->{
                return o1[0].charAt(0) - o2[0].charAt(0);
            });
            setChild(arr[i][0],arr[i][1],arr[i][2]);
        }
        preorderTraversal();
        bw.write("\n");
        inorderTraversal();
        bw.write("\n");
        postorderTraversal();
        bw.flush();
        bw.close();
    }
}