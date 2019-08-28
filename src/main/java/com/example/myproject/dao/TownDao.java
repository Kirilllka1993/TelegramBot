package com.example.myproject.dao;

import com.example.myproject.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TownDao extends JpaRepository<Town, Long> {
    Town findTownByTownName(String name);
}
