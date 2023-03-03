package ENUM;
enum type{
    MOBILE, WEB, SERVER
}
public class enumStudy {
    public static String name;
    public static int career;
    public static type t;
    public static void main(String[] args){
        for(type data : type.values()){
            System.out.println(data);
        }
    }
}
