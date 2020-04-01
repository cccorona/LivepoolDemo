package cesar.cabrera.mx.com.livepooldemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import cesar.cabrera.mx.com.livepooldemo.adapters.HistorialAdapter;
import cesar.cabrera.mx.com.livepooldemo.adapters.ProductAdapter;
import cesar.cabrera.mx.com.livepooldemo.interfaces.ActionInterface;
import cesar.cabrera.mx.com.livepooldemo.model.Constants;
import cesar.cabrera.mx.com.livepooldemo.model.Enums;
import cesar.cabrera.mx.com.livepooldemo.model.GenericalError;
import cesar.cabrera.mx.com.livepooldemo.model.Historic;
import cesar.cabrera.mx.com.livepooldemo.model.PlpState;
import cesar.cabrera.mx.com.livepooldemo.model.SearchResponse;
import cesar.cabrera.mx.com.livepooldemo.utils.NetHelper;
import cesar.cabrera.mx.com.livepooldemo.utils.SettingsUtils;

public class MainActivity extends AppCompatActivity implements ActionInterface {

    private RecyclerView list,historialList;
    private EditText searchView;
    private boolean isSearching;
    boolean isLoading = false;
    private SearchResponse searchResponse;
    private ProductAdapter productAdapter;
    private int currentSeachPage;
    private CardView historicCard;
    private boolean showingHistorial;
    private RelativeLayout loader;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showingHistorial = false;
        initUI();
        initSearch();
        initScrollListener();
    }



    private void initUI(){
        list = findViewById(R.id.list);
        searchView = findViewById(R.id.search);
        loader = findViewById(R.id.loader);

        ImageView historicButton = findViewById(R.id.historial);
        historicCard = findViewById(R.id.card_historial);
        historialList = findViewById(R.id.historial_list);


        historicButton.setOnClickListener(view -> {
            if(showingHistorial){
                historicCard.setVisibility(View.GONE);
                showingHistorial = false;
            }else{
                historicCard.setVisibility(View.VISIBLE);
                showingHistorial = true;
            }
        });

        if (!"".equals(SettingsUtils.getInstance().getToken(MainActivity.this))){
         searchView.setText(SettingsUtils.getInstance().getToken(MainActivity.this));
        }

        reloadHistoriscs();

    }


    private void reloadHistoriscs(){
        HistorialAdapter historialAdapter = new HistorialAdapter(SettingsUtils.getInstance().getHistorics(this), this);
        historialList.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        historialList.setItemAnimator(new DefaultItemAnimator());
        historialList.setAdapter(historialAdapter);
    }


    @SuppressLint("ClickableViewAccessibility")
    private void initSearch(){

        currentSeachPage = 1;

        searchView.setOnKeyListener((v, keyCode, event) -> {
            EditText text = (EditText) v;

            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                if(text.getText().length()>0){
                    currentSeachPage = 1;
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    assert inputManager != null;
                    inputManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    search(text.getText().toString());
                    saveState(text.getText().toString());


                }else{
                    text.requestFocus();
                    text.setError(getString(R.string.error_busqueda));
                }
                return true;
            }
            return false;
        });

        searchView.setOnTouchListener((view, motionEvent) -> {

            if(showingHistorial){
                historicCard.setVisibility(View.GONE);
                showingHistorial = false;
            }


            return false;
        });

    }




    private void saveState(String termn){
        Historic historic = new Historic(termn,System.currentTimeMillis());
        ArrayList<Historic> historics = SettingsUtils.getInstance().getHistorics(MainActivity.this);
        historics.add(historic);
        SettingsUtils.getInstance().addHistorics(MainActivity.this,historics);
        SettingsUtils.getInstance().saveToken(MainActivity.this,termn);
        reloadHistoriscs();
    }


    private void noResults(){
        Toast.makeText(this, R.string.no_results,Toast.LENGTH_LONG).show();
        list.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
        list.setItemAnimator(new DefaultItemAnimator());
        list.setAdapter(null);
    }

    private void search(String text){

        if(!isNetworkAvailable(this)){
            Toast.makeText(this, R.string.no_red_error,Toast.LENGTH_LONG).show();
            return;
        }


        loader.setVisibility(View.VISIBLE);
        isLoading = true;
        NetHelper netHelper = new NetHelper(this);
        netHelper.setOnDataResultInterface(new NetHelper.OnDataResultInterface() {
            @Override
            public void OnResultOk(Object object) {
                 searchResponse = (SearchResponse) object;
                 isLoading = false;
                 if(searchResponse!=null){
                     loader.setVisibility(View.GONE);
                     list.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
                     list.setItemAnimator(new DefaultItemAnimator());
                     if(searchResponse.getPlpResults()!=null && searchResponse.getPlpResults().getRecords()!=null && searchResponse.getPlpResults().getRecords().size() > 0){
                         productAdapter = new ProductAdapter(searchResponse.getPlpResults().getRecords());
                         list.setAdapter(productAdapter);
                     }else{
                         //error or not results
                         noResults();
                     }

                 }else{
                     //error or not results
                     noResults();
                 }

            }

            @Override
            public void OnError(GenericalError error) {
                loader.setVisibility(View.GONE);

            }
        });

        HashMap<String,String> params = new HashMap<>();
        params.put("force-plp","true");
        params.put("search-string",text);
        params.put("page-number",""+currentSeachPage);
        params.put("number-of-items-per-page","20");

        netHelper.getRequestWithParams(SearchResponse.class, Constants.SEARCH_METHOD,params, new HashMap<>());

    }



    private void initScrollListener(){

        list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading && !isSearching) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == productAdapter.getItemCount() - 3) {
                        if(isNetworkAvailable(MainActivity.this)){
                            loadMore();
                            isLoading = true;
                        }

                    }
                }


            }
        });

    }


    private void loadMore(){
        isSearching = true;
        isLoading = true;
        loader.setVisibility(View.VISIBLE);
        NetHelper netHelper = new NetHelper(this);
        netHelper.setOnDataResultInterface(new NetHelper.OnDataResultInterface() {
            @Override
            public void OnResultOk(Object object) {

                searchResponse = (SearchResponse) object;
                loader.setVisibility(View.GONE);
                if(searchResponse!=null){
                    list.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
                    list.setItemAnimator(new DefaultItemAnimator());
                    if(searchResponse.getPlpResults()!=null && searchResponse.getPlpResults().getRecords()!=null && searchResponse.getPlpResults().getRecords().size() > 0){
                        if (productAdapter!=null){
                            productAdapter.addMore(searchResponse.getPlpResults().getRecords());
                        }
                    }else{
                        noResults();
                    }

                }else{
                    noResults();
                }
                isLoading = false;
            }

            @Override
            public void OnError(GenericalError error) {
                loader.setVisibility(View.GONE);
                noResults();


            }
        });

        if(searchResponse!=null&&searchResponse.getPlpResults()!=null && searchResponse.getPlpResults().getPlpState()!=null){
            PlpState state = searchResponse.getPlpResults().getPlpState();
             if (state.getTotalNumRecs() > productAdapter.getItemCount()) {
                 HashMap<String,String> params = new HashMap<>();
                 params.put("force-plp","true");
                 params.put("search-string",state.getOriginalSearchTerm());
                 params.put("page-number",""+currentSeachPage++);
                 params.put("number-of-items-per-page","20");
                 isLoading = true;

                 netHelper.getRequestWithParams(SearchResponse.class, Constants.SEARCH_METHOD,params, new HashMap<>());
             }
        }

    }

    public  boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void OnErrorAction(GenericalError error) {

    }

    @Override
    public void OnActionSelected(Enums.ACCIONES action, Object... params) {

        if (action == Enums.ACCIONES.SELECTED){
            Historic historic = (Historic) params[0];
            search(historic.getTermino());
        }

    }
}
