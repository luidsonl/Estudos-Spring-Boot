package com.estudos.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<Run>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream().filter(run -> Objects.equals(run.id(), id)).findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update (Run run, Integer id){
        Optional<Run> existinRun = findById(id);

        existinRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private  void init(){
        runs.add(new Run(
                1,
                "Running in the 90's",
                "kokiri forest",
                "gerundo valley",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1)
        ));
        runs.add(new Run(
                2,
                "Running alone",
                "Konoha",
                "Vila da névoa",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2)

        ));
    }
}
