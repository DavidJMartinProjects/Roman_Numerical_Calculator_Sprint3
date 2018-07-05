COPY ./target/com.calculator-0.0.1-SNAPSHOT.jar com.calculator-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENV JAVA_OPTS ""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /com.calculator-0.0.1-SNAPSHOT.jar"]