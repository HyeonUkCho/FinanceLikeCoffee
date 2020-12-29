#!/bin/bash

REPOSITORY=/home/ec2-user/apps
PROJECT_NAME=FinanceLikeCoffee

cd $REPOSITORY/$PROJECT_NAME/

echo "> Git Pull"

git pull

echo "> Build Start"

./gradlew build

echo "> move to apps"

cd $REPOSITORY

echo "> build file copy"

cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

echo "> current pid check"

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.jar)

echo "> current pid check"

if [ -z "$CURRENT_PID" ]; then
  echo "> running process is not exist!"
else
  echo "> kill - 15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 3
fi

echo "> new app deploy"

JAR_NAME=$(ls -tr $REPOSITORY/ | grep  jar | tail -n 1)

echo "> JAR_NAME: $JAR_NAME"

nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 &