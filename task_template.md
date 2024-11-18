# Разработка шаблонизатора

1. Формируете шаблон, т.е. html страничку с параметрами (${param_name})

2. Создаете сервлет, обрабатывающий определенный ресурс, который возвращает страничку

3. Загружает шаблон из файла

4. Ищете переменные по шаблону ${param_name} и заменяеете их на какие-то значения

5. Выводите содержимое измененного файла в ответе клиенту

```
request.getRequestDispatcher("/template/success.html").forward(request, response);
```

```
@WebServlet("/template")
public class TemplateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String html = ""; // load file template to string
        // replace ${param_name} to values

        URL is = this.getClass().getClassLoader().getResource("/templates/index_template.html");
        System.out.println(is);
        html = Files.readString(Paths.get(is.getPath()));

        System.out.println(html);
        // send string to client
        Writer writer = response.getWriter();
        writer.write(html);
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) {

    }
}

```
