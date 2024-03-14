package fast.comm.dao;

import fast.comm.models.Product;
import fast.comm.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoJbdc implements ProductDao{
    private final NamedParameterJdbcOperations jdbc;

    private final String  selectProducts = "SELECT prd.id prod_id,\n" +
            "                          prd.user_id produser_id,\n" +
            "                          prd.title prod_title,\n" +
            "                          prd.description prod_description,\n" +
            "                          prd.dateplaced prod_dateplaced,\n" +
            "                          prd.price prod_price,\n" +
            "                          prd.currency prod_currency\n" +
            "                          FROM PRODUCTS prd\n";


    public ProductDaoJbdc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Product getById(long id) {
        final Map<String,Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject( selectProducts +
                        " WHERE prd.id = :id",
                Map.of("id", id),
                new ProductMapper());
    }

    @Override
    public void create(Product product) {
        jdbc.update("insert into PRODUCTS (" +
                        "    user_id,\n" +
                        "    title,\n" +
                        "    description\n" +
                        "    dateplaced\n" +
                        "    price\n" +
                        "    currency\n" +
                        ")"+
                        "   values ( " +
                        "      :user_id,\n" +
                        "      :title,\n" +
                        "      :description\n" +
                        "      :dateplaced\n" +
                        "      :price\n" +
                        "      :currency\n" +
                        ")",
                Map.of("user_id", product.getUserId(),
                        "title", product.getTitle(),
                        "description", product.getDescription(),
                        "dateplaced", product.getDatePlaced(),
                        "price", product.getPrice(),
                        "currency", product.getCurrency()));
    }

    @Override
    public void update(Product product) {
        jdbc.update("update PRODUCTS  SET" +
                        " user_id = :user_id,\n" +
                        " title = :title,\n" +
                        " description = :description\n" +
                        " description = :description\n" +
                        " dateplaced = :dateplaced\n" +
                        " price = :price\n" +
                        " currency = :currency\n" +
                        "WHERE ID = :id",
                Map.of("id", product.getId(),
                        "user_id", product.getUserId(),
                        "title", product.getTitle(),
                        "description", product.getDescription(),
                        "dateplaced", product.getDatePlaced(),
                        "price", product.getPrice(),
                        "currency", product.getCurrency() ));

    }

    @Override
    public void deleteById(long id) {
        jdbc.update("DELETE FROM PRODUCTS WHERE id = :id", Map.of("id", id));
    }

    @Override
    public List<Product> getAll() {
        return jdbc.query(selectProducts+
                " ORDER BY prd.id", new ProductMapper());
    }

    private static class ProductMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Product(resultSet.getLong("prod_id"),
                    resultSet.getLong("produser_id"),
                    resultSet.getString("prod_title"),
                    resultSet.getString("prod_description"),
                    resultSet.getTimestamp("prod_dateplaced"),
                    resultSet.getBigDecimal("prod_price"),
                    resultSet.getString("prod_currency"));
        }
    }
}
//long id, long userId, String title, String description, Timestamp datePlaced, Number price, Currency currency