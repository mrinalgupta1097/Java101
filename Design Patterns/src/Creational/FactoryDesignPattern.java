package Creational;

public class FactoryDesignPattern {
  /*About :
   * 1. Creational design Pattern
   * 2.Used when we have multiple sub-classes of a super class and
   *   based on input we want to return one class instance
   * 3. Provides abstraction between implementation and client classes.
   * 4. Removes the instantiation of client classes from client code. */

  /*How to Implement :
   * 1. Superclass can be an interface, abstract class or basic class.
   * 2. Factory class has a static method
   *   which returns the instance of sub-class based on input.*/

  public static void main(String[] args) {
    //
    Vehicle car = VehicleFactory.getInstance("car", 4);
    System.out.println(car);
  }
}

abstract class Vehicle {
  public abstract int getWheel();

  @Override
  public String toString() {
    return "Wheel: " + this.getWheel();
  }
}

class Car extends Vehicle {
  int wheel;

  public Car(int wheel) {
    this.wheel = wheel;
  }

  @Override
  public int getWheel() {
    return this.wheel;
  }
}

class Bicycle extends Vehicle {
  int wheel;

  public Bicycle(int wheel) {
    this.wheel = wheel;
  }

  @Override
  public int getWheel() {
    return this.wheel;
  }
}

class VehicleFactory{
  public static Vehicle getInstance(String type, int wheel){
    if(type == "car"){
      return new Car(wheel);
    }else if(type == "Bicycle"){
      return new Bicycle(wheel);
    }
    return null;
  }
}
