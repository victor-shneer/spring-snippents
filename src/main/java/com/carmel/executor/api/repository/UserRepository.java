package com.carmel.executor.api.repository;

import com.carmel.executor.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
