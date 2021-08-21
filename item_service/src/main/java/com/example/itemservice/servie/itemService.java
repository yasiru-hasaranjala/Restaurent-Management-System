package com.example.itemservice.servie;

import com.example.itemservice.model.itemModel;
import com.example.itemservice.dao.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemService {

    @Autowired
    private itemRepository iRepository;

    public  void saveOrder(itemModel item){
        iRepository.save(item);
    }

    public List<itemModel> getAllItem(){
        return  iRepository.findAll();
    }

    public void updateItem (itemModel data, String itemid) {

        itemModel updateItem = new itemModel();

        updateItem.setItemID(itemid);
        updateItem.setItemName(data.getItemName());
        updateItem.setImgUrl(data.getImgUrl());
        updateItem.setDescription(data.getDescription());
        updateItem.setPrice(data.getPrice());

        iRepository.save(updateItem);
    }

    public void deleteItem(String itemid){
        iRepository.deleteById(itemid);
    }
}
