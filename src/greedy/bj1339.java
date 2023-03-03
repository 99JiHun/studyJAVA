package greedy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class bj1339 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws NumberFormatException, IOException{
        int N = Integer.parseUnsignedInt(br.readLine());
        String[] word = new String[N];
        String[][] wordAlp = new String[word.length][];
        int[] alpLen = new int[N];
        int maxLen = 0;
        for(int i=0;i<N;i++){
            word[i] = br.readLine();
            wordAlp[i] = new String[word[i].length()];
            wordAlp[i] = word[i].split("");
            alpLen[i] = wordAlp[i].length;
            if(alpLen[i] > maxLen){
                maxLen = alpLen[i];
            }
        }
        String[][] countAlp = new String[10][2];
        int countAlpIndex = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<wordAlp[i].length;j++){
                boolean p = true;
                if(countAlp[0] == null){
                    countAlp[0][0] = wordAlp[i][j];
                    countAlp[0][1] = "0";
                    countAlpIndex++;
                    continue;
                }
                for(int k=0;k<countAlpIndex;k++){
                    if(countAlp[k][0].equals(wordAlp[i][j])){
                        p = !p;
                        break;
                    }
                }
                if(p){
                    countAlp[countAlpIndex][0] = wordAlp[i][j];
                    countAlp[countAlpIndex++][1] = "0";
                }
            }
        }
        String[][] numberDigit = new String[10][10];
        int carry = 0;
        for(int i=0;i<N;i++){
            if(alpLen[i]==maxLen){
                for(int j=0;j<wordAlp[i].length;j++){
                    numberDigit[j][carry] = wordAlp[i][j];
                }
                carry+=1;
            }
            else{
                int l = alpLen[i];
                int digit = 0;
                for(int j=maxLen-l;l!=0;l=l-1){
                    j = maxLen - l;
                    numberDigit[j][carry] = wordAlp[i][digit];
                    digit++;
                }
                carry+=1; 
            }
        }
        int sumData = (int) Math.pow(10, maxLen-1);
        for(int i=0;i<maxLen;i++){//자릿수
            for(int j=0;j<N;j++){
                if(numberDigit[i][j] == null)continue;
                for(int k=0;k<countAlpIndex;k++){
                    if(countAlp[k][0].equals(numberDigit[i][j])){
                        countAlp[k][1] = String.valueOf(Integer.parseUnsignedInt(countAlp[k][1]) + sumData);
                        break;
                    }
                }
            }
            sumData /=10;
        }
        String[] valueAlp = new String[10];
        int valueAlpIndex = 9;
        int valueAlpPivot = 0;
        for(int i=0;i<countAlpIndex;i++){
            int maxValue = 0;
            for(int j=0;j<countAlpIndex;j++){
                if(maxValue < Integer.parseInt(countAlp[j][1])){
                    maxValue = Integer.parseInt(countAlp[j][1]);
                    valueAlp[valueAlpIndex] = countAlp[j][0];
                    valueAlpPivot = j;
                }
            }
            countAlp[valueAlpPivot][1] = "-1";
            valueAlpIndex--;
        }
        int fin = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<wordAlp[i].length;j++){
                for(int k=9;k>=0;k--){
                    if(valueAlp[k] == null)break;
                    if(valueAlp[k].equals(wordAlp[i][j])){
                        fin += k * (int) Math.pow(10, wordAlp[i].length - j - 1);
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(fin));
        bw.flush();
        bw.close();
    }
}