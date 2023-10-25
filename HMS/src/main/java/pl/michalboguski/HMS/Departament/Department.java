package pl.michalboguski.HMS.Departament;

import pl.michalboguski.HMS.Emplyee.Employee;

import java.util.Set;

public class Department {
    private long id;
    private String name;
    private Employee HOD;
    private Set<Employee> members;
}
