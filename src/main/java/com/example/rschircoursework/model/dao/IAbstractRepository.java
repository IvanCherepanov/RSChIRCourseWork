package com.example.rschircoursework.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IAbstractRepository<T> extends JpaRepository<T, Long> {
}
