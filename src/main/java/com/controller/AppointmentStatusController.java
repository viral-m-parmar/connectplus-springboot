package com.controller;

import java.util.List;

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

import com.entity.AppointmentStatusEntity;
import com.repository.AppointmentStatusRepository;

@RestController
@RequestMapping("/doctor")
public class AppointmentStatusController {

	@Autowired
	AppointmentStatusRepository appointmentStatusRepo;

	@PostMapping("/addAppointmentStatus")
	public ResponseEntity<?> addAppointmentStatus(@RequestBody AppointmentStatusEntity appointmentStatus) {

		appointmentStatusRepo.save(appointmentStatus);
		return ResponseEntity.ok(appointmentStatus);
	}

	@GetMapping("/getAllappointmentStatusList")
	public ResponseEntity<?> getAllAppointmentStatusList() {

		List<AppointmentStatusEntity> appointmentStatusList = appointmentStatusRepo.findAll();

		return ResponseEntity.ok(appointmentStatusList);
	}

	@GetMapping("/getAppointmentStatusDetailById/{appointmentStatusId}")
	public ResponseEntity<?> getAppointmentStatusDetailById(@PathVariable("appointmentStatusId") Integer appointmentStatusId) {

		AppointmentStatusEntity appointmentStatusDetail = appointmentStatusRepo.findById(appointmentStatusId).get();
		return ResponseEntity.ok(appointmentStatusDetail);
	}

	@DeleteMapping("/deleteAppointmentStatusById/{appointmentStatusId}")
	public ResponseEntity<?> deleteAppointmentStatusById(@PathVariable("appointmentStatusId") Integer appointmentStatusId) {

		AppointmentStatusEntity appointmentStatusDetail = appointmentStatusRepo.findById(appointmentStatusId).get();
		appointmentStatusRepo.deleteById(appointmentStatusId);
		return ResponseEntity.ok(appointmentStatusDetail);
	}
	
	@PutMapping("/updateAppointmentStatusDetail")
	public ResponseEntity<?> updateAppointmentStatusDetail(@RequestBody AppointmentStatusEntity appointmentStatusDetail) {
		
		AppointmentStatusEntity oldAppointmentStatusDetail = appointmentStatusRepo.findById(appointmentStatusDetail.getAppointmentStatusId()).get();
		
		if (appointmentStatusDetail.getStatusName() != null) {
			oldAppointmentStatusDetail.setStatusName(appointmentStatusDetail.getStatusName());
		}
		
		appointmentStatusRepo.save(oldAppointmentStatusDetail);
		return ResponseEntity.ok(oldAppointmentStatusDetail);
	}

}
