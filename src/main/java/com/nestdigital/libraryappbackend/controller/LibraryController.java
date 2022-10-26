package com.nestdigital.libraryappbackend.controller;

import com.nestdigital.libraryappbackend.dao.LibraryDao;
import com.nestdigital.libraryappbackend.model.LibraryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deletebook",consumes = "application/json",produces = "application/json")
    public String deletebook(@RequestBody LibraryModel library){
        dao.deleteBookById(library.getId());
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchbook",consumes = "application/json",produces = "application/json")
    public List<LibraryModel> searchbook(@RequestBody LibraryModel book){
        return (List<LibraryModel>) dao.searchBook(book.getName());
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/updatebook",consumes = "application/json",produces = "application/json")
    public String updatebook(@RequestBody LibraryModel library){
        dao.updatBook(library.getName(), library.getAuthor(), library.getPdate(), library.getPrice(), library.getId());
        return "(status:'success')";
    }
}
