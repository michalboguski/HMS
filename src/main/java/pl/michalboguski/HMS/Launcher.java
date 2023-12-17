package pl.michalboguski.HMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.michalboguski.HMS.Department.DepartmentDTO;
import pl.michalboguski.HMS.Department.DepartmentEntity;
import pl.michalboguski.HMS.Department.DepartmentService;
import pl.michalboguski.HMS.Employee.EmployeesService;


@Component
public class Launcher implements CommandLineRunner {

    @Autowired
    EmployeesService employeesService;

    @Autowired
    DepartmentService departmentService;

    @Override
    public void run(String... args) throws Exception {
     //   System.out.println(employeesService.findAllEmployeesFromDataBase());
      //  System.out.println(departmentService.findAllDepartmentsEntityFromDataBase());
    }
}
