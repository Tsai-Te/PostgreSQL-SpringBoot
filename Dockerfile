FROM openjdk:17
EXPOSE 8282
ADD target/postgresql-springboot-devops-integration.jar postgresql-springboot-devops-integration.jar
ENTRYPOINT ["java","-jar","/postgresql-springboot-devops-integration.jar"]