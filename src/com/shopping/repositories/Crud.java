package com.shopping.repositories;

import com.shopping.models.Model;
import com.shopping.models.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Crud <T extends Model>{


    boolean create(T model) throws SQLException, ClassNotFoundException;
    void update(T model);
    T read(T model);
    ArrayList<T> readAll();
    void delete(T model);
    void createTable();
    void faker();

}
