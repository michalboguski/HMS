package pl.michalboguski.HMS.Department;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.michalboguski.HMS.Employee.Employee;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToOne
    private Employee HOD;
    @Column(name = "members")
    @OneToMany (mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> members;
}
