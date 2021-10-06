package com.shopping.repositories;


import com.shopping.models.Model;
import com.shopping.models.User;
import com.shopping.services.inputOutPut.Print;


import java.sql.*;


public abstract class BaseRepository<T extends Model> implements Crud<T>, Print {


    public Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/shop";
    private static final String user = "root";
    private static final String password = "mohammad";

    BaseRepository() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            print(e.toString());
            e.printStackTrace();
            err();
        }

    }

    public void simpleSQLUpdate(String SQL) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);

        } catch (Exception e) {
            e.printStackTrace();
            print("failed in updating");
            err();
        }
    }

    public boolean checkIfTableExists(String tableName) {
        boolean exits = false;
        try {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet resultSet = meta.getTables(null, null, tableName.toUpperCase(), new String[]{"TABLE"});
            exits = resultSet.next();

        } catch (Exception e) {
            print(e.toString());
            e.printStackTrace();
            err();
        }
        return exits;
    }


    public void readDbSchemas(User model) {

        try {
            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("show schemas");

            while (results.next()) {
                print(results.getString(1));
            }


        } catch (Exception e) {
            line();
            print("failed in reading schemas");
            err();
        }
    }

}
