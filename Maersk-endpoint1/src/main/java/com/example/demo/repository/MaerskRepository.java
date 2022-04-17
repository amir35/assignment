package com.example.demo.repository;

import com.example.demo.dto.Booking;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaerskRepository extends JpaRepository<Booking, UUID> {

}
