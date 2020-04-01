package cesar.cabrera.mx.com.livepooldemo.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cesar.cabrera.mx.com.livepooldemo.R;
import cesar.cabrera.mx.com.livepooldemo.holders.ProductHolder;
import cesar.cabrera.mx.com.livepooldemo.model.Product;

public class ProductAdapter extends RecyclerView.Adapter {


    private ArrayList products;


    public ProductAdapter(ArrayList products) {
        this.products = products;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Product product = (Product) products.get(position);
           if(product!=null){
               ProductHolder productHolder = (ProductHolder) holder;
               Glide.with(productHolder.root.getContext()).load(product.getSmImage()).placeholder(R.drawable.app_icon).into(productHolder.image);
               productHolder.title.setText(product.getProductDisplayName());
               productHolder.location.setText("");
               productHolder.price.setText("Precio:"+product.getListPrice());
           }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void addMore(ArrayList<Product> products){
        int currentPos = products.size();

        this.products.addAll(products);
        notifyItemInserted(currentPos + 1);
    }
}
