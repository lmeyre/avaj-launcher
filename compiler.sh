#!/bin/sh
javac -d . com/*.java com/Aircraft/*.java
java -cp . com/Simulator $@
