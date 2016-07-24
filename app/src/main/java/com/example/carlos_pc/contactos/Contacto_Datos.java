package com.example.carlos_pc.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class Contacto_Datos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_datos);

        //Se Localizan Los Controles De activity_main_datos.xml
        tvNombre            =(TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento   =(TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono          =(TextView) findViewById(R.id.tvTelefono);
        tvEmail             =(TextView) findViewById(R.id.tvEmail);
        tvDescripcion       =(TextView) findViewById(R.id.tvDescripcion);

        //Se Recupera La Información Pasada En El Intent
        Bundle bundle=this.getIntent().getExtras();

        //Se Pasan Los Datos Ingresados
        tvNombre.setText(bundle.getString("NOMBRE"));
        tvTelefono.setText(bundle.getString("TELEFONO"));
        tvEmail.setText(bundle.getString("EMAIL"));
        tvDescripcion.setText(bundle.getString("DESCRIPCION"));
    }


}
