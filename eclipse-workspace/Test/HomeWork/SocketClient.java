package HomeWork;

import java.io.*;
import java.net.*;
import java.util.*;

//ServerSocket���ʾ �������׽���
public class SocketClient {
    public static void main(String[] args) throws Exception {
    	
        Socket sk = new Socket("127.0.0.1",8967);  
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintWriter pw = new PrintWriter(sk.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
        	System.out.println("�������ӷ����������ڴ����룺");    	
            String str = br.readLine();
            
            pw.println(str);
            pw.flush();
            
            if (str.equals("exit"))	break;

            System.out.println(bf.readLine());           	
        }     
        sk.close();
        System.out.println("���˳���");
    }
}