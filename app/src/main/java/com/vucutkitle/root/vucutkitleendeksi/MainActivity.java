package com.vucutkitle.root.vucutkitleendeksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtYas, edtKilo, edtBoy;
    private TextView txtSonuc, txtSonucSozel;
    private Button sonucuHesapla;

    private float kilo, boy, sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        registerHandler();

    }

    private void init(){
        edtBoy = findViewById(R.id.edt_boy_girdi);
        edtKilo = findViewById(R.id.edt_kilo_girdi);
        edtYas =findViewById(R.id.edt_yas_girdi);

        txtSonuc = findViewById(R.id.txt_sonuc);
        txtSonucSozel = findViewById(R.id.txt_sonuc_sozel);

        sonucuHesapla = findViewById(R.id.btn_endeks_hesapla);
    }

    private void registerHandler(){
        sonucuHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty(edtBoy) && !isEmpty(edtKilo) && !isEmpty(edtYas)){
                    kilo = Float.parseFloat(edtKilo.getText().toString());
                    boy = Float.parseFloat(edtBoy.getText().toString());
                    sonuc = kilo/((boy / 100) * (boy / 100));

                    txtSonuc.setText(MainActivity.this.getString(R.string.vucut_kitle_endeksiniz, sonuc));

                    txtSonucSozel.setText(sonucuDegerlendir(sonuc));

                }else {
                    Toast.makeText(MainActivity.this,"Lutfen tum alanlari doldurunuz",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean isEmpty(EditText edtText) {
        return edtText.getText().toString().trim().length() == 0;
    }

    private String sonucuDegerlendir(float hesaplananSonuc){
        String sozelSonuc;
        if (hesaplananSonuc <= 18.5){
            sozelSonuc = "Zayifsiniz";
        }else if (18.5 <= hesaplananSonuc && hesaplananSonuc <= 29.9){
            sozelSonuc = "Kilonuz Normal";
        }else {
            sozelSonuc = "Asiri kilolu";
        }
        return sozelSonuc;
    }

}
