# Spring Boot "Microservice" Example Project

## How to Run 


java -jar -Dspring.profiles.active=test target/spring-boot-rest-example-0.5.0.war
or
mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"


Here are some endpoints you can call:

### Get information about system health, configurations, etc.

```
http://localhost:8091/env
http://localhost:8091/health
http://localhost:8091/info
http://localhost:8091/metrics
```

### Create a hotel resource

```
POST /example/v1/hotels
Accept: application/json
Content-Type: application/json

{
"name" : "Beds R Us",
"description" : "Very basic, small rooms but clean",
"city" : "Santa Ana",
"rating" : 2
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8090/example/v1/hotels/1
```

### Retrieve a paginated list of hotels

```
http://localhost:8090/example/v1/hotels?page=0&size=10

```

### Update a hotel resource

```
PUT /example/v1/hotels/1
Accept: application/json
Content-Type: application/json

{
"name" : "Beds R Us",
"description" : "Very basic, small rooms but clean",
"city" : "Santa Ana",
"rating" : 3
}

RESPONSE: HTTP 204 (No Content)
```

### Then run is using the 'mysql' profile:

```
        java -jar -Dspring.profiles.active=mysql target/spring-boot-rest-example-0.5.0.war
or
        mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=mysql"
```

# Attaching to the app remotely from your IDE

Run the service with these command line options:

```
mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
or
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -Dspring.profiles.active=test -Ddebug -jar target/spring-boot-rest-example-0.5.0.war
```
and then you can connect to it remotely using your IDE. For example, from IntelliJ You have to add remote debug configuration: Edit configuration -> Remote.

# Questions and Comments: khoubyari@gmail.com




### mockMvc
https://www.cnblogs.com/jiliunyongjin/p/7496104.html
http://b.edu.51cto.com/gddx/course/video?lessonId=264846

传递实体？？




### curl 
get  
curl https://proxy.mimvp.com/login?user=admin&passwd=12345678

post
curl -d "key1=value1&key2=value2&key3=value3" protocol://ip:port/path
curl -H "Content-Type:application/json" -X POST -d '{"name": "B", "poolId":"bxxStrategy", "orderId": "O_002"}' http://localhost:8080/choose

如果想看到详细的请求信息，我们可以加上 -v 参数
curl localhost:9999/api/daizhige/article -v


test requests from client
curl -H "Content-Type:application/json" -X POST -d '{"name": "A", "poolId":"axxStrategy", "orderId": "O_001"}' http://localhost:8080/choose
curl -H "Content-Type:application/json" -X POST -d '{"name": "B", "poolId":"bxxStrategy", "orderId": "O_002"}' http://localhost:8080/choose


更多见ubuntu/笔记/附录


