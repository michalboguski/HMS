package pl.michalboguski.HMS.Department;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.michalboguski.HMS.Employee.Employee;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToOne
    private Employee HOD;
    @Column(name = "members")
    @OneToMany (mappedBy = "department")
    private Set<Employee> members;
}
