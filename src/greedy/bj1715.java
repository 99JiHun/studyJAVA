package greedy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void swap(int a,int b,int[] heap){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    static void heapify(int[] heap, int pIndex, int lastIndex){
        int childLeftIndex = pIndex * 2 + 1; //왼쪽 자식
        int childRightIndex = pIndex * 2 + 2; //오른쪽 자식
        int minimumIndex = pIndex; //부모 인덱스
        int count=0;
        while((pIndex*2)+1 <= lastIndex){
            childLeftIndex = pIndex * 2 + 1; //왼쪽 자식
            childRightIndex = pIndex * 2 + 2; //오른쪽 자식
            minimumIndex = pIndex; //부모 인덱스

            if(childLeftIndex < lastIndex && heap[childLeftIndex] < heap[minimumIndex]){
                minimumIndex = childLeftIndex;
            }
            if(childRightIndex < lastIndex && heap[childRightIndex] < heap[minimumIndex]){
                minimumIndex = childRightIndex;
            }
            if(pIndex!=minimumIndex){
                swap(minimumIndex,pIndex,heap);
                pIndex = minimumIndex;
                count = 0;
            }
            else{
                pIndex = (pIndex-1)/2;
                count++;
            }
            if(pIndex==0&&count>0){
                break;
            }
        }
    }
    static void heapSort(int[] arr){
        int size = arr.length;
        if(size < 2){
            return;
        }
        int pIndex = ((arr.length-1)-1)/2;
        for(int i=pIndex;i>=0;i--){
            heapify(arr,i,arr.length);
        }
        for(int i = size-1; i>0;i--){
            swap(0,i,arr);
            heapify(arr,0,i);
        }
    }
    public static void main(String[]args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        for(int i=0;i<N;i++){
            card[i] = Integer.parseUnsignedInt(br.readLine());
        }
        heapSort(card);
        
        bw.flush();
        bw.close();
    }
}