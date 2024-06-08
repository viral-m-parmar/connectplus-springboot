package com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AppointmentEntity;
import com.repository.AppointmentRepository;

@RestController
@RequestMapping("/doctor")
public class AppointmentController {

	@Autowired
	AppointmentRepository appointmentRepo;

	@PostMapping("/addAppointment")
	public ResponseEntity<?> addAppointment(@RequestBody AppointmentEntity appointment) {

		appointmentRepo.save(appointment);
		return ResponseEntity.ok(appointment);
	}

	@GetMapping("/getAllAppointments")
	public ResponseEntity<?> getAllAppointments() {

		List<AppointmentEntity> appointments = appointmentRepo.findAll();
		return ResponseEntity.ok(appointments);
	}

	@GetMapping("/getAppointmentById/{appointmentId}")
	public ResponseEntity<?> getAppointmentById(@PathVariable("appointmentId") Integer appointmentId) {

		AppointmentEntity appointment = appointmentRepo.findById(appointmentId).get();
		return ResponseEntity.ok(appointment);
	}

	@DeleteMapping("/deleteAppointmentById/{appointmentId}")
	public ResponseEntity<?> deleteAppointmentById(@PathVariable("appointmentId") Integer appointmentId) {

		AppointmentEntity appointment = appointmentRepo.findById(appointmentId).get();

		appointmentRepo.deleteById(appointmentId);
		return ResponseEntity.ok(appointment);	
	}
	
	@PutMapping("/updateAppointment")
	public ResponseEntity<?> updateAppointment(@RequestBody AppointmentEntity appointment){
		
		AppointmentEntity oldAppointment = appointmentRepo.findById(appointment.getAppointmentId()).get();
		
		if(appointment.getDoctor() != null) {
			oldAppointment.setDoctor(appointment.getDoctor());
		}
		if(appointment.getPatient() != null) {
			oldAppointment.setPatient(appointment.getPatient());
		}
		if(appointment.getRateList() != null) {
			oldAppointment.setRateList(appointment.getRateList());
		}
		if(appointment.getAppointmentDate() != null) {
			oldAppointment.setAppointmentDate(appointment.getAppointmentDate());
		}
		if(appointment.getCreatedDate() != null) {
			oldAppointment.setCreatedDate(appointment.getCreatedDate());
		}
		if(appointment.getCreatedBy() != null) {
			oldAppointment.setCreatedBy(appointment.getCreatedBy());
		}
		if(appointment.getAppointmentStatus() != null) {
			oldAppointment.setAppointmentStatus(appointment.getAppointmentStatus());
		}
		
		appointmentRepo.save(oldAppointment);
		return ResponseEntity.ok(oldAppointment);
	}
	
	// Todays appointment
		@GetMapping("/todaysappointment")
		public ResponseEntity<?> todaysAppointment() {

			LocalDate today = LocalDate.now();

			List<AppointmentEntity> appointments = appointmentRepo.findAll();

			List<AppointmentEntity> todaysAppointments = appointments.stream().filter(appointment -> {
				LocalDate appointmentDate = LocalDate.parse(appointment.getAppointmentDate(),
						DateTimeFormatter.ofPattern("dd-MM-yy"));
				return appointmentDate.equals(today);
			}).collect(Collectors.toList());

			return ResponseEntity.ok(todaysAppointments);

		}
		
		// Previous appointment list
		@GetMapping("/previousappointment")
		public ResponseEntity<?> previousAppointment() {

			LocalDate today = LocalDate.now();

			List<AppointmentEntity> appointments = appointmentRepo.findAll();

			List<AppointmentEntity> previousAppointments = appointments.stream().filter(appointment -> {
				LocalDate appointmentDate = LocalDate.parse(appointment.getAppointmentDate(),
						DateTimeFormatter.ofPattern("dd-MM-yy"));
				return appointmentDate.isBefore(today);
			}).collect(Collectors.toList());

			return ResponseEntity.ok(previousAppointments);
		}
		

		// For Upcomming Appointment
		@GetMapping("/upcommingappointment")
		public ResponseEntity<?> upCommingAppointment() {

			LocalDate today = LocalDate.now();

			List<AppointmentEntity> appointments = appointmentRepo.findAll();

			List<AppointmentEntity> upcomingAppointments = appointments.stream().filter(appointment -> {
				LocalDate appointmentDate = LocalDate.parse(appointment.getAppointmentDate(),
						DateTimeFormatter.ofPattern("dd-MM-yy"));
				return appointmentDate.isAfter(today);
			}).collect(Collectors.toList());

			return ResponseEntity.ok(upcomingAppointments);
		}


}
