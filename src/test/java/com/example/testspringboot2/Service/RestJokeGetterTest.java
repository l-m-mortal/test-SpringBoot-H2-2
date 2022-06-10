package com.example.testspringboot2.Service;

import com.example.testspringboot2.Interface.JokeGetterInterface;
import com.example.testspringboot2.TestSpringBoot2Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestSpringBoot2Application.class,
        properties = {
                InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
                ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
            }
        )
public class RestJokeGetterTest {

    @Autowired
    JokeGetterInterface jokeGetterInterface;

    @Test
    public void getJoke() {
        String result = jokeGetterInterface.getJoke();
        System.out.println(result);
    }

}