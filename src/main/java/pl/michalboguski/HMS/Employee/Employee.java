package pl.michalboguski.HMS.Employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.michalboguski.HMS.Department.DepartmentEntity;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "people")
public class Employee {
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
}
