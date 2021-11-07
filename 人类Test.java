public class 人类Test {
    public static void main(String[] args){
        People zhangSan=new Teacher("cool",35,175,50.2,"zhangSan");
        People liSi=new Student("ugly",18,173,65,"liSi");
        zhangSan.eat();
        zhangSan.sleep();
        Teacher zhangSan1=(Teacher)zhangSan;
        zhangSan1.teaching();
        liSi.eat();
        liSi.sleep();
        Student liSi1=(Student)liSi;
        liSi1.study();
    }
}
class People{
    String appearance;
    double age;
    double height;
    double weight;
    String name;
    public void eat(){
        System.out.println("人类必须吃饭");
    }
    public void sleep(){
        System.out.println("人类必须睡觉");
    }
}
class Teacher extends People{
    public Teacher(){

    }
    public Teacher(String appearance,double age,double height,double weight,String name){
        this.appearance=appearance;
        this.age=age;
        this.height=height;
        this.weight=weight;
        this.name=name;
    }
    public void eat(){
        System.out.println(this.name+"必须吃饭");
    }
    public void sleep(){
        System.out.println(this.name+"必须睡觉");
    }
    public void teaching(){
        System.out.println(this.name+"每天要教学生上课");
    }
}
class Student extends People{
    public Student(){

    }
    public Student(String appearance,double age,double height,double weight,String name) {
        this.appearance = appearance;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.name = name;
    }
    public void sleep(){
        System.out.println(this.name+"必须睡觉");
    }
    public void teaching(){
        System.out.println(this.name+"每天要教学生上课");
    }
    public void study(){
        System.out.println(this.name+"每天要去学校上课");
    }
}