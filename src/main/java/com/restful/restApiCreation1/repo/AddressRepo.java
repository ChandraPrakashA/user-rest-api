package com.restful.restApiCreation1.repo;

import com.restful.restApiCreation1.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address,Long> {
    @Query("select a FROM Address a where a.user.id = :uid")
    Address findAllByUserId(@Param("uid") Long userId);

}
