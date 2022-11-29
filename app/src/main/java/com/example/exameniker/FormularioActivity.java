package com.example.exameniker;
/*Examen de Iker Iturralde Tejido*/
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {
    Spinner spinner;
    String valor;
    RadioGroup radio;
    RadioButton op1,op2,op3,op4,op5;
    String aux,aux1="",aux2="",aux3="",aux4="",aux5="",aux6="";
    int marca;
    CheckBox ch1,ch2,ch3,ch4,ch5,ch6;
    String resultado="";
    Button botonE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        spinner=findViewById(R.id.spinner);
        radio=findViewById(R.id.radiogroup);
        op1=findViewById(R.id.op1);
        op2=findViewById(R.id.op2);
        op3=findViewById(R.id.op3);
        op4=findViewById(R.id.op4);
        op5=findViewById(R.id.op5);

        ch1=findViewById(R.id.Chk1);
        ch2=findViewById(R.id.Chk2);
        ch3=findViewById(R.id.Chk3);
        ch4=findViewById(R.id.Chk4);
        ch5=findViewById(R.id.Chk5);
        ch6=findViewById(R.id.Chk6);

        botonE=findViewById(R.id.enviar);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.valores, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                valor = spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                marca=radio.getCheckedRadioButtonId();

                switch (marca){
                    case R.id.op1:
                        aux=op1.getText().toString();
                        break;
                    case R.id.op2:
                        aux=op2.getText().toString();
                        break;
                    case R.id.op3:
                        aux=op3.getText().toString();
                        break;
                    case R.id.op4:
                        aux=op4.getText().toString();
                        break;
                    case R.id.op5:
                        aux=op5.getText().toString();
                        break;
                }
            }
        });
        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked){
                    aux1=ch1.getText().toString();
                }
                else{
                    aux1="";
                }
            }
        });
        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked){
                    aux2=ch2.getText().toString();
                }
                else{
                    aux2="";
                }
            }
        });
        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked){
                    aux3=ch3.getText().toString();
                }
                else{
                    aux3=" ";
                }
            }
        });
        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked){
                    aux4=ch4.getText().toString();
                }
                else{
                    aux4="";
                }
            }
        });
        ch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked){
                    aux5=ch5.getText().toString();
                }
                else{
                    aux5="";
                }
            }
        });
        ch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isChecked = ((CheckBox)view).isChecked();

                if (isChecked){
                    aux6=ch6.getText().toString();
                }
                else{
                    aux6="";
                }
            }
        });

        botonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        getApplicationContext(),
                        "Se ha enviado el formulario",Toast.LENGTH_LONG
                ).show();
                String auxC[] = {aux1,aux2,aux3,aux4,aux5,aux6};
                int cont=0;
                resultado=("Tu rango de edad es "+valor+", te gustó "+aux+" sobre 5 la aplicación.\n"+"Compras: ");
                Log.i("My app",resultado);
                for (int i=0;i<auxC.length;i++){
                    if(auxC[i]!="" && cont<3){
                        cont++;
                        Log.i("My app",auxC[i]);
                    }
                }
            }

        });

    }
}