package ua.bibliy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.bibliy.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "SELECT s FROM  Student  where  s.name=?1 and  s.lastName=?1")

    Student findByNameAndLastName(String firstName,String lastName);
}
