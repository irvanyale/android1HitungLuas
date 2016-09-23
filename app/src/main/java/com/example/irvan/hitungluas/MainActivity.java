package com.example.irvan.hitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        edtPanjang = (EditText)findViewById(R.id.edt_panjang);
        edtLebar = (EditText)findViewById(R.id.edt_lebar);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        txtLuas = (TextView)findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

                if  (lebar.matches("^\\.$") || panjang.matches("^\\.$")){
                    Toast.makeText(getApplicationContext(), "Harap Mengisi Dengan Format Angka", Toast.LENGTH_SHORT).show();
                }
                else if (panjang.isEmpty() && lebar.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Harap Mengisi Form Panjang dan Lebar", Toast.LENGTH_SHORT).show();
                }
                else if (panjang.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Harap Mengisi Form Panjang", Toast.LENGTH_SHORT).show();
                }
                else if  (lebar.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Harap Mengisi Form Lebar", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);
                    double luas = p * l;
                    txtLuas.setText("Luas : "+luas);
                }
            }
        });
    }
}
