package pl.michalboguski.HMS.Department;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import pl.michalboguski.HMS.Employee.EmployeeEntity;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToOne
    private EmployeeEntity HOD;
    @Column(name = "members")
    @OneToMany (mappedBy = "department", cascade = CascadeType.REFRESH)
    private Set<EmployeeEntity> members;
    @Override
    public String toString() {
        return id +" "+name +" " + HOD + members;
    }
}
