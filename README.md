TODO Application. 
This is Task list web service application. 
-Technology:
- Spring Boot 2.6.2
- Java 17
- jUnit 5

Installation Guide:  
Download this source repo from `dev` branch in your directory.
-Then
`cd project_folder`

#Run on your local environment
change mysql or mariadb configuration on `application-local.yml` file. 
```
    url: jdbc:mysql://{HOST}:{DB_PORT}/swahid_task?useUnicode=true&createDatabaseIfNotExist=true
    username: your_db_username
    password: your_db_password
```
Build with `maven` command
```
mvn clean install
```
Run Application
```
java -jar targer/swahid-task-todo.jar
```
#Docker Image Run

To create a JAR file, execute the below command.
```
mvn clean package
```
Now to build the Dockerfile, the below command needs to be run:
```
docker-compose build
```
Run Docker Image. 
```
docker-compose up -d
```

#Now Browse The application user following api:  

-To Create Task:
```
URL: localhost:4400/api/v1/task
Method: POST
RequestBidy:
{
    "title": "task title",
    "description": "task description",
    "startDate": "task start time", //format: YYYY-MM-DD HH:mm:ss
    "endDate": "task end time", //format: YYYY-MM-DD HH:mm:ss
    "priority": "Priority", //ex: low, medium, high 
    "status": "status" //ex: backlog, pending, inprogress, done, complete, close;
}
```
-To Edit Task:
```
URL: localhost:4400/api/v1/task
Method: POST
RequestBidy:
{
    "taskId": task_id,
    "title": "task title",
    "description": "task description",
    "startDate": "task start time", //format: YYYY-MM-DD HH:mm:ss
    "endDate": "task end time", //format: YYYY-MM-DD HH:mm:ss
    "priority": "Priority", //ex: low, medium, high 
    "status": "status" //ex: backlog, pending, inprogress, done, complete, close;
}
```
-To Get All Task:
```
URL: localhost:4400/api/v1/task
Method: GET
```
-To Get Task by ID:
```
URL: localhost:4400/api/v1/task?taskId=1
Method: GET
```
-To view done Task:
```
URL: localhost:4400/api/v1/task?status=done
Method: GET
```
-To View By Priority
```
URL: localhost:4400/api/v1/task?priority=high
Method: GET
```

-To Delete Task
```
URL: localhost:4400/api/v1/task?taskId=1
Method: DELETE
```
