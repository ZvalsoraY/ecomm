package fast.comm.dao;

import fast.comm.models.Product;

import java.util.List;

public interface ProductDao {
    Product getById(long id);
    void create(Product product);
    void update(Product product);
    void deleteById(long product);
    List<Product> getAll();
}
