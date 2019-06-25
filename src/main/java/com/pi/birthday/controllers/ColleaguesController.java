package com.pi.birthday.controllers;

import com.pi.birthday.repository.ColleagueRepository;
import com.pi.birthday.tables.Colleague;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/colleagues")
public class ColleaguesController {

    @Autowired
    ColleagueRepository colleagueRepository;

    @GetMapping("/get")
    public List<Colleague> getAllColleagueList() {
        return colleagueRepository.findAll();
    }

    @PostMapping("/putColleague")
    public String putColleague(String name, String title, String date) {
        try {
            colleagueRepository.save(new Colleague(new SimpleDateFormat("dd.MM.yyyy").parse(date).getTime(), name, title));
        } catch (ParseException e) {
            e.printStackTrace();
            return "Error";
        }
        return "Success";
    }

    @GetMapping("/{id}/get")
    public Colleague getColleagueById(@PathVariable String id) {
        return colleagueRepository.findById(Integer.parseInt(id)).get();
    }

    @DeleteMapping("/{id}/delete")
    public boolean fireColleagueById(@PathVariable String id) {
        colleagueRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    @DeleteMapping("/delete")
    public boolean fireAllColleague() {
        colleagueRepository.deleteAll();
        return true;
    }
}
