package com.example.carlos_pc.contactos;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private DatePicker fechaNacimiento;
    private EditText telefono;
    private EditText email;
    private EditText descripcion;
    private Button btnSiguiente;
    private int dia, mes, anio;
    private  String fecha;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se Obtiene Referencia A Los Controles De Activity_Main.xml
        nombre          =   (EditText) findViewById(R.id.edtNombre);
        fechaNacimiento =   (DatePicker) findViewById(R.id.dpCalendario);
        telefono        =   (EditText) findViewById(R.id.edtTelefono);
        email           =   (EditText) findViewById(R.id.edtEmail);
        descripcion     =   (EditText) findViewById(R.id.edtDescripcion);
        btnSiguiente    =   (Button) findViewById(R.id.btnEnviar);





        //Se Implementa El Evento Click En El Botón
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se Crea El Intent Que Invoca Clase Caontacto_Datos
                Intent intent = new Intent(MainActivity.this, Contacto_Datos.class);

                //A La Variable fecha de tipo String Se Le Asigna La Fecha Obtenida en Función mostrarFecha
                fecha=mostrarFecha();

                //Se Crea La Información A Pasar Entre Intents
                Bundle bundle = new Bundle();
                bundle.putString("NOMBRE", nombre.getText().toString());
                bundle.putString("FECHA",fecha);
                bundle.putString("TELEFONO", telefono.getText().toString());
                bundle.putString("EMAIL", email.getText().toString());
                bundle.putString("DESCRIPCION", descripcion.getText().toString());

                //Se Añade Información Al Intent
                intent.putExtras(bundle);

                //Se Inicia Nueva Actividad
                startActivity(intent);
                finish();
            }
        });
    }






    //Método Para Mostrar Fecha En Formato dd/mm/aaaa
    public String mostrarFecha(){
        StringBuilder sb=new StringBuilder();
        sb.append(fechaNacimiento.getDayOfMonth()+" / "+(fechaNacimiento.getMonth()+1)+"/"+fechaNacimiento.getYear());
        return sb.toString();
    }



}
