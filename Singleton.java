package HomeWork;
//����ģʽ

//ֻ����һ��ʵ��
//���봴���Լ���Ψһʵ��
//���������������ṩ��һʵ��

public class Singleton {
	private static Singleton ex = new Singleton();	//�����Լ���Ψһʵ��
	private Singleton() {		
	}
	public static Singleton returnExample() {
		return ex;
	}
}
