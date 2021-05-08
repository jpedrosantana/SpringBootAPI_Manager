package com.digitalInnovation.GoalscorersAPI.controler;

import com.digitalInnovation.GoalscorersAPI.document.Scorers;
import com.digitalInnovation.GoalscorersAPI.repository.ScorersRepository;
import com.digitalInnovation.GoalscorersAPI.service.ScorersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalInnovation.GoalscorersAPI.constants.ScorersConstant.SCORERS_ENDPOINT_LOCAL;

@RestController
@Slf4j

public class ScorersController {
    ScorersService scorersService;
    ScorersRepository scorersRepository;

    private static final org.slf4j.Logger log=
            org.slf4j.LoggerFactory.getLogger(ScorersController.class);

    public ScorersController(ScorersService scorersService, ScorersRepository scorersRepository){
        this.scorersService = scorersService;
        this.scorersRepository = scorersRepository;
    }

    @GetMapping(SCORERS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Scorers> getAllItems(){
        log.info("requesting the list of all top scorers");
        return scorersService.findAll();
    }

    @GetMapping(SCORERS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Scorers>> findByIDScorer(@PathVariable String id){

        log.info("requesting the top scorer with id {}", id);
        return scorersService.findByIdScorer(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(SCORERS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Scorers> createScorer(@RequestBody Scorers scorers){
        log.info("a new top scorer was created");
        return scorersService.save(scorers);
    }

    @DeleteMapping(SCORERS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public Mono<HttpStatus> deleteByIdScorers(@PathVariable String id){
        scorersService.deleteByIdScorer(id);
        log.info("delete a top scorer with id {}", id);
        return Mono.just(HttpStatus.OK);
    }
}
