package com.example.faccidannymendozapractica1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.faccidannymendozapractica1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button convertir= null;
    EditText cantidad= null;
    TextView resultado = null;
    Spinner spincl=null;
    private Log log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log.e("Aplicación Movil I","Mendoza Macías Danny");

        convertir=(Button)findViewById(R.id.btntem);
        cantidad=(EditText)findViewById(R.id.cant);
        resultado=(TextView)findViewById(R.id.Resu);
        spincl=(Spinner)findViewById(R.id.spinla);

        String[]op={"Seleccione una opción","°C a °F", "°F a °C"};
        ArrayAdapter<String> adapter=new
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op);
        spincl.setAdapter(adapter);

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidad.getText().toString().equals("")){
                    Toast msg= Toast.makeText(getApplicationContext(),"Escribe una cantidad",Toast.LENGTH_SHORT);
                    msg.show();
                } else {
                    Double c= Double.parseDouble(cantidad.getText().toString());
                    Double res=null;
                    int select=spincl.getSelectedItemPosition();

                    switch (select) {
                        case 0:
                            res=0.0;
                            Toast.makeText(getApplicationContext(),"Seleccione una opcion",Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            res=1.8*c+32;
                            break;
                        case 2:
                            res=(c-32)/1.8;
                            break;
                    }
                    resultado.setText(res.toString());
                }
            }
        });
    }
}