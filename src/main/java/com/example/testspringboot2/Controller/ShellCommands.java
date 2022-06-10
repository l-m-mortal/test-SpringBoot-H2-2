package com.example.testspringboot2.Controller;

import com.example.testspringboot2.Interface.JokeGetterInterface;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellCommands {
    public final JokeGetterInterface jokeGetterInterface;

    public ShellCommands(JokeGetterInterface jokeGetterInterface) {
        this.jokeGetterInterface = jokeGetterInterface;
    }

    @ShellMethod("Tell a joke")
    public String joke() {
        return jokeGetterInterface.getJoke().value.joke;
    }
}
