package HomeWork;
//����ĳ�ļ����µ������ļ�Ŀ¼���ļ� (�ļ��д�����������)

import java.util.Scanner;
import java.io.*;

public class Traverse {
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);		
		System.out.println("��������Ҫ���������ļ���");
		String str = sc.nextLine();
		//�������л�ȡ�ļ���ַ
		
		File dir = new File(str);		
		File[] filelist = dir.listFiles();		//�ļ���Ŀ¼
		String[] children = dir.list();		//�ļ����ļ�
		
		//���˳���·����
		FileFilter filefilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};		
		filelist = dir.listFiles(filefilter);
		
		System.out.printf("�ļ��а���������%s��Ŀ¼��",filelist.length);
		System.out.println();
		if(filelist.length == 0)
			System.out.println("Ŀ¼�����ڻ��߲���Ŀ¼��");		//Ŀ¼��������ʾ
		else {
			for(int i=0; i<filelist.length; i++) {
				File filename = filelist[i];
				System.out.println(filename.toString());	//��ӡĿ¼
			}

		}
		System.out.printf("�ļ���������%s���ļ���",children.length);
		System.out.println();
		if(children == null)
			System.out.println("��Ŀ¼�����ڻ��߲���һ��Ŀ¼��");
		else{
			for(int i=0; i<children.length; i++) {	//��ӡ�ļ�
				String filename = children[i];
				System.out.println(filename);
			}				
		}
	}
}
