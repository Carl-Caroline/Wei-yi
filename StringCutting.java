package HomeWork;
//编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。 
//但是要保证汉字不被截半个，如“我ABC”4，应该截为“我AB”
//输入“我ABC”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”

//import java.io.*;
//Scanner类的方法更简单，这里就用它来做输入

import java.lang.StringBuffer;
import java.util.Scanner;

public class StringCutting {
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);		
		System.out.println("请输入需要被分割的字符串：");
		String str = sc.nextLine();
		System.out.println("请输入需要截取的字符数：");
		int num = sc.nextInt();		
		
		//StringBuffer str1 = new StringBuffer(str);
		//System.out.println(str1.substring(0, num));
		//substring把汉字当做一个字符处理，这里不适用，所以自己写一个来用
		System.out.println(Carlsubstring(str, num));
	}
	public static String Carlsubstring(String str, int num)throws Exception{
		byte[] bytes = str.getBytes("Unicode");		//str转换
		//汉字是两个不为0的字节，字符的第一个字节为0
		/*System.out.println("bytes[" + bytes.length + "]");
		for(int j=0; j<bytes.length; j++) {
			System.out.println(j + ":  " + bytes[j]);
		}
		*/
		int count=0;
		int i;	//i的值从2开始，前两个字节是标志位，可以通过上面的代码测试
		for(i=2; i<bytes.length && count<num; i++) {
			if(i%2==1)	count++;	//通过奇数位计数
			else if(bytes[i]!=0)	count++;	//汉字偶数位不为0
		}
		if(i%2==1) {	//汉字的末端处理
			if(bytes[i-1]!=0)	i-=1;	//结尾是字就扔掉
			else i+=1;	//结尾是字符就留下
		}
		return new String(bytes, 0, i, "Unicode");
	}
}
