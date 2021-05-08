package com.digitalInnovation.GoalscorersAPI.repository;

import com.digitalInnovation.GoalscorersAPI.document.Scorers;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


//Camada de acess dos dados
@EnableScan
public interface ScorersRepository extends CrudRepository<Scorers, String>{
}