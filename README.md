sbt run

```
Publishing a new package - PackageArrivedEvent(package001,List(shirts, pants))
Publishing a new package - PackageArrivedEvent(package002,List(underwear))
subscriber-1 - receiving a new package: PackageArrivedEvent(package001,List(shirts, pants))
subscriber-2 - receiving a new package: PackageArrivedEvent(package001,List(shirts, pants))
subscriber-1 - receiving a new package: PackageArrivedEvent(package002,List(underwear))
subscriber-2 - receiving a new package: PackageArrivedEvent(package002,List(underwear))
```