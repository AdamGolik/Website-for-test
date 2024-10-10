package com.example.demo;

import org.springframework.http.ResponseEntity;

public interface Commend <E,T> {
    ResponseEntity<T> execute (E entity);
}
