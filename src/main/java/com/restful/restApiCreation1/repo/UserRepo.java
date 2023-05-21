package com.restful.restApiCreation1.repo;

import com.restful.restApiCreation1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
