package com.guiszlima.crm_admin_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guiszlima.crm_admin_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
