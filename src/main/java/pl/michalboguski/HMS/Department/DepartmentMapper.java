package pl.michalboguski.HMS.Department;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DepartmentMapper  {

    @Bean
    public DepartmentMapper createDepartmentMapper(){
        return new DepartmentMapper();
    }

    public DepartmentDTO toDao(DepartmentEntity departmentEntity) {
        return new DepartmentDTO(departmentEntity.getId(),
                departmentEntity.getName(),
                departmentEntity.getHOD(),
                departmentEntity.getMembers());
    }

    public DepartmentEntity toEntity(DepartmentDTO departmentDTO){
        return new DepartmentEntity(departmentDTO.getId(),
                departmentDTO.getName(),
                departmentDTO.getHOD(),
                departmentDTO.getMembers());
    }
}