package fast.comm.models;

import java.sql.Timestamp;

public class Product {
    private long id;
    private long userId;
    private String title;
    private String description;
    private Timestamp datePlaced;
    private Number price;
    private String currency;

    public Product() {
    }

    public Product(long id, long userId, String title, String description, Timestamp datePlaced, Number price, String currency) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.datePlaced = datePlaced;
        this.price = price;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getDatePlaced() {
        return datePlaced;
    }

    public Number getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatePlaced(Timestamp datePlaced) {
        this.datePlaced = datePlaced;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
