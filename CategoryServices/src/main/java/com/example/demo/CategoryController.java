package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;  ///create  getall  get

    //create
    @PostMapping
    public ResponseEntity<CategoryEntity> createHotel(@RequestBody CategoryEntity hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(hotel));
    }


    //get single
    @GetMapping("{id}")
    public ResponseEntity<CategoryEntity> createHotel(@PathVariable("id") Long hotelId) {
    //public ResponseEntity<CategoryEntity> createHotel(@RequestParam(value = "id", required = false)String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.get(hotelId));
    }
   

    //get all
    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }
   
 
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<CategoryEntity> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody CategoryEntity user){
        user.setId(userId);
        CategoryEntity updatedUser = categoryService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
    	categoryService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}