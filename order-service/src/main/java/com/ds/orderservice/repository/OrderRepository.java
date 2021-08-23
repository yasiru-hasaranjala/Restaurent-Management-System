
package com.ds.orderservice.repository;

import com.ds.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findBySupplied(boolean supplied);
    List<Order> findByItemid(long itemid);
    List<Order> findByCusid(long cusid);


    List<Order> findByQuantityContaining(String quantity);
}
