package com.example.interviewgreat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NasabahResp {

    private String nama;
    private String nik;
    private String noHp;
    private String email;
    private String dob;
}
