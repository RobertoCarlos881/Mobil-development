package com.example.fragmentoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    int i, j,count=1,j_ant=0,i_ant=0;
    EditText jtxt;
    TextView tct,tct2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tct=findViewById(R.id.tct);
        tct2=findViewById(R.id.tct2);
        btn1= findViewById(R.id.btn);
        jtxt=findViewById(R.id.xedt1);
        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tct.setVisibility(View.INVISIBLE);
                tct2.setVisibility(View.VISIBLE);
                btn1.setVisibility(View.INVISIBLE);
                jtxt.setVisibility(View.INVISIBLE);

                FragmentManager manager= getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();

                BlankFragment blankFragment=new BlankFragment();
                transaction.replace(R.id.linear,blankFragment);
                transaction.commit();


                int val = Integer.parseInt(jtxt.getText().toString());
                int n = val; // tamaño de la matriz
                tct2.setText("Tamaño:"+String.valueOf(n));
                int i_ant = 0;  // variable i temporal
                int j_ant = 0; // variable j temporal

                int punto_ini = n/2; // para el primer numero.

                int[][] matriz_magica = new int [n+1][n+1]; // creo la matriz magica

                int temp = 1; // lleva la cuenta de los numeros que se van adicionando a la matriz

                //lleno la matriz de ceros
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        matriz_magica[i][j] = 0;
                    }
                }

                i = 0;
                j = punto_ini; //valor de la mitad donde empieza la matriz

                while (temp != (n*n)+1){
                    if(matriz_magica[i][j] == 0) {// valido posicion vacia
                        matriz_magica[i][j] = temp;
                    }else{
                        i = i_ant +1;
                        j = j_ant;
                        matriz_magica[i][j]=temp;
                    }

                    i_ant = i;
                    j_ant = j;

                    temp++;
                    j++;
                    i--;
                    if(i<0 && j==n){ // esquina superior derecha
                        i = n -1;
                        j = 0;
                    }else if( i < 0){ // fila -1
                        i = i + n;
                    }else if(j==n){ //columna igual a n
                        j = 0;
                    }
                }
                int suma =0;
                for(i=0;i<val;i++){
                    suma=suma+matriz_magica[0][i];
                }
                Log.i("xdddd",String.valueOf(suma));
                for( i = 0; i < val+1; i++)
                {
                    ArrayList<String> elementos = new ArrayList<String>();
                    for( j = 0; j < val+1; j++)
                    {
                        Log.i("aaa",String.valueOf(matriz_magica[i][j]));
                        if(i==val || j==val){

                            elementos.add(".            "+String.valueOf(suma));

                        }else {
                            elementos.add("*            " + String.valueOf(matriz_magica[i][j]));
                        }
                    }
                    if(i==val){
                        tabla.agregarFilaTabla(elementos,1);
                    }else{
                        tabla.agregarFilaTabla(elementos,0);
                    }

                }
            }
        });


    }
}