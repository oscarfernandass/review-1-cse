package com.example.feastfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feastfinder.model.Menu;
import com.example.feastfinder.repository.MenuRepo;

@Service
public class MenuService {
    
    @Autowired
    private MenuRepo menuRepo;

    public Menu insert(Menu menu)
    {
        return menuRepo.save(menu);
    }
    public List<Menu> display()
    {
        return menuRepo.findAll();
    }
    public Menu find(String foodName)
    {
        return menuRepo.findByFoodName(foodName);
    }
    public void delete(int id)
    {
        menuRepo.deleteById(id);
    }
}
