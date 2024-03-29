
package com.example.demo.securityConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);

	boolean existsByUserName(String userName);
}
