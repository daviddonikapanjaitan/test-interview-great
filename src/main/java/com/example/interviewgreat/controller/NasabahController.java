package com.example.interviewgreat.controller;

import com.example.interviewgreat.dto.NasabahResp;
import com.example.interviewgreat.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nasabah")
public class NasabahController {

    @Autowired
    NasabahService nasabahService;

    @GetMapping("")
    public ResponseEntity<Object> getNasabahData(){
        return nasabahService.getAllNasabahData();
    }

    @PostMapping
    public ResponseEntity<Object> createNewNasabah(
            @RequestBody NasabahResp nasabahResp
            ){
        return nasabahService.createNewNasabah(nasabahResp);
    }
}
