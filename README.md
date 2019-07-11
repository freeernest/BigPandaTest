# BigPandaTest
BigPandaTest

Senior Software Developer interview submission task for Big Panda !
by Erik Feigin.


I think the consumer should read the messages and save them to in-memory cache (like a queue) without any complex logic that could take time.

After, another process should read from the queue and save the data (in DB/Redis/in-memory) in a way that will help with the stats API.

The HTTP API should get his data from the final data.

How To Run:

1. Clone 3 projects from GitHub:
		*
		*
		*

2. Build the Spring boot app with maven dependencies.

3. For getting the stats: GET http://localhost:8080/AyeletBigPanda_war_exploded/events/stats.

Thing To Improve

1. I know there is a way to start listening to the generator without calling it as an API, but I worked on the assignment about 4 hours and didn't want to exaggerate.
2.  should have write tests, I'm the kind of person who does not approve a PR without checking all the tests.
3. think that there is a better way to read the stream in a non blocking way. I read about NIO, but I'm not familiar with it, so I didn't want to spent the time on understanding it for this assignment.


Best Regards,
Erik Feigin



Reference.

Initial requirements:

Your exercise is to implement a Non Blocking Producer/Consumer stream processing service that exposes an HTTP api.





You are provided with a blackbox executable that spits out an infinite stream of lines of event data encoded in JSON. You can download it here:





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

