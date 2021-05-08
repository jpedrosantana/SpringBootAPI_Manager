# API to manage locally the last football top scorers using Spring WebFlux and DynamoDB

### This project was based on the livecoding promoted by [Digital Innovation One](https://digitalinnovation.one/) and ministered by    [Kamila    Santos](https://github.com/Kamilahsantos/Heroes-SpringWebflux-API).    The original idea was to create an API to manage heroes and more    details can be checked on her repository.

## Table
 The table consists in:
 - Player's **Id**.
 - Player's **Name**
 - Player's **League**
 - Player's number of **Goals**
 - **Year**

## Getting Started:

 - Download [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html) and [AWS DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html) in your computer. The details about how to configure AWS CLI can be checked on their tutorial.
 - After configured AWS CLI and Downloaded DynamoDB, open the DynamoDB folder and run "*java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb*" in your terminal to execute the database.
 - You can also run "aws dynamodb list-tables --endpoint-url http://localhost:8000" to check your tables.
 - Run the class **ScorersTable** to create a new table on DynamoDB.
 - Run the class **ScorersData** to add some information into the table.
 - Run the class **ScorersApiApplication** to run the API on port 8080, so that you can make requests with **Postman** (GET, POST and DELETE) as the image below.

![Requesting all players on database](https://i.imgur.com/ShWdKuJ.png)

## Future Implementations
 - Creating a table validating the datas.
 - Add a method to change an item (PUT).
 - Createing a project detailed documentation.
 - Add some unitary tests using Junit.
