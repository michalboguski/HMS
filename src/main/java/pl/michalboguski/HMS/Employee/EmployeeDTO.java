package pl.michalboguski.HMS.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.michalboguski.HMS.Department.DepartmentEntity;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String surname;
    private LocalDate dob;
    private DepartmentEntity department;

}
