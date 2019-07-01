package HomeWork;
//遍历某文件夹下的所有文件目录及文件 (文件夹从命令行输入)

import java.util.Scanner;
import java.io.*;

public class Traverse {
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);		
		System.out.println("请输入需要被遍历的文件：");
		String str = sc.nextLine();
		//从命令行获取文件地址
		
		File dir = new File(str);		
		File[] filelist = dir.listFiles();		//文件下目录
		String[] children = dir.list();		//文件下文件
		
		//过滤抽象路径名
		FileFilter filefilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};		
		filelist = dir.listFiles(filefilter);
		
		System.out.printf("文件中包括有以下%s个目录：",filelist.length);
		System.out.println();
		if(filelist.length == 0)
			System.out.println("目录不存在或者不是目录！");		//目录不存在提示
		else {
			for(int i=0; i<filelist.length; i++) {
				File filename = filelist[i];
				System.out.println(filename.toString());	//打印目录
			}

		}
		System.out.printf("文件包括以下%s个文件：",children.length);
		System.out.println();
		if(children == null)
			System.out.println("该目录不存在或者不是一个目录！");
		else{
			for(int i=0; i<children.length; i++) {	//打印文件
				String filename = children[i];
				System.out.println(filename);
			}				
		}
	}
}
