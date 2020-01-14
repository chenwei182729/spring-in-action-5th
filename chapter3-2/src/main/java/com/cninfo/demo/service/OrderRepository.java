package com.cninfo.demo.service;

import com.cninfo.demo.vo.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends CrudRepository<Order, Long> {
}
