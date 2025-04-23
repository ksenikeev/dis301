<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>

    <h2>Главная страница</h2>

    <div>
        <img src="/films/img" alt=""/>
    </div>
    <div>
        <img src="/films/img2" alt=""/>
    </div>

    <div>
        <label>Название</label><label>${film.name!}</label>
        <label>Дата премьеры</label><label>${film.productionDate!}</label>


        <form action="/films/addto" method="post">
            <div>
                <label>Название</label><input id="film_name" name="name"/>
            </div>
            <select id="genre_id" name="genre">
                <#list genres as genre>
                    <option value="${genre.id}">${genre.name}</option>
                </#list>
            </select>
            <input type="submit" value="OK"/>
        </form>

        <div>
            <button type="button" onclick="save_film()">Отправка как AJAX</button>
        </div>
    </div>

<script>
    function save_film() {
        let film_name = document.getElementById("film_name").value;
        let genre_id = document.getElementById("genre_id").value;

        fetch('/films/addjson', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ name: film_name, genre: genre_id })
        })
          .then(response => {
            if (!response.ok) {
              throw new Error('Сетевая ошибка');
            }

            return response.json();
          })
          .then(data => console.log(data))
          .catch(error => console.error('Ошибка:', error));

    }
</script>
</body>
</html>