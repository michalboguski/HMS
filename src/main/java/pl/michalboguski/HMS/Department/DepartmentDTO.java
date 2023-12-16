package pl.michalboguski.HMS.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.michalboguski.HMS.Employee.Employee;
import java.util.Set;

@Data
@AllArgsConstructor
public class DepartmentDTO {
    private String name;
    private Employee HOD;
    private Set<Employee> members;
}
