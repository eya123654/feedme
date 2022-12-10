package com.eya.feedsystem;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class camPage extends AppCompatActivity {
TextView distance;
DatabaseReference dref;
Button dis;
String status;
double firebaseValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_page);
        distance=(TextView) findViewById(R.id.distance);
        dis=(Button) findViewById(R.id.btncam);

       //FirebaseApp.initializeApp(this);
        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dref= FirebaseDatabase.getInstance().getReference().child("distance").child("float");
                dref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        firebaseValue=(double) dataSnapshot.getValue();
                        Log.e("test", "onDataChange: "+status);
                        status=String.valueOf(firebaseValue);

                        distance.setText(status);

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    }
                });
            }
        });



    }
}