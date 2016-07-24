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
    private EditText fecha;
    //private static DatePicker fechaNacimiento;
    private EditText telefono;
    private EditText email;
    private EditText descripcion;
    private Button btnFecha;
    private Button btnSiguiente;
    private int dia, mes, anio;
    private static final int TIPO_DIALOGO=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se Obtiene Referencia A Los Controles De Activity_Main.xml
        nombre          =   (EditText) findViewById(R.id.edtNombre);
        fecha           =   (EditText) findViewById(R.id.edtFecha);
        btnFecha        =   (Button) findViewById(R.id.btnFecha);
        telefono        =   (EditText) findViewById(R.id.edtTelefono);
        email           =   (EditText) findViewById(R.id.edtEmail);
        descripcion     =   (EditText) findViewById(R.id.edtDescripcion);
        btnSiguiente    =   (Button) findViewById(R.id.btnEnviar);

        //Se Obtiene Fecha Actual Del Sistema
        Calendar calendario=Calendar.getInstance();
        dia=calendario.get(Calendar.DAY_OF_MONTH);
        mes=calendario.get(Calendar.MONTH);
        anio=calendario.get(Calendar.YEAR);
        mostrarFecha();

        oyenteSelectorFecha=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                anio =year;
                mes=monthOfYear;
                dia=dayOfMonth;
                mostrarFecha();
            }
        };

        //Se Implementa El Evento Click En El Botón
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se Crea El Intent Que Invoca Clase Caontacto_Datos
                Intent intent = new Intent(MainActivity.this, Contacto_Datos.class);

                //Se Crea La Información A Pasar Entre Intents
                Bundle bundle = new Bundle();
                bundle.putString("NOMBRE", nombre.getText().toString());
                bundle.putString("FECHA",fecha.getText().toString());
                bundle.putString("TELEFONO", telefono.getText().toString());
                bundle.putString("EMAIL", email.getText().toString());
                bundle.putString("DESCRIPCION", descripcion.getText().toString());

                //Se Añade Información Al Intent
                intent.putExtras(bundle);

                //Se Inicia Nueva Actividad
                startActivity(intent);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id)
        {
            case 0:
                    return new DatePickerDialog(this,oyenteSelectorFecha,dia,mes,anio);
        }
        return null;
    }


    public void mostrarCalendario(View control){
        showDialog(TIPO_DIALOGO);
    }

    //Método Para Mostrar Fecha En Formato dd/mm/aaaa
    public void mostrarFecha(){
        fecha.setText(dia+" / "+(mes+1)+" / "+anio);
    }



}
