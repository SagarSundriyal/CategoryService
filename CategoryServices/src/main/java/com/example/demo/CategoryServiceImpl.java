package com.example.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

    @Override   ////create  getall  get
    public CategoryEntity create(CategoryEntity hotel) {
        //String hotelId = UUID.randomUUID().toString();
        //hotel.setId(hotelId);
        return categoryRepository.save(hotel);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity get(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category with given id not found !!"));
    }

	@Override
	public CategoryEntity updateUser(CategoryEntity user) {
		// TODO Auto-generated method stub
		CategoryEntity existingUser = categoryRepository.findById(user.getId()).get();
	        existingUser.setName(user.getName());
	        existingUser.setLocation(user.getLocation());
	        existingUser.setAbout(user.getAbout());
	        CategoryEntity updatedUser = categoryRepository.save(existingUser);
	        return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(userId);
	}


}