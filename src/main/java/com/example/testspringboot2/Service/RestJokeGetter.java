package com.example.testspringboot2.Service;

import com.example.testspringboot2.DTO.JokeImportDTO;
import com.example.testspringboot2.Interface.JokeGetterInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestJokeGetter implements JokeGetterInterface {

    private final RestTemplate restTemplate;

    private static String url = "http://api.icndb.com/jokes/random";

    public RestJokeGetter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public JokeImportDTO getJoke() {
        ResponseEntity<JokeImportDTO> result = restTemplate.getForEntity(url, JokeImportDTO.class);
        return result.getBody();
    }
}
