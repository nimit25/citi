package spring.example.trading.repo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import spring.example.trading.entities.Stock;

public interface StocksRepo extends MongoRepository<Stock,ObjectId> 

{
    List<Stock> findByTicker(String ticker);

    
}