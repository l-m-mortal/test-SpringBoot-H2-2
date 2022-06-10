package com.example.testspringboot2.Service;

import com.example.testspringboot2.Interface.JokeDataInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeDataService implements JokeDataInterface {

    private final JdbcTemplate jdbcTemplate;

    public JokeDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String joke) {
        jdbcTemplate.update("insert into jokes (joke) values  (?)", joke);
    }

    @Override
    public List<String> getAll() {
        return jdbcTemplate.query("select joke from jokes",
                (rs, rowNum) -> rs.getString("joke"));
    }

}
