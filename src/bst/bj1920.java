package bst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class node{
    int data;
    node left;
    node right;
    node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    node(int data,node left,node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class bj1920 {
    static node head = null;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void insertData(int data){
        if(head == null){
            head.data = data;
        }
        else{
            node newNode = new node(data);
            node tempNode = head;
            while(tempNode.left!=null||tempNode.right!=null){
                if(tempNode.data >= newNode.data){
                    tempNode = tempNode.left;
                }
                else{
                    tempNode = tempNode.right;
                }
            }
            if(tempNode.data >= newNode.data){
                tempNode.left = newNode;
            }
            else{
                tempNode.right = newNode;
            }
        }
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        arr = br.readLine().split(" ");
        head.data = Integer.parseInt(arr[0]);
        for(int i=1;i<N;i++){

        }
    }
}
