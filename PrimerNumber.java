public class PrimerNumber{
    public static void main(String[] args){
        int count=0;
        for(int i=1;i<=200;i++) {
            int m=0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    m = 1;
                    break;
                }
            }
            if(m==0) {
                System.out.printf("%d\n", i);
                count++;
            }
        }
        System.out.printf("Sum number is %d",count);
    }
}