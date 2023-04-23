package com.example.rschircoursework.services;

import com.example.rschircoursework.model.entity.Item;

import java.util.List;

public interface IItemService extends IAbstractService<Item> {
    List<Item> getItemByName(String name);
    List<Item> getItemByItemType(Long itemType);
    List<Item> getAllSorting(Integer flag,List<Item> temp);
    List<Item> getItemByPetId(Long pId);
    List<Item> getItemByBrandId(Long bId);
    List<Item> getItemByItemTypeId(Long bId);
    List<Item> getItemByPetIdAndTypeId(Long pId, Long Iid);
    List<Item> getItemByPetIdAndBrandId(Long pId, Long bId);
    List<Item> getItemByItemTypeIdAndBrandId(Long Iid, Long bId);
    List<Item> getItemByBrandIdAndPetId(Long bId, Long pId);
    List<Item> getItemByPetIdAndTypeIdAndBrandId(Long pId, Long Iid, Long bId);
    List<Item> getItemContainingItemName(String name);
}
