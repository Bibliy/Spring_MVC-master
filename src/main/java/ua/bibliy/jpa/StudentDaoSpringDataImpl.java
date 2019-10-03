package ua.bibliy.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StudentDaoSpringDataImpl {
    @PersistenceContext//проверка спринга в базе даных с наворотами

            EntityManager entityManager;

}