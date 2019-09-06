# Makefile for NumberRanger


all:
	javac -d . src/NumberRangeSummarizer.java
	javac -d . src/NumberRanger.java
	
	
run:
	java numberrangesummarizer.NumberRanger
	
doc:
	javadoc -d doc src/*.java

test_classes:
	javac -cp ./lib/Junit/junit-4.12.jar:. test/NumberRangerTest.java
	mv test/NumberRangerTest.class ./numberrangesummarizer

test: test_classes
	java -cp ./lib/Junit/junit-4.12.jar:./lib/Junit/hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore numberrangesummarizer.NumberRangerTest
	
clean:
	@rm -f  numberrangesummarizer/*.class
	@rm -Rf doc