package com.example.interviewgreat.service;

import com.example.interviewgreat.dto.NasabahListResp;
import com.example.interviewgreat.dto.NasabahResp;
import com.example.interviewgreat.entity.NasabahEntity;
import com.example.interviewgreat.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NasabahService {

    @Autowired
    NasabahRepository nasabahRepository;

    public ResponseEntity<Object> getAllNasabahData(){
        List<NasabahEntity> nasabahEntityList = nasabahRepository.findAll();

        NasabahListResp nasabahListResp = NasabahListResp.builder()
                .nasabahList(nasabahEntityList.stream().map(nasabahEntity ->
                        NasabahListResp.NasabahData.builder()
                                .nama(nasabahEntity.getName())
                                .nik(nasabahEntity.getNik())
                                .noHp(nasabahEntity.getNumberPhone())
                                .email(nasabahEntity.getEmail())
                                .dob(nasabahEntity.getDob())
                                .build()
                ).collect(Collectors.toList()))
                .build();

        return new ResponseEntity<>(nasabahListResp, HttpStatus.OK);
    }

    public ResponseEntity<Object> createNewNasabah(NasabahResp nasabahResp){
        try{
            nasabahRepository.save(NasabahEntity.builder()
                    .nik(nasabahResp.getNik())
                    .name(nasabahResp.getNama())
                    .numberPhone(nasabahResp.getNoHp())
                    .email(nasabahResp.getEmail())
                    .dob(nasabahResp.getDob())
                    .build());
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
