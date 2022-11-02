package com.example.rschircoursework.services.impl;


import com.example.rschircoursework.model.dao.IPetRepository;
import com.example.rschircoursework.model.entity.Pet;
import com.example.rschircoursework.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PetServiceImpl extends AbstractServiceImpl<Pet, IPetRepository> implements IPetService {
    @Autowired
    protected PetServiceImpl(IPetRepository defaultDao) {
        super(defaultDao);
    }

    @Override
    public Pet update(Long id, Pet entity) {
        findById(id);
        entity.setId(id);
        return create(entity);
    }
}
