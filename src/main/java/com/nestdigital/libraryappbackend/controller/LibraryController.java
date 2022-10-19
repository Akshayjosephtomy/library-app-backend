package com.nestdigital.libraryappbackend.controller;

import com.nestdigital.libraryappbackend.dao.LibraryDao;
import com.nestdigital.libraryappbackend.model.LibraryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addbook",consumes = "application/json",produces = "application/json")
    private String addbook(@RequestBody LibraryModel book){
        System.out.println(book.toString());
        dao.save(book);
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewbooks")
    public List<LibraryModel> viewbooks(){
        return (List<LibraryModel>) dao.findAll();
    }
}
