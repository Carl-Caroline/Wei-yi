package HomeWork;

import java.io.*;
import java.net.*;
import java.util.*;

//ServerSocket类表示 服务器套接字
public class SocketClient {
    public static void main(String[] args) throws Exception {
    	
        Socket sk = new Socket("127.0.0.1",8967);  
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintWriter pw = new PrintWriter(sk.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
        	System.out.println("正在连接服务器，请在此输入：");    	
            String str = br.readLine();
            
            pw.println(str);
            pw.flush();
            
            if (str.equals("exit"))	break;

            System.out.println(bf.readLine());           	
        }     
        sk.close();
        System.out.println("已退出！");
    }
}