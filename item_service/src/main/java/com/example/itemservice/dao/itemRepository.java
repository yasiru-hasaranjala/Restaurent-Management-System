package com.example.itemservice.dao;

import com.example.itemservice.model.itemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemRepository extends JpaRepository <itemModel, String>{

}
