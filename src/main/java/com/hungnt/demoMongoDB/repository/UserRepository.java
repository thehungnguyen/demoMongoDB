package com.hungnt.demoMongoDB.repository;

import com.hungnt.demoMongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
