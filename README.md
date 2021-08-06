# Set Up

Andmebaasi püsti panemine. 
```
cd Docker
docker-compose up
```
See seadistab üles andmebaasi.
<br>
Andmebaasidesse algandmete laadimise jaoks tuleb kasutada Flyway'd.
Intellij üleval paremas nurgas asuvad Gradle'i erinevad funktsioonid.

```
Gradle > skoop-api > Tasks > flyway
```
Rakenduse jooksutamiseks tuleb kasutada järgnevaid Flyway funktsioone.

```
flywayCleanRealDb
flywayMigrateRealDb
```
Cleaniga ta algselt resetib andmebaasi ning migratsiooniga jooksutab resource kaustas olevaid sql faile.
