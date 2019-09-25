package com.efg.clientbackend.service;

import com.efg.clientbackend.entities.IUser;
import com.efg.clientbackend.controllers.exceptions.UserNotFoundException;
import com.efg.clientbackend.entities.User;
import com.efg.clientbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

import static java.util.Collections.singletonList;

@Service
public class UserService implements IUserService<User, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findById(final String id) {
        return singletonList(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> var1) {
        return userRepository.saveAll(var1);
    }

    @Override
    public <S extends User> S save(S var1) {
        return userRepository.save(var1);
    }

    @Override
    public User delete(final String id) {
        final User user = findById(id).get(0);
        userRepository.delete(user);
        return user;
    }

    @Override
    public Map<String, List<User>> findAllGroupByGroupId() {
        return findAll().stream().collect(groupingBy(IUser::getGroupId, TreeMap::new, Collectors.toList()));
    }
}