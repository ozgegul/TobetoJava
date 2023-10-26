package org.example.business;

import org.example.core.logging.Logger;
import org.example.dataAccess.ProductDao;
import org.example.entities.Product;

public class ProductManager {
    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) throws Exception{
        // business rules
        if(product.getUnitPrice()<10){
            throw new Exception("Ürün fiyatı 10'dan küçük olamaz!");
        }
        productDao.add(product);

        for(Logger logger : loggers){ // [db, mail]
            logger.log(product.getName());
        }
    }
}
