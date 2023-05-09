### Description

The application is based on classic layer approach:
- Integration layer and domain (kind of repository layer in classic model)
- Service layer
- Web layer (REST API)
- Transfer objects (representations)

#### REST API:
- Provide the top repositories based on given criteria.
  All restrictions are according the original requirements:
  - List size: 10, 50 or 100.
  - Date format according the Github documentation.
  - Stars number is not negative.

More details you can find here: http://localhost:8080/api/space/vc/swagger-ui.html

#### Github integration
A declarative spring client was used to implement Github search API. 
To simplify a using of a client, the Simple Filter Builder was implemented.

NOTE: The additional calls were not implemented because it's not a good idea to do dynamic calls based on URLs from response.
First of all it's a potential security issues, support and of course request in that way will be too hard, actually not for all use cases.

### Run application:
To run application perform the following command:
```shell
./gradlew bootRun
```
To run tests, please use the next command
```shell
./gradlew clean test
```
[To create a call please use swagger UI.](http://localhost:8080/api/space/vc/swagger-ui.html)

##### Additional config
The github url can be set via application config in _resources/application.yaml_ file, the property _github.url_.


