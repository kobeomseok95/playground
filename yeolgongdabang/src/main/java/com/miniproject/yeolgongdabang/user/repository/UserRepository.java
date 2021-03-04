package com.miniproject.yeolgongdabang.user.repository;

import com.miniproject.yeolgongdabang.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
