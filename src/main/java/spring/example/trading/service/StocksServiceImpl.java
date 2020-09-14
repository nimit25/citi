package spring.example.trading.service;

import java.util.Collection;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import spring.example.trading.entities.Stock;
import spring.example.trading.repo.StocksRepo;
import java.util.List;

@Service
public class StocksServiceImpl implements StocksService {

    @Autowired
    private StocksRepo repo;

    @Override
    public Collection<Stock> getStocks() {
        return repo.findAll();
    }

    @Override
    public void addStocks( Stock stocks) {
        repo.insert(stocks);
    }

    @Override
    public void deleteStocks( ObjectId id) {
        Optional<Stock> stock1 = repo.findById(id);
        if (stock1 != null) {
            
            Stock stock2 = stock1.get();
            repo.delete(stock2);
            
        }
        
    }

    @Override
    public void update( ObjectId id, int price) {

         Optional<Stock> stock1 = repo.findById(id);
        if (stock1 != null) {
            
            Stock stock2 = stock1.get();
            stock2.setRequestedPrice(price);
            repo.save(stock2);
            
        }

    }

    @Override
    public Stock getStockbyId(ObjectId id) {
        Optional<Stock> stock1 = repo.findById(id);
        if (stock1 != null) {
             Stock stock2 = stock1.get();
            return stock2;
        }
        return new Stock();
    }

    @Override
    public void deleteAllStocks() {
        // TODO Auto-generated method stub
        repo.deleteAll();

    }

    @Override
    public List<Stock> getStocksByTicker(String ticker) {
        // TODO Auto-generated method stub
        return repo.findByTicker(ticker);  
      }





    
}