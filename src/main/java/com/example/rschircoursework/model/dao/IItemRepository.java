package com.example.rschircoursework.model.dao;


import com.example.rschircoursework.model.entity.Item;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IItemRepository extends IAbstractRepository<Item>{
    List<Item> findItemByPetTypeIdAndItemTypeIdAndBrandId(Long PetTypeId, Long ItemTypeId, Long BrandId);

    List<Item> findItemByPetTypeIdAndItemTypeId(Long PetTypeId, Long ItemTypeId);
    List<Item> findItemByPetTypeIdAndBrandId(Long PetTypeId, Long BrandId);
    List<Item> findItemByItemTypeIdAndBrandId(Long ItemTypeId, Long BrandId);
    List<Item> findItemByBrandIdAndPetTypeId(Long BrandId, Long PetTypeId);

    List<Item> findItemByItemTypeId(Long itemType);
    List<Item> findItemByPetTypeId(Long PetTypeId);
    List<Item> findItemByBrandId(Long brandId);

    List<Item> findItemByItemName(String itemName);
    List<Item> findItemsByItemNameIsContainingIgnoreCase(@Param("itemName")String itemName);
}
