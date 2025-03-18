package ru.itis.dis301.lab2_02.context;

import java.lang.reflect.Method;

public class Context {

    // Конфигурирование и запуск tomcat

   // Поиск компонентов
   // Поиск членов с аннотацией @Inject
   // Внедрение зависимостей
   // Поиск контроллеров - класс, содержащий методы, которые обрабатывают разные http запросы
   //  формирование структуры


   class MVSStructure {
       public String path;
       public String httpMethod;
       public Object controller;
       public Method method;
   }
}
