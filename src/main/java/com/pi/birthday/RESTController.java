package com.pi.birthday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController

public class RESTController {

    @Autowired
    ColleagueRepository colleagueRepository;

    @GetMapping("/getAll")
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

    @GetMapping("/get")
    public Colleague getColleagueById(String id) {
        return colleagueRepository.findById(Integer.parseInt(id)).get();
    }

    @DeleteMapping("/delete")
    public boolean fireColleagueById(String id) {
        colleagueRepository.deleteById(Integer.parseInt(id));
        return true;
    }

    @DeleteMapping("/deleteAll")
    public boolean fireAllColleague() {
        colleagueRepository.deleteAll();
        return true;
    }
}
