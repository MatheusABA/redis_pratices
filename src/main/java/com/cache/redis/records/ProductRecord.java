package com.cache.redis.records;

import java.io.Serializable;

public record ProductRecord(Long id, String name, Double price) implements Serializable {

}
