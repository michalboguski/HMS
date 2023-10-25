package pl.michalboguski.HMS.Departament;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.michalboguski.HMS.Emplyee.Employee;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name="departments")
public class Department {
   // @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Employee HOD;
    private Set<Employee> members;
}
