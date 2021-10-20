package Streams.Collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class CollectorsDemo {
  public static List<Person> createPeople() {
    return List.of(
        new Person("Sara", 20),
        new Person("Nancy", 22),
        new Person("Bob", 20),
        new Person("Paula", 32),
        new Person("Paul", 32),
        new Person("Jack", 3),
        new Person("Bill", 72),
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
    System.out.println(
        "\n............names in uppercase with condition(Shared Mutability Condition)........");
    List<String> namesOlderThan30 = new ArrayList<>();

    //    Don't do this
    createPeople().stream()
        .filter(person -> person.getAge() > 30)
        .map(Person::getName)
        .map(String::toUpperCase)
        .forEach(namesOlderThan30::add);
    System.out.println(namesOlderThan30);
    /*
     * forEach() mutates the list so if you need to make this parallel
     * this will entail race condition. Remember you don't want to avoid
     * mutability we want to avoid shared mutability.
     */
    System.out.println(
        "\n............names in uppercase with condition(Shared Mutability Condition Solution)........");
    createPeople().stream()
        .filter(person -> person.getAge() > 30)
        .map(Person::getName)
        .map(String::toUpperCase)
        //        .reduce(
        //            new ArrayList<String>(),
        //            (names, name) -> {
        //              names.add(name);
        //              return names;
        //            },
        //            (names1, names2) -> {
        //              names1.addAll(names2);
        //              return names2;
        //            });
        .collect(Collectors.toList());

    /*
     * The above commented part is complex and prone to error.
     * That is why we use collect(). It takes a collector
     * which is a utility class that contains various collect methods
     * and also takes of shared mutability.
     */
    System.out.println("\n............Map name as key and age as value(Imperative style)........");

    Map<String, Integer> nameAndAge = new HashMap();
    for (Person person : createPeople()) {
      nameAndAge.put(person.getName(), person.getAge());
    }
    System.out.println(nameAndAge);

    System.out.println(
        "\n............Map name as key and age as value(using stream style)........");
    System.out.println(createPeople().stream().collect(toMap(Person::getName, Person::getAge)));
  }
}
