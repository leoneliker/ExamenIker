package com.example.exameniker;
/*Examen de Iker Iturralde Tejido*/
import static com.example.exameniker.MainActivity.PRODUCTO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProductoActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    public static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = -1;
    private TextView mNombre;
    private TextView mPrecio;
    Button botonA;
    Button botonV;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        mNombre = findViewById(R.id.nombreTV);
        mPrecio = findViewById(R.id.precioTV);
        botonA = findViewById(R.id.añadir);
        botonV = findViewById(R.id.volver);
        Intent intent= getIntent();
        Bundle b= intent.getExtras();
        Producto p=(Producto) b.getSerializable(PRODUCTO);
        mNombre.setText(p.getNombre());
        mPrecio.setText(p.getPrecio());


        botonA.setOnClickListener(view -> {
            MainActivity.lista.add(p);
            Toast.makeText(
                    getApplicationContext(),
                    "Elemento añadido con exito",Toast.LENGTH_LONG
            ).show();
            finish();
        });
        botonV.setOnClickListener(view -> {
            finish();
        });

    }
}