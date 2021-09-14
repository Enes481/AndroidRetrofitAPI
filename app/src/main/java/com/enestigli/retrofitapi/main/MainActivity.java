package com.enestigli.retrofitapi.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import com.enestigli.retrofitapi.R;
import com.enestigli.retrofitapi.model.Model;
import com.enestigli.retrofitapi.service.CryptoAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //https://localhost:44397/api/default?apiKey=8f7b2190-ce69-4310-9bf5-c657bd2a9f61
    ArrayList<Model> models;
    private String BASE_URL = "https://10.0.0.2:44397/api/";
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RETROFİT VE JSON

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        loadData();

    }

    private void loadData(){

        CryptoAPI cryptoAPI = retrofit.create(CryptoAPI.class);

        Call<List<Model>> call = cryptoAPI.getData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                if(response.isSuccessful())
                {
                    List<Model> responseList = response.body();
                    models = new ArrayList<>(responseList);

                    if(responseList != null){


                        for(Model cryptoModel : models){
                            System.out.println(cryptoModel.ad);

                        }
                    }
                    else{
                        System.out.println("RESPONSE BOŞ DÖNDÜ !");
                    }

                }
                else{
                    System.out.println("RESPONSE BAŞARILI DEĞİL. !");
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                System.out.println("HATA MESAJI(ONFAİLURE)");
                t.printStackTrace();

            }
        });
    }

    }
