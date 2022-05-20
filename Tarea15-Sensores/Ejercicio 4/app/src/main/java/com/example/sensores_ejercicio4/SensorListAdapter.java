package com.example.sensores_ejercicio4;

import android.content.Context;
import android.view.*;
import android.widget.*;

public final class SensorListAdapter extends ArrayAdapter<SensorElement>{
    private final int entradaLayoutRecurso;
    public SensorListAdapter(final Context c, final int entLayRec) {
        super(c, 0);
        this.entradaLayoutRecurso = entLayRec;
    }
    @Override
    public View getView(final int i, final View v, final ViewGroup vg) {
        final View v2 = getWorkingView(v);
        final ViewHolder vh = getViewHolder(v2);
        final SensorElement sen = getItem(i);
        vh.nombreView.setText(sen.getNombre());
        vh.tipoView.setText("Tipo de sensor: "+sen.getTipo());
        vh.fabricanteView.setText("Proveedor: "+sen.getFabricante());
        vh.potenciaView.setText("Potencia (ma): "+sen.getPotencia());
        vh.resView.setText("Máxima resolución: "+sen.getResolucion()+", rango: "+sen.getRangoMaximo());
        vh.imagenView.setImageResource(sen.getIcono());
        return v2;
    }

    private View getWorkingView(final View v3) {
        View workingView = null;
        if(null == v3) {
            final Context c2 = getContext();
            final LayoutInflater inflater = (LayoutInflater)c2.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            workingView = inflater.inflate(entradaLayoutRecurso, null);
        } else {
            workingView = v3;
        }
        return workingView;
    }

    private ViewHolder getViewHolder(final View workingView) {
        final Object tag = workingView.getTag();
        ViewHolder vh = null;
        if(null == tag || !(tag instanceof ViewHolder)) {
            vh = new ViewHolder();
            vh.nombreView = (TextView) workingView.findViewById(R.id.xtvNombre);
            vh.tipoView = (TextView) workingView.findViewById(R.id.xtvTipo);
            vh.fabricanteView = (TextView) workingView.findViewById(R.id.xtvFabricante);
            vh.potenciaView = (TextView) workingView.findViewById(R.id.xtvPotencia);
            vh.resView = (TextView) workingView.findViewById(R.id.xtvResYRango);
            vh.imagenView = (ImageView) workingView.findViewById(R.id.xivImagen);
            workingView.setTag(vh);
        } else {
            vh = (ViewHolder) tag;
        }
        return vh;
    }

    private static class ViewHolder {
        public TextView nombreView;
        public TextView fabricanteView;
        public TextView tipoView;
        public TextView potenciaView;
        public TextView resView;
        public ImageView imagenView;
    }
}