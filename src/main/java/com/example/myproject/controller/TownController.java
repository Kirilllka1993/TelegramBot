package com.example.myproject.controller;

import com.example.myproject.dto.TownDto;
import com.example.myproject.exception.NoSuchTownException;
import com.example.myproject.exception.RepidNameOfTownException;
import com.example.myproject.model.Town;
import com.example.myproject.service.AdminService;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TownController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Town>> findAll() {
        List<Town> mess= userService.findAll();
        return ResponseEntity.ok().body(mess);
    }

    @GetMapping("/findDescription")
    public ResponseEntity<TownDto> getHello(@RequestBody TownDto townDto) throws NoSuchTownException {
        TownDto mess= userService.getDescription(townDto.getTownName());
        return ResponseEntity.ok().body(mess);
    }

    @RequestMapping(value = "/findTown/{townId}", method = RequestMethod.GET)

    public ResponseEntity<TownDto> findTownById(@PathVariable("townId") long townId) throws NoSuchTownException {
        TownDto townDto= adminService.findTownById(townId);
        return ResponseEntity.ok().body(townDto);
    }

    @RequestMapping(value = "/delete/{townId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTownById(@PathVariable("townId") long townId) throws NoSuchTownException {
        adminService.deleteTown(townId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findTown")
    public ResponseEntity<TownDto> findTownByName(@RequestBody TownDto townDto) throws NoSuchTownException {
        TownDto townDtoByName = adminService.findTownByName(townDto.getTownName());
        return ResponseEntity.ok().body(townDtoByName);
    }

    @PostMapping("/newTown")
    public ResponseEntity<?> createNewTown(@RequestBody TownDto townDto) throws RepidNameOfTownException {
        adminService.addTown(townDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/changingTown/{townId}")
    public ResponseEntity<?> editTown(@PathVariable("townId") long townId,@RequestBody TownDto townDto) throws RepidNameOfTownException, NoSuchTownException {
        adminService.editTown(townId,townDto);
        return ResponseEntity.ok().build();
    }
}
