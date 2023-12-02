package pl.michalboguski.HMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.michalboguski.HMS.Employee.EmployeesService;


@Component
public class Launcher implements CommandLineRunner {

    @Autowired
    EmployeesService employeesService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(employeesService.findAllEmployeesFromDataBase());

    }
}
