package NETWORKFLOW;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class bj17412 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack ar = new Stack<>();
    public static void main(String[] args) throws IOException{
        String[] arr = {"a","a","b","c","a"};
        int[] data = new int[26];
        LinkedList li = new LinkedList<>();
        li.add("a");
        li.add("a");
        li.add("b");
        Stream<String> st = li.stream().distinct();
        String fin = (String) st.collect(Collectors.joining(""));
        System.out.println(fin);
    }
}
