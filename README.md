# spring-hateoas-lambda
Sample Lambda with Spring Boot and HATEOAS.

# Build:
```
mvn clean package
```

# Run locally with SAM:

https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html


```
sam local invoke -e elb-event.json
```

Debug mode:
```
sam local invoke -d 5005 -e elb-event.json
```
