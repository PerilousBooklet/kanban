#!/usr/bin/bash

GROUP="com.perilousbooklet"
PROJECT="kanban"


# ?
mvn -B archetype:generate \
    -DgroupId=$GROUP.$PROJECT \
    -DartifactId=$PROJECT \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.4
# FIX
sed -i 's/<maven.compiler.source>1.7/<maven.compiler.source>1.8/g' ./$PROJECT/pom.xml
sed -i 's/<maven.compiler.target>1.7/<maven.compiler.target>1.8/g' ./$PROJECT/pom.xml


# remove base testing code
rm -vrf ./$PROJECT/src/test/


# build.sh
cat << EOT > ./$PROJECT/build.sh
#!/usr/bin/bash
mvn clean
mvn compile
mvn test
mvn package
mvn exec:java -Dexec.mainClass="$GROUP.$PROJECT.App"
EOT
chmod +x ./$PROJECT/build.sh


# run.sh
cat << EOT > ./run.sh
#!/usr/bin/bash
cd ./$PROJECT || exit
./build.sh
EOT
chmod +x ./run.sh
