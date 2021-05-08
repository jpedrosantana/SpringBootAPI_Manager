package com.digitalInnovation.GoalscorersAPI.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.digitalInnovation.GoalscorersAPI.constants.ScorersConstant.ENDPOINT_DYNAMO;
import static com.digitalInnovation.GoalscorersAPI.constants.ScorersConstant.REGION_DYNAMO;


public class ScorersData {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Top_Goal_Scorers_Table");
        Item scorer = new Item()
                .withPrimaryKey("id", "1")
                .withString("name", "Jamie Vardy")
                .withString("league", "Premier League")
                .withNumber("goals", 23)
                .withNumber("year", 2020);

        Item scorer2 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Ciro Immobile")
                .withString("league", "Serie A")
                .withNumber("goals", 36)
                .withNumber("year", 2020);

        Item scorer3 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Ben Yedder")
                .withString("league", "Ligue 1")
                .withNumber("goals", 18)
                .withNumber("year", 2020);

        Item scorer4 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Kylian Mbappé")
                .withString("league", "Ligue 1")
                .withNumber("goals", 18)
                .withNumber("year", 2020);

        //saida da tabela
        PutItemOutcome outcome = table.putItem(scorer);
        PutItemOutcome outcome2 = table.putItem(scorer2);
        PutItemOutcome outcome3 = table.putItem(scorer3);
        PutItemOutcome outcome4 = table.putItem(scorer4);

    }
}
