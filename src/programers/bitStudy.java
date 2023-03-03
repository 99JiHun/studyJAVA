package programers;

import java.util.BitSet;


class bitStudy{
    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        BitSet bit1 = new BitSet(n);
        BitSet bit2 = new BitSet(n);
        for(int i=0;i<n;i++){
            bit1.clear();
            bit2.clear();
            String passData = "";

            String[] arr1Str = Integer.toBinaryString(arr1[i]).split("");
            String[] arr2Str = Integer.toBinaryString(arr2[i]).split("");
            int index = 0;
            for(int j = n-1;j>=0;j--){
                if(j>=arr1Str.length){
                    bit1.set(j,false);
                }
                else{
                    if("1".equals(arr1Str[j])){
                        bit1.set(index++,true);
                    }
                    else{
                        bit1.set(index++,false);
                    }
                }
            }
            index = 0;
            for(int j = n-1;j>=0;j--){
                if(j>=arr2Str.length){
                    bit2.set(j,false);
                }
                else{
                    if("1".equals(arr2Str[j])){
                        bit2.set(index++,true);
                    }
                    else{
                        bit2.set(index++,false);
                    }
                }
            }
            for(int j=n-1;j>=0;j--){
                if(bit1.get(j)||bit2.get(j)){
                    passData += "#";
                }
                else{
                    passData += " ";
                }
            }
            answer[i] = passData;
        }
        return answer;
    }
    public static void main(String[]args){
        int x = 9;
        BitSet bit1 = new BitSet(5);
        bit1.set(0,true);
        bit1.set(1,true);
        bit1.set(2,true);
        bit1.set(3,true);
        bit1.set(4,true);
        // System.out.println(bit1.get(0));
        String a = Integer.toBinaryString(x);
        BitSet bit2 = new BitSet(5);
        String[] arr = a.split("");
        int index = 0;
        for(String data : arr){
            if("1".equals(data)){
                bit2.set(index++,true);
            }
            else{
                bit2.set(index++,false);
            }
        }
        
        System.out.println(bit2.get(4));
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        solution(5,arr1,arr2);
    }
}