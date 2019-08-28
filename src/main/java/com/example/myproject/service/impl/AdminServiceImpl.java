package com.example.myproject.service.impl;

import com.example.myproject.dao.TownDao;
import com.example.myproject.dto.TownDto;
import com.example.myproject.exception.NoSuchTownException;
import com.example.myproject.exception.RepidNameOfTownException;
import com.example.myproject.mapper.TownMapper;
import com.example.myproject.model.Town;
import com.example.myproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private TownDao townDao;
    @Autowired
    private TownMapper townMapper;

    @Override
    public void addTown(TownDto townDto) throws RepidNameOfTownException {

        Optional<Town> town = Optional.ofNullable(townDao.findTownByTownName(townDto.getTownName()));
        if (town.isPresent()) {
            throw new RepidNameOfTownException();
        } else {
            Town newTown = townMapper.toEntity(townDto);
            townDao.save(newTown);
        }
    }

    @Override
    public void editTown(long id,TownDto townDto) throws RepidNameOfTownException, NoSuchTownException {
        Town townId = townDao.findById(id).orElseThrow(NoSuchTownException::new);
        Optional<Town> town = Optional.ofNullable(townDao.findTownByTownName(townDto.getTownName()));
        if (town.isPresent()) {
            throw new RepidNameOfTownException();
        } else {
            Town newTown = townMapper.toEntity(townDto);
            newTown.setId(id);
            townDao.save(newTown);
        }

    }

    @Override
    public void deleteTown(long id) throws NoSuchTownException {
        Town town = townDao.findById(id).orElseThrow(NoSuchTownException::new);
        townDao.delete(town);
    }

    @Override
    public TownDto findTownById(long id) throws NoSuchTownException {
        Town town = townDao.findById(id).orElseThrow(NoSuchTownException::new);
        TownDto townDto = townMapper.toDto(town);
        return townDto;
    }

    @Override
    public TownDto findTownByName(String townName) throws NoSuchTownException {
        Town town = Optional.ofNullable(townDao.findTownByTownName(townName)).orElseThrow(NoSuchTownException::new);
        TownDto townDto = townMapper.toDto(town);
        return townDto;
    }
}
