package com.jp.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Producto;

import static com.jp.primerparcial.MainActivity.productos;

public class Listado extends AppCompatActivity implements View.OnClickListener {
    public static ArrayList<Producto> products = new ArrayList();
    private Button btnIva;
    private Button btnNoIva;
    private Button btnCostoso;
    private Button btnBarato;
    private Button btnPromedio;
    private FloatingActionButton btnAddConsulta;
    private ListView listaConsultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        MainActivity main=new MainActivity();
        products= productos;
        btnIva=findViewById(R.id.btnIva);
        btnNoIva=findViewById(R.id.btnNoIva);
        btnCostoso=findViewById(R.id.btnCostoso);
        btnBarato=findViewById(R.id.btnBarato);
        btnPromedio=findViewById(R.id.bntPromedio);
        btnAddConsulta=findViewById(R.id.btnAddConsulta);
        listaConsultas=findViewById(R.id.listConsulta);
        btnIva.setOnClickListener(this);
        btnNoIva.setOnClickListener(this);
        btnCostoso.setOnClickListener(this);
        btnBarato.setOnClickListener(this);
        btnPromedio.setOnClickListener(this);
        btnAddConsulta.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCostoso) {
            ArrayAdapter<Producto> adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,productosCostosos(products));
            listaConsultas.setAdapter(adapter);

        } if (v.getId() == R.id.btnBarato) {
            ArrayAdapter<Producto> adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,productosBaratos(products));
            listaConsultas.setAdapter(adapter);

        }
        if (v.getId() == R.id.btnIva) {
            ArrayAdapter<Producto> adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,conIva(products));
            listaConsultas.setAdapter(adapter);

        }
        if (v.getId() == R.id.btnNoIva) {
            ArrayAdapter<Producto> adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,sinIva(products));
            listaConsultas.setAdapter(adapter);

        }
        if (v.getId() == R.id.bntPromedio) {
            ArrayAdapter<Producto> adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,promedio(products));
            listaConsultas.setAdapter(adapter);

        }

    }
    public List<String> conIva(List<Producto> list){
        ArrayList<String> valores = new ArrayList();
        for (int i=0;i<list.size();i++){
            if (products.get(i).getIva().equals("IVA")){
                valores.add("Codigo: "+list.get(i).getCodigo()+" Nombre: "+list.get(i).getNombre()+" $ " +
                        " "+list.get(i).getValor()+" "+list.get(i).getIva());
            }

        }
        return valores;
    }
    public List<String> sinIva(List<Producto> list){
        ArrayList<String> valores = new ArrayList();
        for (int i=0;i<list.size();i++){
            if (products.get(i).getIva().equals("sin IVA")){
                valores.add("Codigo: "+list.get(i).getCodigo()+" Nombre: "+list.get(i).getNombre()+" $ "+list.get(i).getValor()+
                        " "+list.get(i).getIva());
            }

        }
        return valores;
    }
    public List<String> promedio(List<Producto> list){
        ArrayList<String> valores = new ArrayList();
        int suma=0;
        for (int i=0;i<list.size();i++){
            suma=suma+list.get(i).getValor();

        }
        valores.add("Promedio Valor"+(suma/list.size())+"");
        return valores;
    }

    public List<String> productosCostosos(List<Producto> list){
        ArrayList<String> valores = new ArrayList();
        Collections.sort(list, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return new Integer(p2.getValor()).compareTo(new Integer(p1.getValor()));
            }
        });
        for (int i=0;i<list.size();i++){
        if (list.size()<=10){
            valores.add(list.get(i).getCodigo()+" "+list.get(i).getNombre()+" "+list.get(i).getValor());
        }

        }
    return valores;
}   public List<String> productosBaratos(List<Producto> list){
        ArrayList<String> valores = new ArrayList();
        Collections.sort(list, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return new Integer(p1.getValor()).compareTo(new Integer(p2.getValor()));
            }
        });
        for (int i=0;i<list.size();i++){
        if (list.size()<=10){
            valores.add(list.get(i).getCodigo()+" "+list.get(i).getNombre()+" "+list.get(i).getValor());
        }

        }
    return valores;
}
}