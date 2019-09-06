# Makefile for NumberRanger

all:
	javac -d . NumberRangeSummarizer.java
	javac -d . NumberRanger.java
	
run:
	java numberrangesummarizer.NumberRanger
	
doc:
	javadoc -d doc *.java

test_classes: all NumberRangerTest.class

test: test_classes