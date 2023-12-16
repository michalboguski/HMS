package pl.michalboguski.HMS.Department;

import org.springframework.stereotype.Controller;

import java.util.function.Function;
@Controller
class DepartmentMapper implements Function<DepartmentEntity,DepartmentDTO> {

    @Override
    public DepartmentDTO apply(DepartmentEntity departmentEntity) {
        return new DepartmentDTO(departmentEntity.getName(),
                departmentEntity.getHOD(),
                departmentEntity.getMembers());
    }
}