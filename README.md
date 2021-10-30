# Инструкция

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

+ PUT /book/
+ DELETE /book/
+ GET /book/author/{id}
+ GET /book/available
+ GET /book/title
+ GET /book/serial

