package com.estudos.runnerz;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String getWelcomeMessage(){
        return  "Olá mundo";
    };
}
