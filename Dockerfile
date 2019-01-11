
FROM openjdk:8
ADD target/app.jar app.jar
#ADD wait-for-it.sh .
EXPOSE 8080
#CMD ["./wait-for-it.sh", "db:3306", "--", "java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-jar", "app.jar"]
