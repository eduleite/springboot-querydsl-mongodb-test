package br.com.eduardo.money.repositories;

import br.com.eduardo.money.model.Transaction;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransactionRepository extends MongoRepository<Transaction, ObjectId>, QuerydslPredicateExecutor<Transaction> {

    
}