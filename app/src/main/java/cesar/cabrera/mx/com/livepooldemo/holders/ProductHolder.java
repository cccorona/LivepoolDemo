package cesar.cabrera.mx.com.livepooldemo.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cesar.cabrera.mx.com.livepooldemo.R;

public class ProductHolder extends RecyclerView.ViewHolder {

    public View root;
    public TextView title,price,location;
    public ImageView image;

    public ProductHolder(@NonNull View itemView) {
        super(itemView);
        root = itemView;
        title = itemView.findViewById(R.id.name);
        price = itemView.findViewById(R.id.price);
        location = itemView.findViewById(R.id.location);
        image = itemView.findViewById(R.id.image);
    }
}
