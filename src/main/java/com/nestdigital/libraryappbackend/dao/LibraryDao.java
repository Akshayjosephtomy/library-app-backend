package com.nestdigital.libraryappbackend.dao;

import com.nestdigital.libraryappbackend.model.LibraryModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryDao extends CrudRepository<LibraryModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `books` WHERE `id`= :id",nativeQuery = true)
    void deleteBookById(Integer id);

    @Query(value = "SELECT `id`, `author`, `name`, `pdate`, `price` FROM `books` WHERE `name`= :name",nativeQuery = true)
    List<LibraryModel> searchBook(String name);

    @Modifying
    @Query(value = "UPDATE `books` SET `author`= :author,`name`= :name,`pdate`= :pdate,`price`= :price WHERE `id`= :id",nativeQuery = true)
    void updatBook(String name,String author,String pdate,String price,Integer id);
}
