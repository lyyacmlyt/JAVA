import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Server {
    private static Map<Userinfo,Socket> map;
    public static void main(String[] args) throws Exception{
        ServerSocket server=new ServerSocket(999);
        map=new HashMap<>();
        while(true){
            Socket socket=server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {//多线程处理服务器
                    try{
                        OutputStream os=socket.getOutputStream();
                        InputStream is=socket.getInputStream();
                        PrintStream printStream=new PrintStream(os);
                        Scanner scanner1=new Scanner(is);
                        Scanner scanner2=new Scanner(System.in);
                        File file=new File("D:\\新建文件夹\\Test.class");
                        FileOutputStream fos=new FileOutputStream(file);
                        ObjectOutputStream obj=new ObjectOutputStream(fos);
                        FileInputStream fis=new FileInputStream(file);
                        ObjectInputStream ois=new ObjectInputStream(fis);
                        printStream.println("请先登录或注册,1-登录，2-注册");

                        //进入服务器，需要先进行注册
                        printStream.println("请输入要注册的账户");
                        String account = scanner1.next();
                        printStream.println("请输入要注册的密码");
                        String password = scanner1.next();
                        Userinfo userinfo = new Userinfo(account, password);
                        map.put(userinfo, socket);
                        //将集合写入到文件中
                        obj.writeObject(map);
                        printStream.println("注册成功");
                        printStream.println("请输入账号密码");
                        //登录账号进入聊天
                        while(true){
                            printStream.println("请输入你要登录的账号");
                            String account1=scanner1.next();
                            printStream.println("请输入你要登录的密码");
                            String password1=scanner1.next();
                            Userinfo userinfo1=new Userinfo(account1,password1);
                            Map map=(Map)ois.readObject();
                                if(map.containsKey(userinfo1)) {
                                    printStream.println("登录成功,开始聊天吧，嘿嘿");
                                    break;
                                }
                                else{
                                    printStream.println("账号或密码错误");
                                }
                            }
                        while(true){
                            if(scanner1.hasNext()){
                                System.out.println(scanner1.next());
                            }
                            if(scanner2.hasNext()){
                                printStream.println(scanner2.next());
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}