```
start mongo 3.0.7

sbt run
```

Actor State
-----------

```
List(PackageReleasedEvent(PCKG001,[Ljava.lang.String;@f58efee), 
PackageReleasedEvent(PCKG002,[Ljava.lang.String;@30312d14), 
PackageReleasedEvent(PCKG003,[Ljava.lang.String;@4ccaf6f1))
```

```
2016-03-23T00:07:00.170-0400 I INDEX    [conn2] allocating new ns file /data/db/PackageArrived.ns, filling with zeroes...
2016-03-23T00:07:00.200-0400 I STORAGE  [FileAllocator] allocating new datafile /data/db/PackageArrived.0, filling with zeroes...
2016-03-23T00:07:00.200-0400 I STORAGE  [FileAllocator] creating directory /data/db/_tmp
2016-03-23T00:07:00.276-0400 I STORAGE  [FileAllocator] done allocating datafile /data/db/PackageArrived.0, size: 64MB,  took 0.076 secs
2016-03-23T00:07:00.309-0400 I INDEX    [conn2] build index on: PackageArrived.events properties: { v: 1, key: { sequenceNr: 1 }, name: "sequenceNr_1", ns: "PackageArrived.events" }
2016-03-23T00:07:00.309-0400 I INDEX    [conn2] 	 building index using bulk method
2016-03-23T00:07:00.309-0400 I INDEX    [conn2] build index done.  scanned 0 total records. 0 secs
2016-03-23T00:07:00.309-0400 I COMMAND  [conn2] command PackageArrived.$cmd command: createIndexes { createIndexes: "events", indexes: [ { key: { sequenceNr: 1 }, name: "sequenceNr_1", ns: "PackageArrived.events" } ] } keyUpdates:0 writeConflicts:0 numYields:0 reslen:113 locks:{ Global: { acquireCount: { r: 1, w: 1 } }, MMAPV1Journal: { acquireCount: { w: 9 } }, Database: { acquireCount: { W: 1 } }, Collection: { acquireCount: { W: 1 } }, Metadata: { acquireCount: { W: 5 } } } 138ms
2016-03-23T00:07:00.313-0400 I NETWORK  [conn2] end connection 127.0.0.1:63183 (1 connection now open)
2016-03-23T00:07:00.313-0400 I NETWORK  [conn1] end connection 127.0.0.1:63182 (1 connection now open)
2016-03-23T00:07:10.581-0400 I NETWORK  [initandlisten] connection accepted from 127.0.0.1:63185 #3 (1 connection now open)
2016-03-23T00:07:10.581-0400 I NETWORK  [initandlisten] connection accepted from 127.0.0.1:63186 #4 (2 connections now open)
2016-03-23T00:07:10.609-0400 I NETWORK  [initandlisten] connection accepted from 127.0.0.1:63187 #5 (3 connections now open)
2016-03-23T00:07:10.611-0400 I NETWORK  [initandlisten] connection accepted from 127.0.0.1:63188 #6 (4 connections now open)
2016-03-23T00:07:10.624-0400 I INDEX    [conn6] build index on: PackageArrived.events properties: { v: 1, unique: true, key: { persistenceId: 1, sequenceNr: 1 }, name: "persistenceId_1_sequenceNr_1", ns: "PackageArrived.events" }
2016-03-23T00:07:10.624-0400 I INDEX    [conn6] 	 building index using bulk method
2016-03-23T00:07:10.625-0400 I INDEX    [conn6] build index done.  scanned 0 total records. 0 secs
2016-03-23T00:07:10.626-0400 I INDEX    [conn5] build index on: PackageArrived.snapshots properties: { v: 1, unique: true, key: { persistenceId: 1, sequenceNr: 1, timestamp: 1 }, name: "persistenceId_1_sequenceNr_1_timestamp_1", ns: "PackageArrived.snapshots" }

```

mongodb event-stream
--------------------

```
use shipping-db
prayag-top(mongod-3.0.7) shipping-db> show collections
EventStream    → 0.003MB / 0.008MB
Snapshot       → 0.002MB / 0.008MB
system.indexes → 0.001MB / 0.008MB
```

```
db.EventStream.find({})
{
  "_id": ObjectId("56f2166e9b64750c13a9ba81"),
  "persistenceId": "packageReleasedActor",
  "sequenceNr": NumberLong("1"),
  "marker": "",
  "message": BinData(0, "CoEBCAESfaztAAVzcgAnY29tLmV2ZW50c3RyZWFtLkVTLlBhY2thZ2VSZWxlYXNlZEV2ZW50j9CsYaUgqB8CAAJJAApzZXF1ZW5jZUlkTAAJcGFja2FnZUlkdAASTGphdmEvbGFuZy9TdHJpbmc7eHAAAAAAdAAMc2hpcnRzLHBhbnRzEAEaFHBhY2thZ2VSZWxlYXNlZEFjdG9yaiQxYTJkOGJjYy0yMTFmLTRkOGItODY3Zi0wNmMwNGM5NWQ0MzU=")
}
{
  "_id": ObjectId("56f2166e9b64750c13a9ba82"),
  "persistenceId": "packageReleasedActor",
  "sequenceNr": NumberLong("2"),
  "marker": "",
  "message": BinData(0, "CoMBCAESf6ztAAVzcgAnY29tLmV2ZW50c3RyZWFtLkVTLlBhY2thZ2VSZWxlYXNlZEV2ZW50j9CsYaUgqB8CAAJJAApzZXF1ZW5jZUlkTAAJcGFja2FnZUlkdAASTGphdmEvbGFuZy9TdHJpbmc7eHAAAAABdAAOdGVlcyx1bmRlcndlYXIQAhoUcGFja2FnZVJlbGVhc2VkQWN0b3JqJDFhMmQ4YmNjLTIxMWYtNGQ4Yi04NjdmLTA2YzA0Yzk1ZDQzNQ==")
}
{
  "_id": ObjectId("56f2166e9b64750c13a9ba83"),
  "persistenceId": "packageReleasedActor",
  "sequenceNr": NumberLong("3"),
  "marker": "",
  "message": BinData(0, "CnkIARJ1rO0ABXNyACdjb20uZXZlbnRzdHJlYW0uRVMuUGFja2FnZVJlbGVhc2VkRXZlbnSP0KxhpSCoHwIAAkkACnNlcXVlbmNlSWRMAAlwYWNrYWdlSWR0ABJMamF2YS9sYW5nL1N0cmluZzt4cAAAAAJ0AARjb2F0EAMaFHBhY2thZ2VSZWxlYXNlZEFjdG9yaiQxYTJkOGJjYy0yMTFmLTRkOGItODY3Zi0wNmMwNGM5NWQ0MzU=")
}
```

ActorStateSnapshot/EventMarker
-------------------------------------

```
prayag-top(mongod-3.0.7) shipping-db> db.Snapshot.find({})
{
  "_id": ObjectId("56f21a559b64750d27aaa749"),
  "persistenceId": "packageReleasedActor",
  "sequenceNr": NumberLong("2"),
  "snapshot": BinData(0, "BAAAAAEAAACs7QAFc3IAKWNvbS5ldmVudHN0cmVhbS5FUy5SZWxlYXNlZFBhY2thZ2VzX1N0YXRlSnvjTowbTDcCAAFMAAdoaXN0b3J5dAAhTHNjYWxhL2NvbGxlY3Rpb24vaW1tdXRhYmxlL0xpc3Q7eHBzcgAyc2NhbGEuY29sbGVjdGlvbi5pbW11dGFibGUuTGlzdCRTZXJpYWxpemF0aW9uUHJveHkAAAAAAAAAAQMAAHhwc3IAJ2NvbS5ldmVudHN0cmVhbS5FUy5QYWNrYWdlUmVsZWFzZWRFdmVudI/QrGGlIKgfAgACSQAKc2VxdWVuY2VJZEwACXBhY2thZ2VJZHQAEkxqYXZhL2xhbmcvU3RyaW5nO3hwAAAAAXQADnRlZXMsdW5kZXJ3ZWFyc3EAfgAFAAAAAHQADHNoaXJ0cyxwYW50c3NyACxzY2FsYS5jb2xsZWN0aW9uLmltbXV0YWJsZS5MaXN0U2VyaWFsaXplRW5kJIpcY1v3UwttAgAAeHB4"),
  "timestamp": NumberLong("1458707029316")
}
Fetched 1 record(s) in 1ms

```

References
------------

http://www.slideshare.net/SanderMak/eventsourced-architectures-with-akka

http://krasserm.blogspot.com/2013/12/introduction-to-akka-persistence.html

Questions
------------
* How actor state is mapped back once actor/consumer instance is re-started? 

_persistenceId mapped to journal collection field maybe_

_When a PersistentActor is started or restarted, journaled messages are replayed to that actor so that it can recover 
internal state from these messages._

* How external system can talk to PersistentActor so that it receives Commands ?? 

_CommandStreaming ??_

_external system probably doesn't need to talk to, rather talks to some end point which will publish the Command?? I don't know._

* PersistentActor snapshots the Events not the Commands??

* What if same Command is processed twice?? Can it happen?? How can it be prevented?

* Who processes Events actually?? All i see is Commands.

_PersistentView ??
A PersistentView is a persistent, stateful actor that receives JournaledMessages that have been written 
by another persistent actor. 
A PView itself does not journal new messages, instead, it updates internal-state only from 
a PersistentActor's replicated message stream._