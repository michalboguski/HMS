package pl.michalboguski.HMS.Employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.michalboguski.HMS.Mapper;

@Configuration
public class EmployeeMapper implements Mapper<EmployeeDTO, EmployeeEntity> {

    @Bean
    public EmployeeMapper createEmployeeeMapper(){
        return new EmployeeMapper();
    }

    public EmployeeDTO toDto(EmployeeEntity employeeEntity){
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
