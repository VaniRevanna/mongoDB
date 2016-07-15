package com.mf.mongo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mf.mongo.User;

//@RepositoryRestResource(collectionResourceRel = "Users", path = "users")
public interface UsersRepository extends MongoRepository<User, String> {

}
