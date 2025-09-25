Campus Course & Records Manager (CCRM)
Project Overview & How to Run
This is a Java SE console-based application for managing student and course records.

JDK Version: 17  
Commands: javac edu/ccrm/cli/CCRM.java then java edu.ccrm.cli.CCRM

Evolution of Java

1995: Java 1.0 released by Sun Microsystems
1998: Java 1.2 with J2SE introduction
2004: Java 5 with generics and annotations
2014: Java 8 with lambdas and Stream API
2021: Java 17 LTS release

Java ME vs SE vs EE

Java ME: Micro Edition for embedded devices (small footprint)
Java SE: Standard Edition for general-purpose applications
Java EE: Enterprise Edition for server-side applications

JDK/JRE/JVM Explanation

JDK: Java Development Kit, includes tools (javac) and JRE
JRE: Java Runtime Environment, runs Java applications
JVM: Java Virtual Machine, executes bytecode

Windows Install Steps

Download JDK 17 from Oracle website
Run installer and set JAVA_HOME
Verify with java -version[Screenshot: JDK Verification]

Eclipse Setup

Create new Java Project
Add source files under src/edu/ccrm
Configure run settings[Screenshot: Eclipse Project]

Syllabus Topic Mapping

Encapsulation: Student.java (private fields + getters/setters)
Inheritance: Person.java → Student.java
Streams: CCRM.java (GPA report)

Notes on Assertions
Enable with -ea flag, e.g., java -ea edu.ccrm.cli.CCRMSample: Assert non-null IDs in StudentService