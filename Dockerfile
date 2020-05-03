FROM maven:3.6.1-amazoncorretto-8 as PREBUILD

#ADD m2.tar.gz /root

COPY . /usr/src/app
RUN mvn -Dmaven.repo.local=/root/m2 --batch-mode -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
EXPOSE 8080 5005
COPY --from=PREBUILD /usr/src/app/target/*.jar /opt/app/app.jar
WORKDIR /opt/app

ENTRYPOINT ["java","-jar","app.jar"]