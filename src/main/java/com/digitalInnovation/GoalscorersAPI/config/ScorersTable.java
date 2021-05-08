package com.digitalInnovation.GoalscorersAPI.config;
//Usado para criar as tabelas
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.Table;
import static  com.digitalInnovation.GoalscorersAPI.constants.ScorersConstant.REGION_DYNAMO;
import static  com.digitalInnovation.GoalscorersAPI.constants.ScorersConstant.ENDPOINT_DYNAMO;

import java.util.Arrays;

public class ScorersTable {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "Top_Goal_Scorers_Table";

        try{
            System.out.println("Creating table, please wait...");
            Table table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                    Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L,5L));
            table.waitForActive();
            System.out.println("Success " + table.getDescription().getTableStatus());

        }catch (Exception e){
            System.err.println("It's not possible to create table");
            System.err.println(e.getMessage());
        }
    }
}
