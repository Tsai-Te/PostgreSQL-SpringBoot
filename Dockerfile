FROM openjdk:17
EXPOSE 8282
ADD target/postgresql-springboot.jar postgresql-springboot.jar
ENTRYPOINT ["java","-jar","/postgresql-springboot.jar"]