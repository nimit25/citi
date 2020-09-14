package spring.example.trading.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
    @Id
    private ObjectId id;
    private int StockQuantity;
    private double RequestedPrice;
    private  String  ticker;

    enum TradeStatus {
        CREATED, PENDING, CANCELLED, REJECTED, FILLED, PARTIALLY_FIILED, ERROR
    }
    public Stock() {

    }
    public Stock(String ticker, int quantity){
        this.ticker = ticker;
        this.StockQuantity = quantity;

    }

    public ObjectId getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public double getRequestedPrice() {
        return RequestedPrice;
    }

    public void setRequestedPrice(double requestedPrice) {
        RequestedPrice = requestedPrice;
    };

    
}