package HomeWork;

import java.io.*;
import java.net.*;

public class SocketServer extends Thread {
	private Socket sk;
	public SocketServer(Socket sk) {
        this.sk = sk;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter pw = new PrintWriter(sk.getOutputStream());
            
            while (true) {
            	//System.out.println("服务器正在打开...");
                String str = br.readLine();
                System.out.println(str);
                pw.println("从客户端收到的消息为： " + str);  
                pw.flush();
                if (str == "exit")  break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket ssk = new ServerSocket(8967);
        while (true) {
            Socket sk = ssk.accept();
            new SocketServer(sk).start();
        }
    }
}
