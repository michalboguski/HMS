package pl.michalboguski.HMS.Employee;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import pl.michalboguski.HMS.Department.DepartmentEntity;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last-name")
    private String surname;
    @Column(name = "dob")
    private LocalDate dob;
    @ManyToOne(fetch = FetchType.LAZY)
    private DepartmentEntity department;

    @Override
    public String toString() {
        return name + " " + surname + " " + dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeEntity employeeEntity = (EmployeeEntity) o;
        return id != null && Objects.equals(id, employeeEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
