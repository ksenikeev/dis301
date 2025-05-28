package ru.itis.dis301.lab2_11.stomp.model;

/*
{
    "content": "Hello, Trump!"
}
 */
public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
