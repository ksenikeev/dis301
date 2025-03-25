package ru.itis.dis301.lab2_03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.itis.dis301.lab2_03.component.Abonent;
import ru.itis.dis301.lab2_03.component.AbonentImpl;
import ru.itis.dis301.lab2_03.component.Phone;
import ru.itis.dis301.lab2_03.component.PhoneImpl;

@Configuration
@ComponentScan("ru.itis.dis301.lab2_03.component")
public class Config {

    @Bean
    public Phone phone() {
        return new PhoneImpl("9090232345", "+7");
    }

    @Bean("abonent")
    public Abonent getAbonent() {
        return new AbonentImpl("Абонент", phone());
    }
}
