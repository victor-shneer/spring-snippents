package com.carmel.springSnippents.repository;

import com.carmel.springSnippents.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User,Integer> {
    //    JPQL examples
    @Query("SELECT name FROM User")
    Collection<User> findAllActiveUsers();

//    @Query(value = "SELECT name FROM User name ORDER BY id")
//    Page<User> findAllUsersWithPagination(Pageable pageable);

//    @Modifying
//    @Query("update User u set u.status = :status where u.name = :name")
//    int updateUserSetStatusForName(@Param("status") Integer status,
//                                   @Param("name") String name);
}
