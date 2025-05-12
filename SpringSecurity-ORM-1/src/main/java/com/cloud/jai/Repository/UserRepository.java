package com.cloud.jai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cloud.jai.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	    @Query("SELECT u FROM User u WHERE u.userEmail = :email")
	    Optional<User> findUserByEmail(@Param("email") String email);

}
