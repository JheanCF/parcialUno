package com.jp.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.List;

import models.Producto;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Producto producto=new Producto();
    public static ArrayList<Producto> productos=new ArrayList();
    private EditText txtName;
    private EditText txtCodigo;
    private EditText txtValor;
    private Spinner spnIva;
    private EditText txtDescripcion;
    private EditText txtCategoria;
    private Button btnConsultas;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName=findViewById(R.id.txtName);
        txtCodigo=findViewById(R.id.txtCodigo);
        txtValor=findViewById(R.id.txtValor);
        spnIva=(Spinner) findViewById(R.id.spnIva);
        txtDescripcion=findViewById(R.id.txtDescripcion);
        txtCategoria=findViewById(R.id.txtCategoria);
        btnAgregar=findViewById(R.id.btnAdd);
        btnConsultas=findViewById(R.id.btnConsulta);
        btnConsultas.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);
        ArrayList<String> elementos=new ArrayList<>();
        elementos.add("IVA");
        elementos.add("sin IVA");
        ArrayAdapter adp= new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,elementos);
        spnIva.setAdapter(adp);
        spnIva.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String elem=(String) spnIva.getAdapter().getItem(position);
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConsulta) {
            Intent intent= new Intent(this, Listado.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnAdd) {
            String name = txtName.getText().toString();
            int codigo = parseInt(txtCodigo.getText().toString());
            int valor = parseInt(txtValor.getText().toString());
            String iva = spnIva.getSelectedItem().toString();
            String descripcion = txtDescripcion.getText().toString();
            String categoria = txtCategoria.getText().toString();

            if (name.isEmpty()) {
                CustomToastView.makeInfoToast(this, "Error al validar nombre", R.layout.custom_toast).show();
                return;
            }
            if (codigo<=0) {
                CustomToastView.makeInfoToast(this, "Error al validar Codigo", R.layout.custom_toast).show();
                return;
            }
            if (valor<=0) {
                CustomToastView.makeInfoToast(this, "Error al validar Valor", R.layout.custom_toast).show();
                return;
            }
            if (iva.isEmpty()) {
                CustomToastView.makeInfoToast(this, "Error al validar Iva", R.layout.custom_toast).show();
                return;
            }
            if (descripcion.isEmpty()) {
                CustomToastView.makeInfoToast(this, "Error al validar Descripción", R.layout.custom_toast).show();
                return;
            }
            if (categoria.isEmpty()) {
                CustomToastView.makeInfoToast(this, "Error al validar Categoria", R.layout.custom_toast).show();
                return;
            }
            Producto nproducto;
            nproducto=new Producto();
            nproducto.setNombre(name);
            nproducto.setCodigo((codigo));
            nproducto.setValor((valor));
            nproducto.setIva(iva);
            nproducto.setDescripcion(descripcion);
            nproducto.setCategoria(categoria);
            productos.add(nproducto);
            Intent intent= new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }
}