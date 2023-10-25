package pl.michalboguski.HMS.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
@Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public void deleteById(Iterable<Long> ids) {
        departmentRepository.deleteAllById(ids);
    }
    public void save(Department department){
    departmentRepository.save(department);
    }

    public Iterable<Department> findAllDepartmentsFromDataBase() {
        return departmentRepository.findAll();
    }
    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}
