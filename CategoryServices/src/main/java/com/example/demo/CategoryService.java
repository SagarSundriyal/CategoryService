package com.example.demo;

import java.util.List;

public interface CategoryService {


    //create

	CategoryEntity create(CategoryEntity hotel);

    //get all
    List<CategoryEntity> getAll();

    //get single
    CategoryEntity get(Long id);
    
    

    CategoryEntity updateUser(CategoryEntity user);

    void deleteUser(Long userId);

}//create  getall  get