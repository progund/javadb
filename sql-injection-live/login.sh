#!/bin/bash

USERNAME="$1"
PASSWORD="$2"

SQL="SELECT real_name FROM user NATURAL JOIN login WHERE username='$USERNAME' AND password = '$PASSWORD';"

#echo $SQL
#exit 0

REAL_NAME=$(sqlite3 login.db "$SQL")

WELCOME_MSG="Wrong username or password"
if [[ ! -z "$REAL_NAME" ]]
then
    WELCOME_MSG="Welcome $REAL_NAME"
fi

echo "$WELCOME_MSG"
