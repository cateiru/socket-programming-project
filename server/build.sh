#!/bin/bash

export DIRPATH=$(cd $(dirname $0); pwd)

JAVAFILE=""

for i in `find . -name "*.java" -type f`; do
  JAVAFILE+="${i} "
done

javac -cp .:$DIRPATH/libs/igo-0.4.5.jar ${JAVAFILE}
