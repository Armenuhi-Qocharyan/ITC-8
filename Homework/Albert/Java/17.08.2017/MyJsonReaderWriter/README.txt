1) Description.
    Read data from json file using maven,and write test for functions.

2) How to run.
    $ cd DIR
    $ mvn package
    $ java -cp target/MyJsonReaderWriter-1.0-SNAPSHOT-jar-with-dependencies.jar  com.app.App 

3) How to run only test
    $ mvn test

3) Folder structure.

    MyJsonReaderWriter/
    ├── data.json
    ├── pom.xml
    └── src
        ├── main
        │   └── java
        │       └── com
        │           └── app
        │               └── App.java
        └── test
            └── java
                └── com
                    └── app
                        └── AppTest.java
