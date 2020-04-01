package cesar.cabrera.mx.com.livepooldemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cesar.cabrera.mx.com.livepooldemo.R;
import cesar.cabrera.mx.com.livepooldemo.holders.HistorialHolder;
import cesar.cabrera.mx.com.livepooldemo.interfaces.ActionInterface;
import cesar.cabrera.mx.com.livepooldemo.model.Enums;
import cesar.cabrera.mx.com.livepooldemo.model.Historic;

public class HistorialAdapter extends RecyclerView.Adapter {


    private ArrayList<Historic> historics;
    private ActionInterface actionInterface;


    public HistorialAdapter(ArrayList<Historic> historics, ActionInterface actionInterface) {
        this.historics = historics;
        this.actionInterface = actionInterface;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistorialHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Historic historic = historics.get(position);
           if(historic!=null){
               HistorialHolder historialHolder = (HistorialHolder) holder;
               historialHolder.termino.setText(historic.getTermino());
               SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
               String date = format.format(new Date(historic.getFecha()));
               historialHolder.fecha.setText(date);

               historialHolder.root.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       if (actionInterface!=null){
                           actionInterface.OnActionSelected(Enums.ACCIONES.SELECTED,historic);
                       }
                   }
               });
           }
    }

    @Override
    public int getItemCount() {
        return historics.size();
    }
}
