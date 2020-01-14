package com.cninfo.demo.service;

import com.cninfo.demo.vo.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,String> {

}
