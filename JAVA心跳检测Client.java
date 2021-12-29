import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String severIp;
    private int port;
    private Socket socket;
    private boolean running=false;
    private long lastSendTime;
    public Client(String severIp,int port){
        this.severIp=severIp;
        this.port=port;
    }
    public void begin() {
        try{
            if(running) return;
            Socket socket=new Socket(severIp,port);
            lastSendTime=System.currentTimeMillis();
            running=true;
            new Thread(new Sender(socket)).start();
            new Thread(new Accepter(socket)).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    class Sender implements Runnable{
        Socket socket;
        public Sender(Socket socket){
            this.socket=socket;
        }
        public void run(){
            try{
                while(true){
                    OutputStream os=socket.getOutputStream();
                    PrintStream printStream=new PrintStream(os);
                    printStream.println("我在线嘞");
                    Thread.sleep(3000);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    class Accepter implements Runnable{
        Socket socket;
        public Accepter(Socket socket){
            this.socket=socket;
        }
        public void run(){
            try{
                InputStream in=socket.getInputStream();
                Scanner scanner=new Scanner(in);
                while(scanner.hasNext()){
                    System.out.println(scanner.next());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client=new Client("127.0.0.1",999);
        client.begin();
    }
}