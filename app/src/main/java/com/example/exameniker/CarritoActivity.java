package com.example.exameniker;
/*Examen de Iker Iturralde Tejido*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CarritoActivity extends AppCompatActivity {
    TextView resultado;
    int total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        Log.i("My app", "Lista de la compra");
        resultado=findViewById(R.id.resul);
        for (Producto p : MainActivity.lista) {
            resultado.append(p.getNombre());
            resultado.append("     ");
            resultado.append(p.getPrecio());
            total+=Integer.parseInt(p.getPrecio());
            resultado.append("€\n");
            Log.i("My app", p.getNombre()+" "+p.getPrecio()+"€");
        }


        resultado.append("El precio total es "+ total+"€");
        Log.i("My app","El precio total es "+ total+"€");
    }
}