package com.example.interviewgreat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NasabahListResp {

    private List<NasabahData> nasabahList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class NasabahData {
        private String nama;
        private String nik;
        private String noHp;
        private String email;
        private String dob;
    }
}
