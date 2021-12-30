/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.model.User;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;   
import com.eCommerce.eCommerce.dao.UserRepository;
 
@Service  
public class UserService   
{

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> user = new ArrayList<User>();
        userRepository.findAll().forEach(user1 -> user.add(user1));
        return user;
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public void update(User user, int iduser) {
        userRepository.save(user);
    }
}
