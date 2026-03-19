package com.example.repositories;

import com.example.entity.SalesDTO;
import com.example.entity.SalesOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {
    @Query("SELECT so.customer, so.amount FROM SalesOrder so")
    List<Object[]> getScalarProjections();

    @Query("SELECT new com.example.entity.SalesDTO(so.customer, so.amount) FROM SalesOrder so")
    List<SalesDTO> getDtoProjections();
}
