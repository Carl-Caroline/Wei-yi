package HomeWork;
//��дһ����ȡ�ַ����ĺ���������Ϊһ���ַ������ֽ��������Ϊ���ֽڽ�ȡ���ַ����� 
//����Ҫ��֤���ֲ����ذ�����硰��ABC��4��Ӧ�ý�Ϊ����AB��
//���롰��ABC����6��Ӧ�����Ϊ����ABC�������ǡ���ABC+���İ����

//import java.io.*;
//Scanner��ķ������򵥣������������������

import java.lang.StringBuffer;
import java.util.Scanner;

public class StringCutting {
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);		
		System.out.println("��������Ҫ���ָ���ַ�����");
		String str = sc.nextLine();
		System.out.println("��������Ҫ��ȡ���ַ�����");
		int num = sc.nextInt();		
		
		//StringBuffer str1 = new StringBuffer(str);
		//System.out.println(str1.substring(0, num));
		//substring�Ѻ��ֵ���һ���ַ��������ﲻ���ã������Լ�дһ������
		System.out.println(Carlsubstring(str, num));
	}
	public static String Carlsubstring(String str, int num)throws Exception{
		byte[] bytes = str.getBytes("Unicode");		//strת��
		//������������Ϊ0���ֽڣ��ַ��ĵ�һ���ֽ�Ϊ0
		/*System.out.println("bytes[" + bytes.length + "]");
		for(int j=0; j<bytes.length; j++) {
			System.out.println(j + ":  " + bytes[j]);
		}
		*/
		int count=0;
		int i;	//i��ֵ��2��ʼ��ǰ�����ֽ��Ǳ�־λ������ͨ������Ĵ������
		for(i=2; i<bytes.length && count<num; i++) {
			if(i%2==1)	count++;	//ͨ������λ����
			else if(bytes[i]!=0)	count++;	//����ż��λ��Ϊ0
		}
		if(i%2==1) {	//���ֵ�ĩ�˴���
			if(bytes[i-1]!=0)	i-=1;	//��β���־��ӵ�
			else i+=1;	//��β���ַ�������
		}
		return new String(bytes, 0, i, "Unicode");
	}
}
