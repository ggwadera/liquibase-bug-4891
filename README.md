This Spring Boot application was created to reproduce the bug mentioned in
Liquibase [#4891](https://github.com/liquibase/liquibase/issues/4891).

To reproduce this bug, 2 `SpringLiquibase` beans are defined in the main class.
Both beans point to the same database but have different changelog files.

The bug occurs after the database is already initialized with a changelog.
And on the next time the application starts, the second changelog is not executed.

Follow these steps to reproduce the bug:

1. Clone this repo and start a Postgres database container

```shell
docker run --rm -p 5432:5432 -e POSTGRES_PASSWORD=pw postgres
```

2. Run the Spring Boot application with your IDE or with `mvn spring-boot:run`.
   This will update the database with the first changelog.

3. Now uncomment the second `@Bean` annotation [here](https://github.com/ggwadera/liquibase-bug-4891/blob/main/src/main/java/com/example/demo/DemoApplication.java#L27), to have both `SpringLiquibase` beans activated, and run the application
   again.

4. This time, the database will already be up-to-date according to the first changelog, and the second changelog will
   not be executed.

Checking the `databasechangelog` table created by Liquibase, we can see that indeed the second changelog was not
executed.
