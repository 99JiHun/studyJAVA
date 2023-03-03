package xmlStudy;

public class test {
    public static void main(String[] args){
        int[][] arr = new int[1025][1025];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j] = 1;
            }
        }
        System.out.print(arr);
    }
}
