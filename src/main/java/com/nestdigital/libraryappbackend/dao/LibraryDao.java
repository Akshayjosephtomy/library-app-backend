package com.nestdigital.libraryappbackend.dao;

import com.nestdigital.libraryappbackend.model.LibraryModel;
import org.springframework.data.repository.CrudRepository;

public interface LibraryDao extends CrudRepository<LibraryModel,Integer> {
}
