The main objective of this demo application is to implement a 3-tier architecture : 

The goal from using such an architecture is to decouple our application components. 
For that we distinguish 3 layers : 
 - **DAO**: Entity + repository
 - **Service**: A business class that communicates with both the web and dao components. 
 We implement such an object in Spring by using @Service annotation on the class.
 - **Web**: The web part consists of Spring rest controllers in order to expose our developed services (basic CRUD in our case) via HTTP.  
 
 
 Within the same application, we introduced the Spring MVC as an alternative for the web layer. 
 The major difference between a Rest Controller and an MVC Controller is that we will use the data returned
 from the service layer to render the view (jsp page) in the server side and return an HTML
 document instead of JSON objects.
 
 We also introduced the DTO (Data Transfer Object) which allow us to : 
    
  - Give an abstraction on the state of our entities.
  - Build our return values that could come from different entities in a single model.
  
  
  For the project structure, we find : 
  - dao package: Contains entities and repositories.
  - service package: contains our business objects (services).
  - web package:  contains our Rest/MVC controllers.
  
  As utility libraries we used **lombok**. It comes with annotations that we add to our Java classes 
  mainly the POJO classes in order to generate getters/setters/toString/constructors... at runtime.
  
  - @Getter: generates getter methods for all fields.  
  - @Setter: generates setter methods for all fields. 
  - @ToString : generates toString method.
  - @AllArgsConstructor: Constructor with all arguments (fields) of the class.
  - @NoArgsConstructor: Empty constructor.
  - @Data: generates getters/setters/toString/equals/hashCode
  
  
  **Note**: In order to work with Spring MVC in a spring boot application,
  we need to add 2 dependecies: 
  - JSTL: used in our jsp pages.
  - tomcat-embed-jasper: It will allow our embedded tomcat to understand the jsp pages.
  
            `<dependency>
                 <groupId>javax.servlet</groupId>
                 <artifactId>jstl</artifactId>
                 <version>1.2</version>
             </dependency>`
               
            `<dependency>
                 <groupId>org.apache.tomcat.embed</groupId>
                 <artifactId>tomcat-embed-jasper</artifactId>
                 <version>9.0.43</version>
            </dependency>`