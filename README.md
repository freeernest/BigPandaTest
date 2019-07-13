# BigPandaTest - Introduction

Senior Software Developer interview submission task for Big Panda !
by Erik Feigin.

Current solution is using 
	* Vert.x
	* Spring Boot
	* Kafka
	* Maven
	
It is build in microservices architecture, so this system can be clustered, thus it is easily scalable.

Consumer is reading the messages and save them to in-memory cache (Kafka queue) without any complex logic that could take time.

Then another process is reading messages from the queue and save the data in clasterd Hazelcast IMDG memory in a way that will help with the stats API.

The HTTP API should get his data from the final data.


# Prerequisites

	1. JDK 1.8 or later
	2. Maven 3.0  or later
	3. Kafka 2.1 or later
	4. Your Own Savvy !

# How To Build and Run:

1. Clone 3 projects from GitHub:
		1. https://github.com/freeernest/BigPandaTest.git
		2. https://github.com/freeernest/blackbox-listener.git
		3. https://github.com/freeernest/blackbox-statistics-reader.git

2. Build the Spring boot app with maven dependencies for each of 3 cloned projects.
	2.1 Better use InteliJ IDE and run the 'mvn clean install' command (or simply run it from cmd)

3. Start Zookeeper and then start Kafka on default port - 9092.

4. Via IDE run main method of BlackBoxProcessRunnerApplication.class from project "blackbox-process-runner-service" (https://github.com/freeernest/BigPandaTest.git)

5. Via IDE run main method of BlackBoxListenerApplication from project "blackbox-listener" (https://github.com/freeernest/blackbox-listener.git)

6. Via IDE run main method of BlackBoxStatisticsReaderApplication from project "blackbox-statistics-reader" (https://github.com/freeernest/blackbox-statistics-reader.git)


3. For getting the stats: 
	*   GET http://localhost:8081/statistics/data 
	*   GET http://localhost:8081/statistics/type

# Thing To Improve

1. Think that there is a better way to read the stream in a non blocking way. I read about NIO, but I'm not familiar with it, so I do not have enough time on understanding it for this assignment.
2. Write more tests, I'm the kind of person who does not approve a PR without checking all the tests.
3. Enrich logging
4. Exception handling


Best Regards,
Erik Feigin







# Reference

Initial requirements:

Your exercise is to implement a Non Blocking Producer/Consumer stream processing service that exposes an HTTP api.


You are provided with a blackbox executable that splits out an infinite stream of lines of event data encoded in JSON. You can download it here:


* Linux -

https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-linux-amd64


* Mac OS X -

https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-macosx-amd64


* Windows -

https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-windows-amd64.exe


Service Requirements

It should consume the output of the generator and gather the following stats:
A count of events by event type.
A count of words encountered in the data field of the events. (e.g. “the” → 32, “me” → 5)
It should expose these stats in an HTTP interface.
Stream may encounter corrupt JSON lines and should handle such events well and without interruption.


Important Notes



Please read thoroughly as it may affect your submission!


We are looking for simple readable code which is not over-engineered.
The design of your solution should decouple the reads from the writes. Try to think on what it means when scaling such a service.
You can implement this exercise in either Java or Scala.
The task should take no more than 2-3 hours.
If you already know some reactive framework (For example: RXJava, RxScala, Play, Akka, VertX, Reactor or anything similar) use what you know! if you don't know any of these frameworks read a bit and understand what your implementation can benefit from these proposed frameworks.
Add a README file with instructions on running the project. In the README file, please note 3 things you would improve in your submission.

