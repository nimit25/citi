package spring.example.trading.controller;

import java.util.Collection;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.example.trading.entities.Stock;
import spring.example.trading.service.StocksService;

@RestController
@CrossOrigin
public class StocksController {

    @Autowired
    private StocksService service;

    @RequestMapping(path = "/stocks",method=RequestMethod.GET)
    public Collection<Stock> getStocks(){
        return service.getStocks();
    }

    @RequestMapping(path = "/stocks",method=RequestMethod.POST)
    public void addStocks(@RequestBody Stock stocks) {
        service.addStocks(stocks);
    }
    @RequestMapping(path = "/stocks/{id}",method=RequestMethod.GET)
    public Stock getStocksbyId(@PathVariable("id")  String id){
        ObjectId id2 = new ObjectId(id);
        return service.getStockbyId(id2);
    }

    @RequestMapping(path = "/stocks/{id}", method = RequestMethod.PUT)
    public void updateStock(@PathVariable("id")  String id, @RequestBody  int price) {
        ObjectId id2 = new ObjectId(id);
        service.update(id2, price);
      
   }
   @RequestMapping(value = "/stocks/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
       ObjectId id2  = new ObjectId(id);
      service.deleteStocks(id2);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }

   @RequestMapping(value = "/stocks", method = RequestMethod.DELETE)
   public ResponseEntity<Object> deleteAll() { 
       service.deleteAllStocks();
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }

   @RequestMapping(value = "/stocks", method = RequestMethod.GET)
   public List<Stock> findByTicker(@RequestParam("ticker") String ticker){
      return service.getStocksByTicker(ticker);
   }

   


    
}
