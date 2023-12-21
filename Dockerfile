FROM openjdk:21
WORKDIR /app
COPY target/boot-psql.jar  /app/boot-psql.jar
EXPOSE 8282
CMD ["java" ,"-jar", "boot-psql.jar"]