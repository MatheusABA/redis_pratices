package com.cache.redis.services;

import com.cache.redis.records.ProductRecord;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    Map<Long, ProductRecord> products = new HashMap<>() {
        {
            put(1L, new ProductRecord(1L, "Milk", 12.99));
            put(2L, new ProductRecord(2L, "Cheese", 12.99));
            put(3L, new ProductRecord(3L, "Sugar", 12.99));
            put(4L, new ProductRecord(4L, "Rice", 12.99));
            put(5L, new ProductRecord(5L, "Meat", 12.99));
        }
    };

    @Cacheable("products")
    public ProductRecord getById(Long id) {
        System.out.println("Searching products...");
        simulatingLatency();
        return products.get(id);
    }

    public void simulatingLatency() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}