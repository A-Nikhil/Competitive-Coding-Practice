package JavaSyntaxAndFunctions.Basics;

public class ObjectSwapping {
	public static void main(String[] args) {
		Car c1 = new Car(123, 456);
		Car c2 = new Car(789, 999);
		new ObjectSwapping().swap(c1, c2);
	}

	private void swap(Car c1, Car c2) {
		CarWrapper wrapper1 = new CarWrapper(c1);
		CarWrapper wrapper2 = new CarWrapper(c2);
		System.out.println("Before Swapping => " + c1 + " ; " + c2);
		Car temp = wrapper1.car;
		wrapper1.car = wrapper2.car;
		wrapper2.car = temp;
		c1 = wrapper1.car;
		c2 = wrapper2.car;
		System.out.println("After Swapping => " + c1 + " ; " + c2);
	}

	static class Car {
		int number, model;

		public Car(int number, int model) {
			this.number = number;
			this.model = model;
		}

		@Override
		public String toString() {
			return "Car : " +
					"{number: " + this.number +
					", model: " + this.model +
					"}";
		}
	}

	static class CarWrapper {
		Car car;

		public CarWrapper(Car car) {
			this.car = car;
		}
	}
}
