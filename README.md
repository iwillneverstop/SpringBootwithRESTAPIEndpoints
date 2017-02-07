I) Resources, methods, and OpenAPI definition files:

- /reviews:
	(1) GET (Get a list of reviews)
	(2) POST (Add a new review to the list)
	
- /reviews{reviewid}:
	(1) GET (Get a review)
	(2) PUT (Update an existing review)
	(3) DELETE (Delete a review)
  
 - Check 'yaml' folder for OpenAPI definition files.
  
II) Spring Boot project

- Check 'spring-boot-review' folder

III) Generating a client

- Download 'swagger-codegen-cli-2.2.1.jar' from https://github.com/swagger-api/swagger-codegen
- Run 'java -jar swagger-codegen-cli-2.2.1.jar generate -i ReviewsAPIWithCommonDataDefinitions.yaml -l java -o java-client' with 'ReviewsAPIWithCommonDataDefinitions.yaml' file is in 'yaml' folder and java-client is the name for the generated client.

- Check 'java-client' folder for a pre-generated java-client. Within this java-client, check DefaultApiTest.java for how to use this client.
