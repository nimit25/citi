package spring.example.trading.service;

import java.util.Collection;
import java.util.List;

import org.bson.types.ObjectId;

import spring.example.trading.entities.Stock;


public interface StocksService {

    Collection<Stock> getStocks();
    Stock getStockbyId(ObjectId id);
    void addStocks(Stock stocks);
    void update(ObjectId id, int price);
    void deleteStocks(ObjectId id);
    void deleteAllStocks();
    List<Stock> getStocksByTicker(String ticker);
    
}