package JavaSyntaxAndFunctions.Inheritance;

class SuperClass {
	SuperClass() {
		System.out.println("This is the super class");
	}

	public void show() {
		System.out.println("I am displaying from the super class");
	}
}

class SubClass extends SuperClass {
	SubClass() {
		System.out.println("This is the sub class");
	}

	public void show() {
		super.show();
		System.out.println("I am displaying from the sub class");
	}
}

public class ObjectCreation {
	public static void main(String[] args) {
		SuperClass obj1 = new SuperClass();
		SuperClass obj2 = new SubClass();
		SubClass obj3 = new SubClass();

		System.out.println("\nShowing from object 1");
		obj1.show();

		System.out.println("\nShowing from object 2");
		obj2.show();

		System.out.println("\nShowing from object 3");
		obj3.show();
	}
}
