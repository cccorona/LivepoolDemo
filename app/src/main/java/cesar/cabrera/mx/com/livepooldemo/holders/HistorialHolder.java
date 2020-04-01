package cesar.cabrera.mx.com.livepooldemo.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cesar.cabrera.mx.com.livepooldemo.R;

public class HistorialHolder extends RecyclerView.ViewHolder {


    public View root;
    public TextView fecha,termino,ir;

    public HistorialHolder(@NonNull View itemView) {
        super(itemView);
        root = itemView;
        fecha = itemView.findViewById(R.id.fecha);
        termino = itemView.findViewById(R.id.termino);
        ir = itemView.findViewById(R.id.ver);
    }
}
