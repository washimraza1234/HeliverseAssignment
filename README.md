#Installation and Run
#changing the server port
server.port=8088

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root


#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

#No handler found
spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false

#swagger-ui
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
