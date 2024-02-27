package pl.michalboguski.HMS.Department;

import lombok.*;
import pl.michalboguski.HMS.Employee.EmployeeEntity;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private EmployeeEntity HOD;
    private Set<EmployeeEntity> members;

}
