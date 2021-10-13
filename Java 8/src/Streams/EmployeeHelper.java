package Streams;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class EmployeeHelper {
    private int empId;
    private String name;
    private int deptID;
    private String status = "active";
    private int salary;
}
