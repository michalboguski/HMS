package pl.michalboguski.HMS.Departament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
//@Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


}
