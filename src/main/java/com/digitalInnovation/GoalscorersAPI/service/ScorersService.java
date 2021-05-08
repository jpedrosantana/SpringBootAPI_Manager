package com.digitalInnovation.GoalscorersAPI.service;

import com.digitalInnovation.GoalscorersAPI.document.Scorers;
import com.digitalInnovation.GoalscorersAPI.repository.ScorersRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class ScorersService {
    private final ScorersRepository scorersRepository;

    public ScorersService(ScorersRepository scorersRepository){
        this.scorersRepository = scorersRepository;
    }

    public Flux<Scorers>findAll(){
        return Flux.fromIterable(this.scorersRepository.findAll());

    }

    public Mono <Scorers> findByIdScorer(String id){

        return Mono.justOrEmpty(this.scorersRepository.findById(id));
    }

    public Mono<Scorers> save(Scorers scorers){

        return Mono.justOrEmpty(this.scorersRepository.save(scorers));
    }

    public Mono<Boolean> deleteByIdScorer(String id){
        scorersRepository.deleteById(id);
        return Mono.just(true);
    }
}
