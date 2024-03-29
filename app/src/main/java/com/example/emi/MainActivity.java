package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText interest;
    EditText principle;
    EditText installments;
    Button btnCalc;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principle=findViewById(R.id.txtLoanAmt);
        interest=findViewById(R.id.txtInterestRate);
        installments=findViewById(R.id.txtInstallment);
        txtResult=findViewById(R.id.txtResult);
        btnCalc=findViewById(R.id.btnCalculate);
        btnCalc.setOnClickListener(this);
    }


    public boolean validation(){
        if(principle.getText().toString().trim().isEmpty() || interest.getText().toString().trim().isEmpty()
        || installments.getText().toString().trim().isEmpty()){
            return  true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void onClick(View v) {

        if(!validation()) {
        float emi;
        float prin = Float.parseFloat(principle.getText().toString());
        float inter = Float.parseFloat(interest.getText().toString());
        float install = Float.parseFloat(installments.getText().toString());


            emi = res(prin, inter, install);

            txtResult.setText(String.format("EMI =%.2f", emi));


        }

        else {
            Toast.makeText(this, "Please fill the details", Toast.LENGTH_LONG).show();
        }
    }

    static float res (float princ, float rate, float time){
        float emi, r,t, f1;
        r=rate/100/12;
        t=time*12;
        f1 = (float)Math.pow(1+r,t);

        emi=(princ*r*f1)/
                (f1-1);

        return emi;


    }
}
