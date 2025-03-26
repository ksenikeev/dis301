package ru.itis.dis301.lab2_02.model;

import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class View {

    private Model model;
    private File fileView;

    public View(Model model, File fileView) {
        this.model = model;
        this.fileView = fileView;
    }

    public void render(HttpServletResponse response) throws IOException {
        String content = Files.readString(fileView.toPath());

        for (String param : model.getParams().keySet()) {
            content = content.replace("${" + param + "}", (String) model.getParams().get(param));
        }

        response.setContentType("text/html");
        response.getWriter().write(content);
    }
}
