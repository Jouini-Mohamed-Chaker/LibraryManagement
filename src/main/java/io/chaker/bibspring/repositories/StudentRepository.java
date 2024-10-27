package io.chaker.bibspring.repositories;

import io.chaker.bibspring.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
