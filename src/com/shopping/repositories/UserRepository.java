package com.shopping.repositories;

import com.shopping.models.Product;
import com.shopping.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserRepository extends BaseRepository<User> {


    private static final String createUserTable =
                    "CREATE TABLE IF NOT EXISTS `shop`.`users` (" +
                    "  `f_name` VARCHAR(100) NULL," +
                    "  `l_name` VARCHAR(100) NULL," +
                    "  `phone` VARCHAR(14) NULL," +
                    "  `pass` VARCHAR(45) NULL," +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  PRIMARY KEY (`id`)," +
                    "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);";

    public UserRepository() {
        super();
        if (!checkIfTableExists("users")) {
            this.createTable();

        }

    }

    @Override
    public void createTable() {
        simpleSQLUpdate(createUserTable);
    }

    @Override
    public void faker() {
        err("not working");
    }

    @Override
    public boolean create(User user) {
        boolean response = false;
        try {

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO `shop`.`users` (" +
                            "`f_name`, `l_name`, `phone`, `pass`" +
                            ") VALUES (?, ?, ?, ?);");

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getPass());

            int result = statement.executeUpdate();

            if (result == 0)
                throw new Exception();
            else {

                response = true;
            }


        } catch (Exception e) {
            print("failed in creating user");
        }
        return response;

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User read(User user) {

        try {
            PreparedStatement statement = connection.prepareStatement(" SELECT * FROM shop.users " +
                    "WHERE phone=? AND pass=?;");
            statement.setString(1, user.getPhoneNumber());
            statement.setString(2, user.getPass());


            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new User(result.getInt("id"),
                        result.getString("phone"),
                        result.getString("f_name"),
                        result.getString("l_name"));


            }

        } catch (Exception e) {
            e.printStackTrace();
            err();
        }
        return null;

    }

    @Override
    public ArrayList<User> readAll() {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
