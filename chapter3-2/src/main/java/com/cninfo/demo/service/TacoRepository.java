package com.cninfo.demo.service;

import com.cninfo.demo.vo.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco,Long> {
}
