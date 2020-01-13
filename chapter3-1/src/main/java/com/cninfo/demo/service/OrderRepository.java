package com.cninfo.demo.service;

import com.cninfo.demo.vo.Order;
import org.springframework.stereotype.Repository;


public interface OrderRepository {
    Order save(Order order);
}
