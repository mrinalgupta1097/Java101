package Streams.Collectors;

import java.util.List;

public class CollectorsDemo {
  public static List<Person> createPeople() {
    return List.of(
        new Person("Sara", 20),
        new Person("Sara", 22),
        new Person("Bob", 20),
        new Person("Paula", 32),
        new Person("Paul", 32),
        new Person("Jack", 3),
        new Person("Jack", 72),
        new Person("Jill", 11));
  }

  public static void main(String[] args) {
    //    print every person
    createPeople().forEach(System.out::println);

    //    print person based on some condition
    /*
     * Streams have internal iterator
     * And they provide lazy initialization
     */
    System.out.println("\n..........print person based on some condition..........");
    createPeople().stream().filter(person -> person.getAge() > 30).forEach(System.out::println);
    System.out.println("\n..........Getting only names of persons.........");
    createPeople().stream().map(Person::getName).forEach(System.out::println);

    //    sum of all ages with reduce method
    System.out.println("\n..........print sum of all ages(multiple approach)..........");
    System.out.println(
        createPeople().stream()
            .map(Person::getAge)
            //                .reduce(0, (total, age) -> total + age));
            //        .reduce(0,(total,age)-> Integer.sum(total,age)));
            .reduce(0, Integer::sum));
    /*More about reduce() operation
     * reduce() generally means two things
     * 1. takes the collection and reduces to a single value
     *     like individual age to sum
     * 2. converts a stream to something concrete
     *     like Collection of people to collection of age(collect function)
     */

  }
}
