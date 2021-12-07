From openjdk:17
EXPOSE 4400

WORKDIR /app
copy ./target/swahid-task-todo.jar swahid-task-todo.jar
ENTRYPOINT ["java","-jar","swahid-task-todo.jar", "-Dspring.profiles.active=docker"]
