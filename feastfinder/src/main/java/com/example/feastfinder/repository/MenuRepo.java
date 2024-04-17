package com.example.feastfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.feastfinder.model.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu,Integer>{
    Menu findByFoodName(String foodName);
}
