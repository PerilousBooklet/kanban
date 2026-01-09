#!/usr/bin/bash
export JAVA_HOME="/usr/lib/jvm/java-8-openjdk"
mvn clean
mvn compile
mvn package
mvn exec:java -Dexec.mainClass="com.perilousbooklet.kanban.App"
