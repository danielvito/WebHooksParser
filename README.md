## Synopsis

This is a simple project to read a log of webhooks and print a rank and summary.

## Installation

1. Checkout or download the project
2. Configure a new maven project in eclipse
3. Run targets on maven: clean install verify

## Tests

1. Run target on maven: test

Expected result:

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running devitos.TestApp
INFO  2017-04-27 10:43:40,409 [main][Report.java:72] : https://eagerhaystack.com - 750
INFO  2017-04-27 10:43:40,412 [main][Report.java:72] : https://surrealostrich.com.br - 734
INFO  2017-04-27 10:43:40,412 [main][Report.java:72] : https://grimpottery.net.br - 732
INFO  2017-04-27 10:43:40,882 [main][Report.java:43] : 404 - 1474
INFO  2017-04-27 10:43:40,883 [main][Report.java:43] : 503 - 1451
INFO  2017-04-27 10:43:40,883 [main][Report.java:43] : 400 - 1440
INFO  2017-04-27 10:43:40,883 [main][Report.java:43] : 500 - 1428
INFO  2017-04-27 10:43:40,883 [main][Report.java:43] : 200 - 1417
INFO  2017-04-27 10:43:40,883 [main][Report.java:43] : 201 - 1402
INFO  2017-04-27 10:43:40,883 [main][Report.java:43] : 204 - 1388
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.525 sec - in devitos.TestApp

Results :

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.747 s
[INFO] Finished at: 2017-04-27T10:43:41-03:00
[INFO] Final Memory: 10M/241M
[INFO] ------------------------------------------------------------------------
```

## License

Free to use.