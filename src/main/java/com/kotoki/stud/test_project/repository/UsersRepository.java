package com.kotoki.stud.test_project.repository;

import com.kotoki.stud.test_project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//@ComponentScan
//@Configuration
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByName(String name);

    @Query("select u from Users u where u.email like '%@gmail.com%'")
    List<Users> findWhereEmailIsGmail();

    @Query(value = "select * from users where name like '%smith%'", nativeQuery = true)
    List<Users> findWhereNameStartsFromSmith();
}
