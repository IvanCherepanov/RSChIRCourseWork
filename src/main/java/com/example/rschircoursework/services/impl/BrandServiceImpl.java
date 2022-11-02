package com.example.rschircoursework.services.impl;

import com.example.rschircoursework.model.dao.IBrandRepository;

import com.example.rschircoursework.model.entity.Brand;
import com.example.rschircoursework.services.IBrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends AbstractServiceImpl<Brand, IBrandRepository> implements IBrandService {
    protected BrandServiceImpl(IBrandRepository defaultDao) {
        super(defaultDao);
    }

    @Override
    public Brand update(Long id, Brand entity) {
        findById(id);
        entity.setId(id);
        return create(entity);
    }
}
