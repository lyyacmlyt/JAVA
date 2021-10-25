public class TestPage {
    public static  void main(String[] args){
        int a,b,c;
        for(int i=100;i<1000;i++) {
            a = i / 100;
            c=i%10;
            b=(i-(a*100+c))/10;
            if(i==a*a*a+b*b*b+c*c*c)
               System.out.printf("%d\n",i);
        }
    }
}
