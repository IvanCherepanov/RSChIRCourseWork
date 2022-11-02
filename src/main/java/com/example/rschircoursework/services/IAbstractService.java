package com.example.rschircoursework.services;

import java.util.List;

public interface IAbstractService<T> {
    T create(T entity);
    T findById(Long id);
    T update(Long id, T entity);
    boolean delete(Long id);
    List<T> getAll();
}
