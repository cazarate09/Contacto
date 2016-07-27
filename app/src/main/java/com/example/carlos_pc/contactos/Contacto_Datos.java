package com.example.carlos_pc.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contacto_Datos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private Button   btnEditar;

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
        btnEditar           =(Button)   findViewById(R.id.btnEditar);



        //Se Recupera La Información Pasada En El Intent
        Bundle bundle=this.getIntent().getExtras();

        //Se Pasan Los Datos Ingresados
        tvNombre.setText(bundle.getString("NOMBRE"));
        tvFechaNacimiento.setText(bundle.getString("FECHA"));
        tvTelefono.setText(bundle.getString("TELEFONO"));
        tvEmail.setText(bundle.getString("EMAIL"));
        tvDescripcion.setText(bundle.getString("DESCRIPCION"));

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Contacto_Datos.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
