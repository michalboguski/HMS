package pl.michalboguski.HMS.Department;

import org.springframework.stereotype.Controller;
import java.util.function.Function;
@Controller
class DepartmentMapper implements Function<DepartmentEntity,DepartmentDTO> {

    @Override
    public DepartmentDTO apply(DepartmentEntity departmentEntity) {
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