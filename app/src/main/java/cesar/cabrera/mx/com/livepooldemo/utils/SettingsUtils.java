package cesar.cabrera.mx.com.livepooldemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import cesar.cabrera.mx.com.livepooldemo.holders.HistorialHolder;
import cesar.cabrera.mx.com.livepooldemo.model.Historic;

public class SettingsUtils {

    private String SETTINGS ="settings";
    private String TOKEN ="token";
    private String SEARCHS="historics";


    private static final SettingsUtils ourInstance = new SettingsUtils();

    public static SettingsUtils getInstance() {
        return ourInstance;
    }

    private SettingsUtils() {
    }



    public void saveToken(Context context, String token){

        SharedPreferences sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN,token).apply();

    }

    public String getToken(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN,"");

    }



    public void addHistorics(Context context, ArrayList<Historic> historics){
        Gson gson = new Gson();
        String strign = gson.toJson(historics);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SEARCHS,strign).apply();
    }

    public ArrayList<Historic> getHistorics(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(SEARCHS,"");
        ArrayList<Historic> historics = new Gson().fromJson(json, new TypeToken<List<Historic>>(){}.getType());
        if (historics == null){
            historics = new ArrayList<>();
        }

        return historics;

    }


}
