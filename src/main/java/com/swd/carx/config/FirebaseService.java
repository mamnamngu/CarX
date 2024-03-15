package com.swd.carx.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseService {

    public static void writeToDatabase() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");
        ref.setValue("This is a test value", (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.out.println("Data could not be saved " + databaseError.getMessage());
            } else {
                System.out.println("Data saved successfully.");
            }
        });
    }
}