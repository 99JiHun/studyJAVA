package combi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws NumberFormatException, IOException{
    String str = br.readLine();
    String[] arr = str.split(" ");
    int L = Integer.parseInt(arr[0]); //비밀번호 길이
    int C = Integer.parseInt(arr[1]); //입력 수
    arr = br.readLine().split(" ");
    boolean[] alp = new boolean[26];
    // String[] alp = {"b","c","d","f","g","h","j","k","l","m","n","o","p","q","r","s","t","v","w","x","y","z"};
    for(String n : arr){
        alp[n.charAt(0)-97] = true; // a,b,c ... x,y,z //모음 (0,4,8,14,20) index
    }
    int[] vo = {0,4,8,14,20};
    for(int i=0;i<5;i++){
        if(alp[vo[i]]){//if vo[i] is true
            
        }
    }
    }
}
