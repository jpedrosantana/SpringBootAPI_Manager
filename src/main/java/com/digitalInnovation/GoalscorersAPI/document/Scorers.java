package com.digitalInnovation.GoalscorersAPI.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id; //para acessar a PK do banco
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Top_Goal_Scorers_Table")
public class Scorers {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "league")
    private String league;

    @DynamoDBAttribute(attributeName = "goals")
    private int goals;

    @DynamoDBAttribute(attributeName = "year")
    private int year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getYear(){ return year; }

    public void setYear(int year){ this.year = year; }

    public Scorers(String id, String name, String league, int goals, int year){
        this.id = id;
        this.name = name;
        this.league = league;
        this.goals = goals;
        this.year = year;
    }


}
