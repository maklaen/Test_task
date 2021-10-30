# Инструкция

1. Клонировать проект в IntelliJIdea
2. Настроить подключение к базе данных
   1. Создать пользователя username = root, password = root;
   2. Или настроть файл application.properties под себя
3. Запустить приложение и отправлять нужные запросы

# API

http://localhost:8080

+ POST /author/ - добавление нового автора

Request

```JSON
{
  "firstName": "Лев",
  "lastName": "Толстой",
  "middleName": "Николаевич",
  "bio": "Родился в России",
  "date": "22-01-1999"
}
```

+ GET /author/ - список всех авторов

Response

```JSON
{
  "firstName": "Лев",
  "lastName": "Толстой",
  "middleName": "Николаевич",
  "bio": "Родился в России",
  "date": "22-01-1999"
}
```

+ PUT /author/{id} - редактирование данных автора

Request

```JSON
{
  "firstName": "Лев",
  "lastName": "Толстой",
  "middleName": "Николаевич",
  "bio": "Родился в Российской имерии",
  "date": "22-01-1999"
}
```

Response

```JSON
{
  "firstName": "Лев",
  "lastName": "Толстой",
  "middleName": "Николаевич",
  "bio": "Родился в Российской имерии",
  "date": "22-01-1999"
}
```

+ POST /book/ - добавление книги в каталог

Request

```JSON
{
  "title": "Война и мир",
  "available": true,
  "author": {
    "firstName": "лев",
    "lastName": "ТолстоЙ"
  }
}
```

Response

```JSON
{
  "id": null,
   "title": "Война и мир",
   "serialNumber": 1,
   "available": true,
   "author": {
      "firstName": "Лев",
      "lastName": "Толстой"
   }
}
```

+ GET /book/ - список всех книг

Response

```JSON
{
   "id": 1,
   "title": "Война и мир",
   "serialNumber": 1,
   "available": true,
   "author": {
      "firstName": "Лев",
      "lastName": "Толстой"
   }
}
```

+ PUT /book/{id} - Обновление данных о книге

Request

```JSON
{
   "title": "Война и мир2",
   "available": true,
   "author": {
      "firstName": "Лев",
      "lastName": "Толстой"
   }
}
```

Response

```JSON
{
   "id": 1,
   "title": "Война и мир2",
   "serialNumber": 1,
   "available": true,
   "author": {
      "firstName": "Лев",
      "lastName": "Толстой"
   }
}
```

+ DELETE /book/{id} - удаление книги с полки

Request

```JSON
{
   "id": 1,
   "title": "Война и мир2",
   "serialNumber": 0,
   "available": false,
   "author": {
      "firstName": "Лев",
      "lastName": "Толстой"
   }
}
```

+ GET /book/author/{id} - список всех книг автора
+ GET /book/available - сортировка по наличию книги на полке
+ GET /book/title - сортировка книг по названию
+ GET /book/serial - сортировка книг по порядковому номеру

