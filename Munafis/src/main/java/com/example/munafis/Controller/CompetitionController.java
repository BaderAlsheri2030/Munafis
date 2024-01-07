package com.example.munafis.Controller;


import com.example.munafis.Model.Competition;
import com.example.munafis.Service.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/competition")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;




    @GetMapping("/get")
    public ResponseEntity getCompetitions(){
        return ResponseEntity.status(200).body(competitionService.getCompetitions());
    }


    @PostMapping("/add")
    public ResponseEntity addCompetition(@Valid @RequestBody Competition competition){
        competitionService.addCompetition(competition);
        return ResponseEntity.status(200).body("competition added");
    }

    @PutMapping("/update{id}")
    public ResponseEntity updateCompetition(@Valid @RequestBody Competition competition, @PathVariable Integer id){
        competitionService.updateCompetition(id,competition);
        return ResponseEntity.status(200).body("competition updated");
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity deleteCompetition(@PathVariable Integer id){
        competitionService.deleteCompetition(id);
        return ResponseEntity.status(200).body("competition deleted");
    }


}
