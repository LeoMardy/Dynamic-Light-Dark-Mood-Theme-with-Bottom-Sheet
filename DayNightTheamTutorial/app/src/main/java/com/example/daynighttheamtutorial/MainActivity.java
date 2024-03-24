package com.example.daynighttheamtutorial;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    Switch switcher;
    Button showSheet;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showSheet = findViewById(R.id.showSheet);
        switcher = findViewById(R.id.switcher);
        switcher.setText("Light Mood");
        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isActive) {

                if (isActive){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    switcher.setText("Night Mood");
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    switcher.setText("Light Mood");
                }
            }
        });

        showSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this,R.style.BottomSheetTheme);
                View myView = LayoutInflater.from(MainActivity.this).inflate(R.layout.bottom_sheet_layout,null,false);
                bottomSheetDialog.setContentView(myView);
                bottomSheetDialog.show();

                LinearLayout shareID = myView.findViewById(R.id.share_ID);
                LinearLayout locationID = myView.findViewById(R.id.location_ID);
                LinearLayout callID = myView.findViewById(R.id.call_ID);
                LinearLayout uploadID = myView.findViewById(R.id.upload_ID);
                MaterialButton sheetButton = myView.findViewById(R.id.sheetButton);


                shareID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(MainActivity.this, "Share is clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                locationID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(MainActivity.this, "Location is clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                callID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(MainActivity.this, "Call is clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                uploadID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(MainActivity.this, "Upload is clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                sheetButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                       startActivity(new Intent(MainActivity.this,SecondActivity.class));
                    }
                });

                bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        Toast.makeText(MainActivity.this, "Dismiss is Called", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}