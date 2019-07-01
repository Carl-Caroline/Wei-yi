package HomeWork;
//单例模式

//只能有一个实例
//必须创建自己的唯一实例
//必须向其他对象提供这一实例

public class Singleton {
	private static Singleton ex = new Singleton();	//创建自己的唯一实例
	private Singleton() {		
	}
	public static Singleton returnExample() {
		return ex;
	}
}
