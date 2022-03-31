spring-course

Each branch contains a topic(s).

## How to run this?
```bash
$ git clone https://github.com/EvgenyLeshevich/spring-course.git
$ cd spring-course
$ mvn clean package -Dmaven.test.skip=true

//dockerize

In branches with DB:
$ docker pull postgres
$ docker run --name postgres_db_course –p 5432:5432 -e POSTGRES_USER=evg -e POSTGRES_PASSWORD=evg –e POSTGRES_DB=db_course -d postgres

In branches from the MVC:
$ docker build -t spring-mvc-course-app:1 .
$ docker run --name spring-mvc-course -p 8080:8080 -d spring-mvc-course-app:1

  access http://localhost:8080
```
