package com.shopping.repositories;

import com.shopping.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductsRepository extends BaseRepository<Product> {


    private static final String createProductsTable = "CREATE TABLE IF NOT EXISTS `shop`.`products` ( " +
            "  `id` INT NOT NULL AUTO_INCREMENT, " +
            "  `name` VARCHAR(100) NOT NULL, " +
            "  `price` DOUBLE NOT NULL, " +
            "  `category` VARCHAR(100) NOT NULL, " +
            "  `describtion` MEDIUMTEXT NULL, " +
            "  `amount` INT NOT NULL, " +
            "  PRIMARY KEY (`id`), " +
            "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);";

    private static final String[] fakeDataInsert =
            {"INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('iphone', '100', 'electric', 'good thing', '20');\n",
                    "INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('nokia', '50', 'electric', 'normal thing', '20');\n",
                    "INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('samsung', '90', 'electric', 'best thing in the world', '20');\n",
                    "INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('tale of two cities', '10', 'book', 'good book', '20');\n",
                    "INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('the 3 muskitiers', '9', 'book', 'nice book', '20');\n",
                    "INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('dracula', '11', 'book', 'best book', '20');\n",
                    "INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('nike', '50', 'wear', 'nice shoe', '20');\n",
                    "INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('adidas', '49', 'wear', 'so good shoe', '20');\n",
                    "INSERT INTO `shop`.`products` (`name`, `price`, `category`, `describtion`, `amount`) VALUES ('burbery', '80', 'waer', 'best shoe', '20');"};

    public ProductsRepository() {

        if (!checkIfTableExists("products")) {
            this.createTable();
            faker();
        }

    }

    @Override
    public boolean create(Product model) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void update(Product model) {

    }

    @Override
    public Product read(Product model) {
        return null;
    }

    @Override
    public ArrayList<Product> readAll() {
         ArrayList<Product> allProducts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT `name`,\n" +
                            "`price`,\n" +
                            "`category`,\n" +
                            "`describtion`,\n" +
                            "`amount` FROM `shop`.`products` ");
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getString("name"),
                        resultSet.getString("describtion"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount")
                );
                allProducts.add(product);
            }

        } catch (Exception e) {

        }

        return allProducts;
    }

    @Override
    public void delete(Product model) {

    }

    @Override
    public void createTable() {
        simpleSQLUpdate(createProductsTable);
    }

    @Override
    public void faker() {
        for (String q : fakeDataInsert) {
            simpleSQLUpdate(q);
        }
    }
}
