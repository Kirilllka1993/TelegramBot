package com.example.myproject.service.impl;

import com.example.myproject.dao.TownDao;
import com.example.myproject.dto.TownDto;
import com.example.myproject.exception.NoSuchTownException;
import com.example.myproject.mapper.TownMapper;
import com.example.myproject.model.Town;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private TownDao townDao;
    @Autowired
    private TownMapper townMapper;

    @Override
    public TownDto getDescription(String name) throws NoSuchTownException {
        Town town = Optional.ofNullable(townDao.findTownByTownName(name)).orElseThrow(() -> new NoSuchTownException());
        TownDto townDto = townMapper.toDto(town);
        return townDto;
    }

    public List<Town> findAll() {
        List<Town> towns = townDao.findAll();
        return towns;
    }
}
