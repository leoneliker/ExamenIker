package com.example.exameniker;
/*Examen de Iker Iturralde Tejido*/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class MainActivity extends AppCompatActivity {
    public static ArrayList<Producto> lista= new ArrayList<Producto>();
    public static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = 1;
    private RecyclerView recyclerView;
    private ArrayList<Producto> datos;
    static String PRODUCTO;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_carrito:
                Log.i("My app","Boton carrito");
                Intent intentCarrito = new Intent(this,CarritoActivity.class);
                startActivity(intentCarrito);
                break;
            case R.id.action_formulario:
                Log.i("My app","Boton formulario");
                Intent intentFormulario = new Intent(this,FormularioActivity.class);
                startActivity(intentFormulario);
            default:
                return  super.onOptionsItemSelected(item);
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler);
        datos= new ArrayList<Producto>();


        for (int i=1; i<=15; i++){
            datos.add(new Producto("Producto "+i,(int) (Math.random()*100+1)+""));
        }
        AdaptadorProducto adaptadorProductos = new AdaptadorProducto(datos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adaptadorProductos);

        adaptadorProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Mi app", "Vamos al producto "+(int)(recyclerView.getChildAdapterPosition(view)+1));
                verProducto(view);
                }
        });


        adaptadorProductos.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.i("Mi app", "Añadiendo el producto "+(int)(recyclerView.getChildAdapterPosition(view)+1));
                añadirElemento(view);
                return false;
            }
        });



    }

    public void verProducto(View view){
        Intent intent=new Intent(this,ProductoActivity.class);
        Producto p = new Producto(datos.get((int)(recyclerView.getChildAdapterPosition(view))).getNombre(),datos.get((int)(recyclerView.getChildAdapterPosition(view))).getPrecio());
        Bundle b=new Bundle();
        b.putSerializable(PRODUCTO,p);
        intent.putExtras(b);
        startActivityForResult(intent,NEW_CONTACT_ACTIVITY_REQUEST_CODE);
    }

    public void añadirElemento(View view) {
        lista.add(new Producto(datos.get((int) (recyclerView.getChildAdapterPosition(view))).getNombre(), datos.get((int) (recyclerView.getChildAdapterPosition(view))).getPrecio()));
        Toast.makeText(
                getApplicationContext(),
                "Elemento añadido con exito",Toast.LENGTH_LONG
        ).show();
    }
}