Название проекта
Краткое описание проекта здесь.

Описание
Подробное описание проекта, включая его цели, особенности, функциональность и технологии, используемые в проекте.

Требования
Перечислите здесь все требования к окружению, необходимые для запуска проекта, включая:

Java Development Kit (JDK)
Gradle
База данных (например, PostgreSQL)
Установка
Клонируйте репозиторий на свой локальный компьютер:

bash
Copy code
git clone https://github.com/username/repository.git
Перейдите в директорию проекта:

bash
Copy code
cd project-directory
Установите все зависимости с помощью Gradle:

bash
Copy code
gradle build
Настройка
Настройте базу данных в файле application.properties:

properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/database
spring.datasource.username=username
spring.datasource.password=password
Другие настройки приложения:

properties
Copy code
# Настройки Spring Boot
server.port=8080
Запуск
Запустите приложение с помощью Gradle:

bash
Copy code
gradle bootRun
После успешного запуска, приложение будет доступно по адресу http://localhost:8080.

Использование
Опишите здесь, как использовать ваше приложение. Включите примеры HTTP-запросов для тестирования API.

Примеры HTTP-запросов
LimitController
1. Создание лимита
Эндпоинт: POST /limits
Действие: Создает новый лимит и сохраняет его в базе данных.
Тело запроса (JSON):
json
Copy code
{
  "amount": 1000.0,
  "currency": "USD",
  "category": "goods"
}
Пример ответа:
json
Copy code
{
  "id": 1,
  "amount": 1000.0,
  "currency": "USD",
  "category": "goods"
}
2. Получение всех лимитов
Эндпоинт: GET /limits
Действие: Возвращает список всех существующих лимитов.
Пример ответа:
json
Copy code
[
  {
    "id": 1,
    "amount": 1000.0,
    "currency": "USD",
    "category": "goods"
  },
  {
    "id": 2,
    "amount": 2000.0,
    "currency": "EUR",
    "category": "services"
  }
]
3. Получение лимита по ID
Эндпоинт: GET /limits/{id}
Действие: Возвращает лимит по указанному ID.
Пример ответа:
json
Copy code
{
  "id": 1,
  "amount": 1000.0,
  "currency": "USD",
  "category": "goods"
}
4. Получение лимитов по категории
Эндпоинт: GET /limits/category/{category}
Действие: Возвращает список лимитов по указанной категории.
Пример ответа:
json
Copy code
[
  {
    "id": 1,
    "amount": 1000.0,
    "currency": "USD",
    "category": "goods"
  },
  {
    "id": 3,
    "amount": 1500.0,
    "currency": "USD",
    "category": "goods"
  }
]
5. Удаление лимита по ID
Эндпоинт: DELETE /limits/{id}
Действие: Удаляет лимит по указанному ID.
TransactionController
1. Создание транзакции
Эндпоинт: POST /transactions
Действие: Создает новую транзакцию и сохраняет её в базе данных.
Тело запроса (JSON):
json
Copy code
{
  "amount": 500.0,
  "currency": "USD",
  "date": "2024-04-25",
  "categoryId": 1
}
Пример ответа:
json
Copy code
{
  "id": 1,
  "amount": 500.0,
  "currency": "USD",
  "date": "2024-04-25",
  "categoryId": 1
}
2. Получение всех транзакций
Эндпоинт: GET /transactions
Действие: Возвращает список всех существующих транзакций.
Пример ответа:
json
Copy code
[
  {
    "id": 1,
    "amount": 500.0,
    "currency": "USD",
    "date": "2024-04-25",
    "categoryId": 1
  },
  {
    "id": 2,
    "amount": 750.0,
    "currency": "EUR",
    "date": "2024-04-26",
    "categoryId": 2
  }
]
3. Получение транзакции по ID
Эндпоинт: GET /transactions/{id}
Действие: Возвращает транзакцию по указанному ID.
Пример ответа:
json
Copy code
{
  "id": 1,
  "amount": 500.0,
  "currency": "USD",
  "date": "2024-04-25",
  "categoryId": 1
}
4. Получение транзакций, превышающих лимит
Эндпоинт: GET /transactions/limit-exceeded
Действие: Возвращает список транзакций, превышающих лимит.
Пример ответа:
json
Copy code
[
  {
    "id": 2,
    "amount": 750.0,
    "currency": "EUR",
    "date": "2024-04-26",
    "categoryId": 2
  }
]