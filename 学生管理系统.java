import java.util.*;
public class 学生管理系统 {
    public static void main(String[] args){
        Student s=new Student();
        ArrayList<Student> list=new ArrayList<Student>();
        s.storeage(list);
        s.average(list);
        s.sort(list);
    }
}
class Student{
    public String name;
    public double score;
    public String classes;
    public void  storeage(ArrayList<Student> list){
        System.out.println("请输入N个学生的姓名，成绩：");
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        for(int i=0;i<N;i++){
            Student s1=new Student();
            System.out.println("请输入第"+(i+1)+"个学生的姓名，成绩");
            System.out.println("姓名：");
            while(true) {
                Scanner input1 = new Scanner(System.in);
                if (input1.hasNext()) {
                    s1.name = input1.next();
                    break;
                } else {
                    System.out.println("你的输入有误，请重新输入");
                }
            }
            System.out.println("成绩：");
            while(true) {
                Scanner input2 = new Scanner(System.in);
                if (input2.hasNextDouble()) {
                    s1.score = input2.nextDouble();
                    break;
                } else {
                    System.out.println("你的输入有误，请重新输入");
                }
            }
            System.out.println("班级:");
            while(true) {
                Scanner input3 = new Scanner(System.in);
                if (input3.hasNext()) {
                    s1.classes = input3.next();
                    break;
                } else {
                    System.out.println("你的输入有误，请重新输入");
                }
            }
            list.add(s1);
        }
    }
    public void average(ArrayList<Student> list){
        double sum=0;
        for(int i=0;i<list.size();i++){
            sum += list.get(i).score;
        }
        double average=sum/list.size();
        System.out.printf("平均分为：%.2f\n",average);
    }
    public void sort(ArrayList<Student> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).score>list.get(i+1).score) {
                double temp = list.get(i + 1).score;
                list.get(i+1).score = list.get(i).score;
                list.get(i).score = temp;

                String temp1=list.get(i+1).name;
                list.get(i+1).name=list.get(i).name;
                list.get(i).name=temp1;
            }
            for(int j=0;j<list.size();j++){
                if(list.get(j).score<60){
                    System.out.println("姓名:"+list.get(j).name+"  成绩："+list.get(j).score+" 不及格");
                }else if(list.get(j).score<80){
                    System.out.println("姓名:"+list.get(j).name+"  成绩:"+list.get(j).score+" 良好");
                }else if(list.get(j).score>=80){
                    System.out.println("姓名:"+list.get(j).name+"  成绩:"+list.get(j).score+" 优秀");
                }
            }
        }
    }
}