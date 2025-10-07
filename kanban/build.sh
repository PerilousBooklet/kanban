#!/usr/bin/bash
mvn clean
mvn compile
# mvn test
mvn package
mvn exec:java -Dexec.mainClass="com.perilousbooklet.kanban.App"
