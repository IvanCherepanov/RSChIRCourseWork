package com.example.rschircoursework.model.dao;


import com.example.rschircoursework.model.entity.Item;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IItemRepository extends IAbstractRepository<Item>{
    List<Item> findItemByItemName(String itemName);
    List<Item> findItemByItemTypeId(Long itemType);
    List<Item> findItemByPetTypeIdAndItemTypeId(Long PetTypeId, Long ItemTypeId);
    List<Item> findItemByPetTypeId(Long PetTypeId);
    List<Item> findItemsByItemNameIsContainingIgnoreCase(@Param("itemName")String itemName);
}
