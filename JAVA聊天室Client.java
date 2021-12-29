import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("127.0.0.1",999);
        Thread sender=new Thread(new Sender(socket));
        Thread accepter=new Thread(new Accepter(socket));
        sender.start();
        accepter.start();
    }
}
class Sender implements Runnable{
    private Socket socket;
    public Sender(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try{
            OutputStream os=socket.getOutputStream();
            PrintStream printStream=new PrintStream(os);
            Scanner scanner=new Scanner(System.in);
            while(scanner.hasNext()){
                printStream.println(scanner.next());
            }
            os.close();
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Accepter implements Runnable{
    private Socket socket;
    public Accepter(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try{
            InputStream is=socket.getInputStream();
            Scanner scanner=new Scanner(is);
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
            is.close();
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}