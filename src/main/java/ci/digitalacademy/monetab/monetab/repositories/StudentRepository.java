package ci.digitalacademy.monetab.monetab.repositories;

import ci.digitalacademy.monetab.monetab.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
