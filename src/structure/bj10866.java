package structure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class node{
    int data;
    node link;
    node(int data){
        this.data = data;
        this.link = null;
    }
    node(int data,node link){
        this.data = data;
        this.link = link;
    }
}
public class bj10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static node head = null;
    static void push_front(int data){
        node newHead = new node(data);
        if(head==null){
            head = newHead;
        }
        else{
            node temNode = newHead;
            newHead.link = head;
            head = temNode;
        }
    }
    static void push_back(int data){
        node newNode = new node(data);
        if(head==null){
            head = newNode;
        }
        else{
            node tempNode = head;
            while(tempNode.link!=null){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
        }
    }
    static int pop_front(){
        if(head==null){
            return -1;
        }
        else{
            int data = head.data;
            head = head.link;
            return data;
        }
    }
    static int pop_back(){
        if(head == null){
            return -1;
        }
        else if(head.link == null){
            int data = head.data;
            head = null;
            return data;
        }
        else{
            int data;
            node preNode = head;
            node tempNode = head;
            while(tempNode.link!=null){
                preNode = tempNode;
                tempNode = tempNode.link;
            }
            preNode.link = null;
            data = tempNode.data;
            return data;
        }
    }
    static int size(){
        if(head==null){
            return 0;
        }
        else{
            node tempNode = head;
            int count = 0;
            while(tempNode.link!=null){
                tempNode = tempNode.link;
                count++;
            }
            return count + 1;
        }
    }
    static int empty(){
        if(head==null){
            return 1;
        }
        else{
            return 0;
        }
    }
    static int fornt(){
        if(head==null){
            return -1;
        }
        else{
            int data = head.data;
            return data;
        }
    }
    static int back(){
        if(head == null){
            return -1;
        }
        else{
            int data;
            node tempNode = head;
            while(tempNode.link!=null){
                tempNode = tempNode.link;
            }
            data = tempNode.data;
            return data;
        }
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String str = br.readLine();
            String[] arr = str.split(" ");
            if(arr.length==1){
                if(arr[0].equals("front")){
                    bw.write(String.valueOf(fornt())+"\n");
                }
                if(arr[0].equals("size")){
                    bw.write(String.valueOf(size())+"\n");
                }
                if(arr[0].equals("empty")){
                    bw.write(String.valueOf(empty())+"\n");
                }
                if(arr[0].equals("back")){
                    bw.write(String.valueOf(back())+"\n");
                }
                if(arr[0].equals("pop_front")){
                    bw.write(String.valueOf(pop_front())+"\n");
                }
                if(arr[0].equals("pop_back")){
                    bw.write(String.valueOf(pop_back())+"\n");
                }
            }
            else{
                if(arr[0].equals("push_front")){
                    push_front(Integer.parseInt(arr[1]));
                }
                if(arr[0].equals("push_back")){
                    push_back(Integer.parseInt(arr[1]));
                }
            }
        }  
        bw.flush();
        bw.close();
    }
}
