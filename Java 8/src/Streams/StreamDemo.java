package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {
  public static void main(String[] args) {
    //
    List<EmployeeHelper> empList = new ArrayList<>();
    empList.add(new EmployeeHelper(101, "Manoj", 1, "active", 2000));
    empList.add(new EmployeeHelper(102, "Ram", 2, "active", 3000));
    empList.add(new EmployeeHelper(103, "Shyam", 1, "inactive", 2000));
    empList.add(new EmployeeHelper(104, "Deepak", 2, "active", 4000));
    empList.add(new EmployeeHelper(105, "Raaj", 3, "inactive", 2000));
    empList.add(new EmployeeHelper(106, "Samyak", 1, "active", 6000));
    empList.add(new EmployeeHelper(107, "Madhav", 4, "active", 2000));

    //    to print emp details based on dept
    Map<Integer, List<EmployeeHelper>> empDetailsBasedOnDept =
        empList.stream()
            .collect(Collectors.groupingBy(EmployeeHelper::getDeptID, Collectors.toList()));
    empDetailsBasedOnDept.forEach((key, value) -> System.out.println(key + " : " + value));

    //    count of employees based on department.
    Map<Integer, Long> empDetailsCountDept =
        empList.stream()
            .collect(Collectors.groupingBy(EmployeeHelper::getDeptID, Collectors.counting()));
    empDetailsCountDept.forEach((key, value) -> System.out.println("dept " + key + ": " + value));

    //    to print active/inactive employees
    long activeCount = empList.stream().filter(emp -> "active".equals(emp.getStatus())).count();
    long inactiveCount = empList.stream().filter(emp -> "inactive".equals(emp.getStatus())).count();
    System.out.println("active : " + activeCount + ", inactive : " + inactiveCount);

//    details of employee getting maximum salary

  }
}
