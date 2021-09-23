package com.example.demo.controller;

import com.example.demo.model.Lesson;
import com.example.demo.repository.LessonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return (Lesson) this.repository.save(lesson);
    }

    @GetMapping("{id}")
    public Optional<Lesson> getRecordById(@PathVariable long id) {
        return this.repository.findById(id);
    }

    @DeleteMapping("{id}")
    public String deleteByUd(@PathVariable long id) {
        this.repository.deleteById(id);
        return String.format("Record %d has been deleted!", id);

    }

}
