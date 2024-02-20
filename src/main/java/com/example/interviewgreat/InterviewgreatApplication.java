package com.example.interviewgreat;

import com.example.interviewgreat.entity.NasabahEntity;
import com.example.interviewgreat.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class InterviewgreatApplication implements CommandLineRunner {

	@Autowired
	NasabahRepository nasabahRepository;

	public static void main(String[] args) {
		SpringApplication.run(InterviewgreatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<NasabahEntity> nasabahAll = List.of(NasabahEntity.builder()
				.name("Nama1")
				.nik("NIK1")
				.numberPhone("0812345")
				.email("Nama1@gmail.com")
				.dob("01021988")
				.build(),
				NasabahEntity.builder()
						.name("Nama2")
						.nik("NIK2")
						.numberPhone("0812346")
						.email("Nama2@gmail.com")
						.dob("01021989")
						.build());
		nasabahRepository.saveAll(nasabahAll);
	}
}
