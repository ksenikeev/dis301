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
        <label>Название</label><label>${film.name!}</label>
        <label>Дата премьеры</label><label>${film.productionDate!}</label>


        <form action="/films/addto" method="post">
            <div>
                <label>Название</label><input name="name"/>
            </div>
            <select name="genre">
                <#list genres as genre>
                    <option value="${genre.id}">${genre.name}</option>
                </#list>
            </select>
            <input type="submit" value="OK"/>
        </form>
    </div>
</body>
</html>