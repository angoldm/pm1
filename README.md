# pm1
##Общие сведения
Разработать приложение для управления проектом.
Заказчик обращается в it-компанию с целью реализовать его идею в виде
конечного продукта. Проект должен содержать в себе одну доску задач. Доска
может содержать в себе множество задач. Задача может находится в одном из
трех статусов (BACKLOG, IN_PROGRESS, DONE). У задачи должны быть
указаны автор, исполнитель, версия релиза. Релиз имеет время начала
выполнения и время завершения работ.
Задача может быть в статусе IN_PROGRESS, только когда стартовал проект.
Проект не должен быть закрыт, если хотя бы одна задача на доске не в статусе
DONE.
##Технологии
* Java 11
* Git
* Maven
* PostgreSQL
* Liquibase
* Spring Boot, Spring Web, Spring JPA, Spring MVC, Spring Security
* Swagger
* Junit, Mockito
* AOP
Проект сформирован с помощью Spring Initializr и разработан в среде IntelliJ IDEA.
Используется встроенный в IntelliJ IDEA инструмент для управления и сборки проектов Maven и его обертка Maven Wrapper (mvnw), что позволяет клонировать проект и собрать его без установки Maven.
##Описание процесса установки и сборки в среде Windows
* Скачать проект - Выполнить: 
  * git clone https://github.com/angoldm/pm1.git
  * git checkout feature/TASK-2_RestControllers
  * или скачать архив приложения по ссылке: https://github.com/angoldm/pm1/archive/refs/heads/feature/TASK-2_RestControllers.zip
* Установить OpenJDK Runtime Environment Corretto-11.0.14.10.1 по ссылке: https://corretto.aws/downloads/resources/11.0.14.10.1/amazon-corretto-11.0.14.10.1-windows-x64.msi
* Установить PostgreSQL 14.2 : https://sbp.enterprisedb.com/getfile.jsp?fileid=1257974
  * установить пароль подключения к серверу, указанный в файле src\main\resources\application.properties
  * В pgAmin создать БД с названием "pm"
* В командной строке cmd (текущий каталог pm1) запустить команду: mvnw package
* Убедиться, что создался файл target\pm1-0.0.1-SNAPSHOT.jar
## Запуск приложения
* В командной строке cmd (текущий каталог pm1) запустить команду: java -jar target\pm1-0.0.1-SNAPSHOT.jar
* В браузере перейти по ссылке: http://localhost:8080/swagger-ui/index.html
##Работа с приложением
С помощью команд в приложении осуществляется управление проектом:
* POST - создание записи сущности
* PUT - редактирование записи
* GET - вывод списка всех записей сущности
* DELETE - удаление запись сущности
Список сущностей:
* Проект
* Статус проекта
* Доска задач
* Задача
* Релиз задачи
* Статус задачи
* Пользователь
