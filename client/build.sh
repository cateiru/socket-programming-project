#!/bin/bash

JAVAFILE=""

for i in `find . -name "*.java" -type f`; do
  JAVAFILE+="${i} "
done

javac ${JAVAFILE}
