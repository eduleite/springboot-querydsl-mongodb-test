package br.com.eduardo.money.repositories;

import br.com.eduardo.money.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import static br.com.eduardo.money.model.QUser.user;

public interface UserRepository extends MongoRepository<User, ObjectId>, QuerydslPredicateExecutor<User> {

    default Iterable<User> findByEmail(String email) {
        return findAll(user.email.eq(email), user.name.asc());
    }

}
