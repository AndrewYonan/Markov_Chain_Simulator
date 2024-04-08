JFLAGS = -g
JAVA_SOURCES = $(wildcard *.java)

JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

default: classes

classes: $(JAVA_SOURCES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java Main