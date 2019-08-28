package com.example.myproject.service;

import com.example.myproject.dto.TownDto;
import com.example.myproject.exception.NoSuchTownException;
import com.example.myproject.exception.RepidNameOfTownException;

public interface AdminService {

    void addTown(TownDto townDto) throws RepidNameOfTownException;

    void editTown(long id,TownDto townDto) throws RepidNameOfTownException, NoSuchTownException;

    void deleteTown(long id) throws NoSuchTownException;

    TownDto findTownById(long id) throws NoSuchTownException;

    TownDto findTownByName(String townName) throws NoSuchTownException;


}
