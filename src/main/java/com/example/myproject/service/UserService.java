package com.example.myproject.service;


import com.example.myproject.dto.TownDto;
import com.example.myproject.exception.NoSuchTownException;
import com.example.myproject.model.Town;

import java.util.List;

public interface UserService {
    TownDto getDescription(String name) throws NoSuchTownException;
    List<Town> findAll();
}
