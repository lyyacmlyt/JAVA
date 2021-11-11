import java.util.*;
public class Calculator {
    public static void main(String[] args){
        System.out.println("请输入:");
            Scanner s=new Scanner(System.in);
            System.out.println("请输入第一个数:");
            double a=s.nextDouble();
            System.out.println("请输入运算符");
            String symbol=s.next();
            System.out.println("请输入第二个数:");
            double b=s.nextDouble();
            math m=new math();
            double result=m.yunsuan(a,symbol,b);
            System.out.println(result);
    }
}
class math {
    String symbol;
    public double yunsuan(double a,String symbol,double b){
        if(symbol.equals("+")){
            return a+b;
        }else if(symbol.equals("-")){
            return a-b;
        }else if(symbol.equals("*")){
            return a*b;
        }
        return a/b;
    }
}