#!/bin/bash
readonly BIN_DIR="/home/questofjoy/Desktop/git-java_practice/java_practice/projectDumpItAll/bin"
mkdir -p "$BIN_DIR"
find . -name "*.java" >sources.txt
javac -d "$BIN_DIR" @sources.txt
java -cp "$BIN_DIR" myapp.Main
rm sources.txt
