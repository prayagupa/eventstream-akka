sbt run

```
Publishing a new package - PackageArrivedEvent(package001,List(shirts, pants))
Publishing a new package - PackageArrivedEvent(package002,List(underwear))
subscriber-1 - receiving a new package: PackageArrivedEvent(package001,List(shirts, pants))
subscriber-2 - receiving a new package: PackageArrivedEvent(package001,List(shirts, pants))
subscriber-1 - receiving a new package: PackageArrivedEvent(package002,List(underwear))
subscriber-2 - receiving a new package: PackageArrivedEvent(package002,List(underwear))

Publishing a new package - PackageArrivedEvent(package001,List(shirts, pants))
Publishing a new package - PackageArrivedEvent(package002,List(underwear))
PackageArrivedSubscriber-2 - receiving a new package: PackageArrivedEvent(package001,List(shirts, pants))
PackageArrivedSubscriber-1 - receiving a new package: PackageArrivedEvent(package001,List(shirts, pants))
PackageArrivedSubscriber-2 - receiving a new package: PackageArrivedEvent(package002,List(underwear))
PackageArrivedSubscriber-1 - receiving a new package: PackageArrivedEvent(package002,List(underwear))
```

```
[INFO] [03/17/2016 19:29:28.082] [event-stream-akka.actor.default-dispatcher-4] 
[akka://event-stream/user/packageReleasedActor] 
Message [com.eventstream.ES.PackageReleaseCommand] from Actor[akka://event-stream/deadLetters] 
to Actor[akka://event-stream/user/packageReleasedActor#-1035444494] was not delivered. 
[1] dead letters encountered. This logging can be turned off or adjusted with configuration settings 
'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
```

solution
-----------
add .conf

Journal/EventStream
----------
```
List(shirts,pants-0, shirts,pants- 1, shirts,underwear-2, shirts,underwear- 3, coat-4, coat- 5)
```

```
$ ls -l target/EventStreamAkka/
total 0
drwxr-xr-x  7 prayagupd  staff  238 Mar 19 02:08 journal
drwxr-xr-x  4 prayagupd  staff  136 Mar 19 02:08 snapshots
```