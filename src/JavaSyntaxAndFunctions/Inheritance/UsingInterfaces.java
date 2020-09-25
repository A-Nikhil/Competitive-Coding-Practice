/*
Design a Vehicle framework. There would be two vehicles - Bike and Car.
Given the previous speed - a Bike will double the speed and a car will triple the speed.
Provide implementation using Interfaces
 */

package JavaSyntaxAndFunctions.Inheritance;

interface Vehicle {
	int changeSpeed(int oldSpeed);
}

class Bike implements Vehicle {
	@Override
	public int changeSpeed(int oldSpeed) {
		return oldSpeed * 2;
	}
}

class Car implements Vehicle {
	@Override
	public int changeSpeed(int oldSpeed) {
		return oldSpeed * 3;
	}
}

public class UsingInterfaces {
	public static void main(String[] args) {
		Car car = new Car();
		Bike bike = new Bike();
		int oldSpeed = 25;
		System.out.println("Bike speed changes to = " + bike.changeSpeed(oldSpeed));
		System.out.println("Car speed changes to = " + car.changeSpeed(oldSpeed));
	}
}
