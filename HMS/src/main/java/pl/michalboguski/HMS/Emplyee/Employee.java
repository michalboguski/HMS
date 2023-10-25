package pl.michalboguski.HMS.Emplyee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last-name")
    private String surname;
    @Column(name = "dob")
    private LocalDate dob;

    @Override
    public String toString() {
        return
                //id +  " " +
                name + " " + surname + " " + dob;
    }
}
