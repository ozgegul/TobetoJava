package org.example.dataAccess;

import org.example.entities.Product;

public class JdbcProductDao implements ProductDao{
    public void add(Product product){
        // Sadece DB erişim kodları buraya yazılır! SQL
        System.out.println("JDBC ile veritabanına eklendi.");
    }
}
