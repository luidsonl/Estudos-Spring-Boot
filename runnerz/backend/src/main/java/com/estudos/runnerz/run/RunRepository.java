package com.estudos.runnerz.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll(){
        return jdbcClient.sql("SELECT * FROM run").query(Run.class).list();
    }

    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("SELECT * FROM run WHERE id = :id").param("id", id).query(Run.class).optional();
    }


    public void create(Run run) {
        jdbcClient.sql("INSERT INTO run (title, startPoint, endPoint, startTime, endTime) VALUES (:title, :startPoint, :endPoint, :startTime, :endTime)")
                .param("title", run.title())
                .param("startPoint", run.startPoint())
                .param("endPoint", run.endPoint())
                .param("startTime", run.startTime())
                .param("endTime", run.endTime())
                .update();
    }

    public void update(Run run, Integer id) {
        jdbcClient.sql("UPDATE run SET title = :title, startPoint = :startPoint, endPoint = :endPoint, startTime = :startTime, endTime = :endTime WHERE id = :id")
                .param("title", run.title())
                .param("startPoint", run.startPoint())
                .param("endPoint", run.endPoint())
                .param("startTime", run.startTime())
                .param("endTime", run.endTime())
                .param("id", id)
                .update();
    }

    public void delete(Integer id) {
        jdbcClient.sql("DELETE FROM run WHERE id = :id")
                .param("id", id)
                .update();
    }
}
