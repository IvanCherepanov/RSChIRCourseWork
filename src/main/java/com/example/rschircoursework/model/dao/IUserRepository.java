package com.example.rschircoursework.model.dao;


import com.example.rschircoursework.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IAbstractRepository<User>{
    User findUserByUsername(String name);
}
