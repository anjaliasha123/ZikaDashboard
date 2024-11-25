FROM openjdk:17
EXPOSE 9090
ADD target/zika-dashoard.jar zika-dashoard.jar
ENTRYPOINT ["java", "-jar", "zika-dashoard.jar"]