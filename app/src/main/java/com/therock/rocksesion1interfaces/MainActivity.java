package com.therock.rocksesion1interfaces;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String nombre, apellido, correo, numero, sexo, hobbies = " ", ciudad;
    private EditText eNombre, eApellido, eCorreo, eNumero;
    private TextView tInformacion;
    private RadioButton rMasculino, rFemenino;
    private CheckBox cine, comer, dormir, bailar;
    private Spinner sCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = (EditText) findViewById(R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        tInformacion = (TextView) findViewById(R.id.tInformacion);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eNumero = (EditText) findViewById(R.id.eNumero);
        cine = (CheckBox) findViewById(R.id.cCine);
        comer = (CheckBox) findViewById(R.id.cComer);
        bailar = (CheckBox) findViewById(R.id.cBailar);
        dormir = (CheckBox) findViewById(R.id.cDormir);
        rMasculino = (RadioButton) findViewById(R.id.rMasculino);
        rFemenino = (RadioButton) findViewById(R.id.rFemenino);
        sCiudades = (Spinner) findViewById(R.id.sCiudades);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCiudades.setAdapter(adapter);

        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void onClick(View view) {
        nombre = eNombre.getText().toString();
        apellido = eApellido.getText().toString();
        correo = eCorreo.getText().toString();
        numero = eNumero.getText().toString();

        if (cine.isChecked()) {
            hobbies += " cine  ";
        }
        if (comer.isChecked()) {
            hobbies += " comer  ";
        }
        if (dormir.isChecked()) {
            hobbies += " dormir  ";
        }
        if (bailar.isChecked()) {
            hobbies += " bailar  ";
        }
        if (rMasculino.isChecked()) {
            sexo = "Masculino";
        } else {
            sexo = "Femenino";

        }
        tInformacion.setText(" Nombre: " + nombre + "\n Apellido: " + apellido + "\n Correo: " + correo + "\n Numero: " + numero + "\n Sexo: " + sexo + "\n Hobbies: " + hobbies + "\n Ciudad: " + ciudad);
    }
}

