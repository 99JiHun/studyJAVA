package bst;
import java.util.ArrayDeque;
class bNode{
    int data;
    bNode left;
    bNode right;
    bNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public int getData(bNode cur){
        return cur.data;
    }
}
public class bstStudy {
    static bNode head;
    bstStudy(){
        head = new bNode(3);
    }
    private static void push(bNode newNode){
        if(head == null){
            head = newNode;
        }
        else{
            bNode tempNode = head;
            ArrayDeque que = new ArrayDeque<>();
            que.clear();
            que.add(tempNode);
            while(!que.isEmpty()){
                bNode curNode = (bNode) que.poll();
                bNode leftNode = curNode.left;
                bNode rightNode = curNode.right;
                if(leftNode==null){
                    curNode.left = newNode;
                    return;
                }
                else if(rightNode==null){
                    curNode.right = newNode;
                    return;
                }
                else{
                    que.add(leftNode);
                    que.add(rightNode);
                }
            }
        }
    }
    public static void main(String[] args){
        new bstStudy();
        bNode data1 = new bNode(5);
        bNode data2 = new bNode(7);
        bNode data3 = new bNode(4);
        bNode data4 = new bNode(2);
        push(data1);
        push(data2);
        push(data3);
        push(data4);
    }
}
