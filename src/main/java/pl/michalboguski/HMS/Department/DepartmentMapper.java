package pl.michalboguski.HMS.Department;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.michalboguski.HMS.Mapper;

@Configuration
class DepartmentMapper implements Mapper<DepartmentDTO, DepartmentEntity> {

    @Bean
    public DepartmentMapper createDepartmentMapper(){
        return new DepartmentMapper();
    }

    public DepartmentDTO toDto(DepartmentEntity departmentEntity) {
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