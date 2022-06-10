package com.example.testspringboot2.Controller;

import com.example.testspringboot2.Interface.JokeDataInterface;
import com.example.testspringboot2.Interface.JokeGetterInterface;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
public class ShellCommands {
    public final JokeGetterInterface jokeGetterInterface;
    private final JokeDataInterface jokeDataInterface;


    public ShellCommands(JokeGetterInterface jokeGetterInterface, JokeDataInterface jokeDataInterface) {
        this.jokeGetterInterface = jokeGetterInterface;
        this.jokeDataInterface = jokeDataInterface;
    }

    private String lastJoke;
    @ShellMethod("Tell a joke")
    public String joke() {
        lastJoke = jokeGetterInterface.getJoke().value.joke;
        return lastJoke;
    }

    @ShellMethod("Save a joke")
    public String save() {
       if (lastJoke != null) {
           jokeDataInterface.save(lastJoke);
           return "Saved";
       } else {
           return "upload joke first";
       }
    }

    @ShellMethod("Show all jokes")
    public String show() {
        return jokeDataInterface.getAll().stream().collect
                (Collectors.joining(System.lineSeparator()));
    }
}
