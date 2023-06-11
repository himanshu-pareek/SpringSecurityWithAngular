# Spring Angular Frontend Server

Starting template to serve angular application using spring boot server.

## Running the application in local machine

```shell
./mvnw spring-boot:run
```

If you want to run the application in debug mode, do the following:

1. Build angular application
    ```shell
    ./mvnw generate-resources
    ```
    OR
    ```shell
    cd ./client && ./npm run watch
    ```
    The above command will keep watching for changes in angular app source code and will rebuild the app for development environment.

2. Run the spring-boot application in debug mode using IDE.
