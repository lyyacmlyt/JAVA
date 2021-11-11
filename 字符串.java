import java.math.BigDecimal;
import java.util.regex.*;
public class 字符串 {
    public static void main(String[] args) {
        String s = "`acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi`";
        String a[] = s.split(",");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
            System.out.print(checkStrIsNum(a[i])+" ");
            System.out.print(UpJudge(a[i])+" ");
            System.out.println(LowerJudge(a[i]));
        }
    }

    private static Pattern NUMBER_PATTETEN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");

    public static String checkStrIsNum(String str) {
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return "不全为数字";
        }
        Matcher isNum = NUMBER_PATTETEN.matcher(str);
        if (!isNum.matches()) {
            return "不全为数字";
        }
        return "全为数字";
    }
    public static String UpJudge(String str){
        int max=0;
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))==true){
                max++;
            }
        }
        if(max==0){
            return "全为大写字母";
        }
        return "不全为大写字母";
    }
    public static String LowerJudge(String s){
        int min=0;
        for(int i=0;i<s.length();i++){
            if(Character.isLowerCase(s.charAt(i))==true){
                min++;
            }
        }
        if(min==0){
            return "全为小字母";
        }
        return "不全为小写字母";
    }
}
