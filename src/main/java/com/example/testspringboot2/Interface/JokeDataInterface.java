package com.example.testspringboot2.Interface;

import java.util.List;

public interface JokeDataInterface {

    void save(String joke);
    List<String> getAll();
}
