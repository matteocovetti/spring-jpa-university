package jana60.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jana60.model.Departments;

@Repository
public interface DepartmentsRepository extends CrudRepository<Departments, Integer> {

	List<Departments> findAllByOrderByName();

	List<Departments> findAllByOrderByNameDesc();
}
