import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket=new ServerSocket(999);
            long heartDelay=2000;
            while(true){
                Socket socket=serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            InputStream in=socket.getInputStream();
                            OutputStream os=socket.getOutputStream();
                            PrintStream printStream=new PrintStream(os);
                            long lastTime=System.currentTimeMillis();
                            Scanner scanner=new Scanner(in);
                            while(scanner.hasNext()){
                                long nowTime=System.currentTimeMillis();
                                if((nowTime-lastTime)<heartDelay){
                                    System.out.println(scanner.next());
                                }else{
                                    printStream.println("服务器已关闭");
                                    serverSocket.close();
                                    break;
                                }
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
