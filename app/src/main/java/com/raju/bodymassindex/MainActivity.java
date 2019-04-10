package com.raju.bodymassindex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText weightText;
    private EditText heightText;
    private Button BMIComputeBtn;
    private EditText BMIText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightText = findViewById(R.id.activity_main_weight_text);
        heightText = findViewById(R.id.activity_main_height_text);
        BMIComputeBtn = findViewById(R.id.activity_main_compute_BMI_btn);
        BMIText = findViewById(R.id.activity_main_BMI_value);

        BMIComputeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BodyDetail bodyDetail = new BodyDetail(Double.parseDouble(heightText.getText().toString()), Double.parseDouble(weightText.getText().toString()));
                computeBMI(bodyDetail);
            }
        });
    }

    private void computeBMI(BodyDetail bodyDetail){
        double BMIValue = bodyDetail.getWeight()/(bodyDetail.getHeight() * bodyDetail.getHeight());
        BMIText.setText(Double.toString(BMIValue));
        showBMIDetail(BMIValue);
    }

    private void showBMIDetail(Double BMIValue){
        String BMISummary = "";
        if(BMIValue < 18.5){
            BMISummary = "underweight";
        }
        else if (BMIValue >= 18.5 && BMIValue < 25){
            BMISummary = "normal weight";
        }
        else if (BMIValue >= 25 && BMIValue < 30){
            BMISummary = "overweight";
        }
        else{
            BMISummary = "obesity";
        }
        Toast.makeText(getApplicationContext(), "You are "+ BMISummary, Toast.LENGTH_SHORT).show();
    }
}
