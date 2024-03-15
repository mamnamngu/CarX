package com.swd.carx.controller.tournamentManagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.swd.carx.view.CarProgressDTO;

@RestController
public class CarProgressController {

	@PostMapping("/carProgress")
	public ResponseEntity<CarProgressDTO> updateProgress(@RequestBody CarProgressDTO progress){
		try {		
			System.out.println(progress);
			writeToDatabase(progress);
//			TestriteToDatabase();
			return ResponseEntity.ok(progress);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new progress for carInRace: " + progress.getCarRaceId()).build();
		}
	}
	
	 private void writeToDatabase(CarProgressDTO progress) {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("car-progress");
        DatabaseReference ref = dbRef.child(String.valueOf(progress.getCarRaceId()));
        ref.setValue(progress, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.out.println("Data could not be saved " + databaseError.getMessage());
            } else {
                System.out.println("Data saved successfully.");
            }
        });
    }
	 
	 private void TestriteToDatabase() {
		long testCarRaceId = 4;
		long testProgress = 80;
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("car-progress");
        DatabaseReference ref = dbRef.child(String.valueOf(testCarRaceId));
        ref.setValue(testProgress, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.out.println("Data could not be saved " + databaseError.getMessage());
            } else {
                System.out.println("Data saved successfully.");
            }
        });
    }
}
