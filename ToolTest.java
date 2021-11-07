public class ToolTest {
    public static void main(String[] args){
        Tool.delete();
    }
}
abstract class Tool{
    private  double  add(double a,double b){
        return a+b;
    }
    public static void delete(){
        System.out.println("shanchu");
    }
    public abstract void move();
}