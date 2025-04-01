package ru.itis.dis301.lab2_03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.itis.dis301.lab2_03.component.Abonent;
import ru.itis.dis301.lab2_03.component.AbonentService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        for (String name : context.getBeanNamesForAnnotation(Component.class)) {
            System.out.println(name);
        }

        Abonent abonent = (Abonent) context.getBean("abonent");

        System.out.println(abonent);

        AbonentService service = (AbonentService) context.getBean(AbonentService.class);

        service.print();
    }
}
