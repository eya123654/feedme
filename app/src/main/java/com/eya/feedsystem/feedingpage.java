package com.eya.feedsystem;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.ktx.Firebase;

public class feedingpage extends AppCompatActivity {

    Button btnUpdata1;
    Button btnDowndata2;
    // Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://feedaut-2321e-default-rtdb.europe-west1.firebasedatabase.app/";

    // Declaring String variables to store name & phone number get from EditText.

    Firebase firebase;

    DatabaseReference databaseReference;

    // Root Database Name for Firebase Database.
    public static final String Database_Path = "distance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedingpage);

        Firebase.setAndroidContext(feedingpage.this);

        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path).child("feed");

        btnUpdata1 = (Button) findViewById(R.id.btnUp);
        btnDowndata2 = (Button) findViewById(R.id.btnDown);

        btnUpdata1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Objectfb objectfb = new Objectfb();


                // Adding name into class function object.
                objectfb.setCount(1);

                // Adding phone number into class function object.

                // Getting the ID from firebase database.
                String CountRecordIDFromServer = databaseReference.getKey();

                // Adding the both name and number values using student details class object using ID.
                databaseReference.child(CountRecordIDFromServer).setValue(objectfb);

                // Showing Toast message after successfully data submit.
                Toast.makeText(feedingpage.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();

            }
        });
        btnDowndata2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Objectfb objectfb = new Objectfb();


                // Adding name into class function object.
                objectfb.setCount(0);

                // Adding phone number into class function object.

                // Getting the ID from firebase database.
                String CountRecordIDFromServer = databaseReference.getKey();

                // Adding the both name and number values using student details class object using ID.
                databaseReference.child(CountRecordIDFromServer).setValue(objectfb);

                // Showing Toast message after successfully data submit.
                Toast.makeText(feedingpage.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();

            }
        });

    }


}
/*import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class feedingpage extends AppCompatActivity {
    Button btnUpdata1;
    Button btnDowndata2;
    EditText txtAddress;
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    Objectfb countinfo;
    int variable=0;
String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedingpage);
        btnUpdata1 = (Button) findViewById(R.id.btnUp);
        btnDowndata2 = (Button) findViewById(R.id.btnDown);
        txtAddress = (EditText) findViewById(R.id.ipAddress);
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("distance").child("feed");

        // initializing our object
        // class variable.
        countinfo = new Objectfb();


        btnUpdata1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //variable++;
                databaseReference = FirebaseDatabase.getInstance().getReference().child("distance").child("feed");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        variable = (int) dataSnapshot.getValue();
                        Log.e("test", "onDataChange: " + status);
                        String status = String.valueOf(variable++);

                        txtAddress.setText(status);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    }
                });
            }
        });
       /* btnDowndata2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variable--;
            });*/



