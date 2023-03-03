package hwReview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
class Node{
    String data;
    Node link;
    Node(String data){
        this.data = data;
        this.link = null;
    }
    public static String getData(Node curNode){
        return curNode.data;
    }
}
public class hw3_datastructure{
    public static void insertData(String data,Node head){
        if(head.link == null && head.data == null){
            Node newNode = new Node(data);
            head = newNode;
        }
        else{
            Node newNode = new Node(data);
            Node tempNode = head;
            while(tempNode.link!=null){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
        }
    }
    public static String pop(Node head){
        if(head.link == null && head.data != null){
            String data = Node.getData(head);
            head = null;
            return data;
        }
        else{
            Node tempNode = head;
            Node preNode = tempNode;
            while(tempNode.link!=null){
                preNode = tempNode;
               tempNode = tempNode.link;
            }
            String data = Node.getData(tempNode);
            preNode.link = null;
            return data;
        }
    }
    static Node Stackhead = null;
    static Node queHeadEn = null;
    static Node queHeadDe = null;
    public static void main(String[]args) throws IOException{  
    BufferedReader br = new BufferedReader(
        new FileReader(new File("C:\\Users\\Samsung\\backjunSolve\\src\\hwReview\\input.inp")));
    BufferedWriter bw = new BufferedWriter(
        new FileWriter("C:\\Users\\Samsung\\backjunSolve\\src\\hwReview\\output.out"));
    String str = br.readLine();
    Stackhead = new Node(null);
    String[] strArr = str.split("");
    for(String data : strArr){//stack
        insertData(data,Stackhead);
    }
    for(String data : strArr){//stack
        bw.write(pop(Stackhead));
    }
    queHeadEn = new Node(null);
    queHeadDe = new Node(null);
    str = br.readLine();
    strArr = str.split("");
    for(String data : strArr){//stack
        insertData(data,queHeadEn);
    }
    str = br.readLine();
    strArr = str.split("");
    for(String data : strArr){//stack
        insertData(data,queHeadDe);
    }
    ArrayDeque<Integer> que1 = new ArrayDeque<Integer>();
    
    bw.flush();
    bw.close();
    }
    
}