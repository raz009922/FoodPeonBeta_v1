package com.example.dcastalia.rrrrrr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lamudi.phonefield.PhoneEditText;
import com.lamudi.phonefield.PhoneInputLayout;


public class LibPhoneNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_phone_number);

        final PhoneInputLayout phoneInputLayout = (PhoneInputLayout) findViewById(R.id.phone_input_layout);
        final PhoneEditText phoneEditText = (PhoneEditText) findViewById(R.id.edit_text);
        final Button button = (Button) findViewById(R.id.submit_button);

        // you can set the hint as follows
        phoneInputLayout.setHint(R.string.phone_hint);
        phoneEditText.setHint(R.string.phone_hint);

// you can set the default country as follows
        phoneInputLayout.setDefaultCountry("DE");
        phoneEditText.setDefaultCountry("FR");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = true;

                // checks if the field is valid
                if (phoneInputLayout.isValid()) {
                    phoneInputLayout.setError(null);
                    Intent intent = new Intent(LibPhoneNumber.this,Food_Activity.class);
                    startActivity(intent);
                } else {
                    // set error message
                    phoneInputLayout.setError(getString(R.string.invalid_phone_number));
                    valid = false;
                }

                if (phoneEditText.isValid()) {
                    phoneEditText.setError(null);
                    Intent intent = new Intent(LibPhoneNumber.this,Food_Activity.class);
                    startActivity(intent);
                } else {
                    phoneEditText.setError(getString(R.string.invalid_phone_number));
                    valid = false;
                }

                if (valid) {
                    Toast.makeText(LibPhoneNumber.this, R.string.valid_phone_number, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LibPhoneNumber.this, R.string.invalid_phone_number, Toast.LENGTH_LONG).show();
                }

                // Return the phone number as follows
                String phoneNumber = phoneInputLayout.getPhoneNumber();
            }
        });


    }
}
