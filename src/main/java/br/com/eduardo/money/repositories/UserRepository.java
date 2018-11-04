package br.com.eduardo.money.repositories;

import br.com.eduardo.money.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId>, QuerydslPredicateExecutor<User> {

    Optional<User> findByEmail(String email);

}
