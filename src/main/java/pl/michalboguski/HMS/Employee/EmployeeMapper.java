package pl.michalboguski.HMS.Employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class EmployeeMapper {

    @Bean
    public EmployeeMapper createEmployeeeMapper(){
        return new EmployeeMapper();
    }

    public EmployeeDTO toDTO (EmployeeEntity employeeEntity){
        return new EmployeeDTO(employeeEntity.getId(),
                employeeEntity.getName(),
                employeeEntity.getSurname(),
                employeeEntity.getDob(),
                employeeEntity.getDepartment());
    }

    public EmployeeEntity toEntity (EmployeeDTO employeeDTO){
        return new EmployeeEntity(employeeDTO.getId(),
                employeeDTO.getName(),
                employeeDTO.getSurname(),
                employeeDTO.getDob(),
                employeeDTO.getDepartment());
    }
}
