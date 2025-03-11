package ru.itis.dis301.lab2_01;

import ru.itis.dis301.lab2_01.service.PathScan;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, Object> components;

    public Context() {
        components = new HashMap<>();
        scanComponent();
    }

    /*
            Сканировать наш проект, найти компоненты, создать их экземпляры,
            добавить в структуру components
         */
    private void scanComponent() {

        // 1-й проход по структуре проекта находим все компоненты

        PathScan.find("ru.itis.dis301.lab2_01");

        // 2-й проход инициализурем члены компонент, аннотированных как Inject
    }

    public Object getObjectByName(String className) {
        return null;
    }

}
