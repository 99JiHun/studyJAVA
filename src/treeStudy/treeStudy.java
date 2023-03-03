package treeStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class tree{
    String data;
    tree left;
    tree right;
    tree(){}
    tree(String data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    tree(String data,tree left,tree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public void setLeft(tree left){
        this.left = left;
    }
    public void setRight(tree right){
        this.right = right;
    }
    public String getData(){
        return this.data;
    }
    public tree getLeft(){
        return this.left;
    }
    public tree getRight(){
        return this.right;
    }
}
public class treeStudy {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private tree newNode;
    static String str;
    static String[] arr;
    treeStudy(){
        newNode = null;
    }
    public tree makeTree(String data,tree left, tree right){
        newNode = new tree(data);
        newNode.setLeft(left);
        newNode.setRight(right);
        return newNode;
    }
    public tree searchLeftNode(tree left){

        return null;
    }
    public static void main(String[] args) throws IOException{
        treeStudy tr = new treeStudy();
        int N = Integer.parseInt(br.readLine());
        char[] alpha = new char[N];
        for(int i=0;i<N;i++){
            alpha[i] = (char) (i+65); // A~Z 까지 알파벳 넣음
        }
        tree[] trArr = new tree[N];
        for(int i=0;i<N;i++){
            trArr[i] = tr.makeTree(String.valueOf(alpha[i]), null, null);
        }
        for(int i=0;i<N;i++){
            str = br.readLine();
            arr = str.split(" ");
            if(arr[1].equals(".")){// 왼쪽 자식 없음
                if(arr[2].equals(".")){// 왼쪽, 오른쪽 자식 없음
                    continue;
                }
                else{//왼쪽 자식 없는데 오른쪽 자식 있음
                    int a = arr[0].charAt(0) - 65; //current index == a - 65
                    int c = arr[2].charAt(0) - 65; //right index == c - 65
                    trArr[a] = tr.makeTree(arr[0], null, trArr[c]);
                }
            }
            else{
                if(arr[2].equals(".")){//왼쪽 자식 있는데 오른쪽 자식은 없음
                    int a = arr[0].charAt(0) - 65; //current index == a - 65
                    int b = arr[1].charAt(0) - 65; //left index == b - 65
                    trArr[a] = tr.makeTree(arr[0], trArr[b], null);
                }
                else{//왼쪽자식, 오른쪽 자식 다 있음
                    int a = arr[0].charAt(0) - 65; //current index == a - 65
                    int b = arr[1].charAt(0) - 65; //left index == b - 65
                    int c = arr[2].charAt(0) - 65; //right index == c - 65
                    
                    trArr[a] = tr.makeTree(arr[0], trArr[b], trArr[c]);
                }
            }
        }
        System.out.println(trArr);
    }
}
