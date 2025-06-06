#!/bin/bash

javac *.java
if [[ $? == 0 ]]; then
  java Main.java
  rm *.class
else
  rm *.class
fi
