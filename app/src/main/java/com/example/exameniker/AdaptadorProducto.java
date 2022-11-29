package com.example.exameniker;
/*Examen de Iker Iturralde Tejido*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ProductosViewHolder> implements View.OnClickListener,View.OnLongClickListener{

    private ArrayList<Producto> datos;
    private View.OnClickListener listener;
    private View.OnLongClickListener longListener;


    public void setOnClickListener(View.OnClickListener listener){
        this.listener= listener;
    }
    public void setOnLongClickListener(View.OnLongClickListener longListener){
        this.longListener= longListener;
    }

    public AdaptadorProducto(ArrayList<Producto> datos) {
        this.datos = datos;
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    public boolean onLongClick(View v){
        if (longListener != null){
            longListener.onLongClick(v);
            return true;
        }
        return false;
    }


    public static class ProductosViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNombre;
        private TextView txtProducto;

        public ProductosViewHolder(View itemView){
            super(itemView);
            this.txtNombre = itemView.findViewById(R.id.nombre);
            this.txtProducto = itemView.findViewById(R.id.precio);
        }

        public void bindTitular(Producto producto){
            txtNombre.setText(producto.getNombre());
            txtProducto.setText(producto.getPrecio());
        }


    }
    @Override
    public ProductosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_component,viewGroup,false);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

        ProductosViewHolder tvh = new ProductosViewHolder(itemView);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position){
        Producto producto = datos.get(position);
        holder.bindTitular(producto);
    }

    @Override
    public int getItemCount(){
        return datos.size();
    }




}
