package com.example.demo.hostelRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Studentcontact;

public interface StudentContactRepo extends JpaRepository<Studentcontact, Integer>{

    Studentcontact findByEmail(String email);

}
