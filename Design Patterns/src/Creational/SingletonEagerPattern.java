package Creational;

public class SingletonEagerPattern {
  /*About :
   * Creational Design Pattern
   * Only one instance of the class should exist.
   * Other classes should be able to get the instance if singleton class.
   * Used in logging, Cache, Session etc*/

  /* How to implement
   *  1. Make the constructor private.
   * 2. public method for returning instance.
   * 3. instance type - private static.*/

  /*Initialization Type :
   * 1. Eager
   * 2. Lazy
   * 3. Thread Safe Method Initialization
   * 4. Thread Safe Block initialization.*/

  //    instance type - private static
  private static SingletonEagerPattern instance = new SingletonEagerPattern();

  //    Make the constructor private.
  private SingletonEagerPattern() {}

  //    public method for returning instance.
  public static SingletonEagerPattern getInstance() {
    return instance;
  }
}
// Lazy loading

class SingletonLazy {
  private static SingletonLazy lazyInstance;

  private SingletonLazy() {}

  public static SingletonLazy getInstance() {
    if (lazyInstance == null) {
      lazyInstance = new SingletonLazy();
    }
    return lazyInstance;
  }
}

// syncronized
class SingletonSyncronized {
  private static SingletonSyncronized lazyInstance;

  private SingletonSyncronized() {}

  public static synchronized SingletonSyncronized getInstance() {
    if (lazyInstance == null) {
      lazyInstance = new SingletonSyncronized();
    }
    return lazyInstance;
  }
}

class SingletonExample {
  public static void main(String[] args) {
    // eager
    SingletonEagerPattern instance = SingletonEagerPattern.getInstance();
    System.out.println(instance);

    SingletonEagerPattern instance1 = SingletonEagerPattern.getInstance();
    System.out.println(instance1);

    //    lazy
    SingletonLazy lazy1 = SingletonLazy.getInstance();
    System.out.println(lazy1);
    SingletonLazy lazy2 = SingletonLazy.getInstance();
    System.out.println(lazy2);
  }
}
