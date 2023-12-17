package pl.michalboguski.HMS.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.michalboguski.HMS.Employee.Employee;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private Employee HOD;
    private Set<Employee> members;
}
