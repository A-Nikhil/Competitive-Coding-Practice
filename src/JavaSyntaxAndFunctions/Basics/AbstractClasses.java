package JavaSyntaxAndFunctions.Basics;

public class AbstractClasses extends Demo {
	public static void main(String[] args) {
		AbstractClasses obj = new AbstractClasses();
		System.out.println(obj.multiply(2, 3));
		System.out.println(obj.divide(6, 3));
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}
}

abstract class Demo {
	public int multiply(int a, int b) {
		return a * b;
	}

	public abstract int divide(int a, int b);
}
