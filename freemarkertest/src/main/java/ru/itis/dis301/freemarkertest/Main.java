package ru.itis.dis301.freemarkertest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, TemplateException {
        Main main = new Main();
        Configuration cfg = main.configure();
        main.render(cfg, main.getModel(), "index.ftlh");
    }

    private Configuration configure() throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        String templatesPath = Main.class.getClassLoader().getResource("templates").getPath();
        System.out.println(templatesPath);
        cfg.setDirectoryForTemplateLoading(new File(templatesPath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        return cfg;
    }

    private Map<String, ?> getModel() {
        Map<String, Object> model = new HashMap<>();
        model.put("message1", "world!");
        model.put("message2", "group!");

        Person person = new Person();
        person.fio = "Иванов Иван Иванович";
        person.gender = "Мужской";

        model.put("person", person);
        return model;
    }

    private void render(Configuration cfg, Map<String,?> model, String template) throws IOException, TemplateException {
        Template temp = cfg.getTemplate(template);
        Writer writer = new FileWriter("index.html");
        System.out.println(((Person)model.get("person")).fio);

        temp.process(model, writer);
    }


    public class Person {
        public String fio;
        public String gender;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
