package com.mohsinkd786.repository;

import com.mohsinkd786.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserId(String id);

    //@Query("SELECT u from User u where u.email=?1 ") // this is jpql not sql, map params based on index
    @Query("select u from User u where u.email=:eadd")
    User fetchByEmailAddress(@Param("eadd") String email);
}
