######################################
# Author: 	Joost Vandorp, S. Smith	 #
# Revised: 	Thursday, Feb 24, 2017	 #
# Description:	"MAKEFILE"		 #
######################################

# Assumes JUnit is installed
# Assumes CLASSPATH has been set for Junit

JFLAGS = -g
JCLASS = -cp ./src:.:$(CLASSPATH):/mnt/c/Users/'Yousam Asham'/Desktop/2AA4/junit-4.5.jar
#JCLASS = -cp ./src:.:$(CLASSPATH):/usr/share/java/junit4-4.5.jar # on mills
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(JCLASS) $*.java

CLASSES = \
	src/A4Example.java \
	src/AllTests.java \
	src/ColourT.java \
    src/DotsBoardT.java \
    src/GameBoard.java \
    src/PointT.java \
    src/Random.java \
    src/TestPointT.java \
	src/TestGameBoardT.java \

MAIN = AllTests

default: classes

classes: $(CLASSES:.java=.class)

doc:
	doxygen doxConfig
	cd latex && $(MAKE)

test: src/$(MAIN).class
	$(JVM) $(JCLASS) org.junit.runner.JUnitCore $(MAIN)

expt: src/A4Example.java
	$(JC) $(JCLASS) $(JFLAGS) src/A4Example.java
	$(JVM) $(JCLASS) A4Example

clean:
	rm -rf html
	rm -rf latex
	cd src
	rm **/*.class
