package com.aggro.api.repository;

import com.aggro.api.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.LinkedList;

/**
 * Created by yeko on 17/10/15.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByAggroID(String aggroID);

    User findByEmail(String email);

    User findByUsername(String username);

    User findByEmailAndPassword(String email, String password);

}
