package com.app.urest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.urest.adapters.ListaRestaurantesAdapter;
import com.app.urest.classes.DatosListaRestaurantes;
import com.app.urest.classes.Restaurant;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.lista_restaurantes)
    ListView lista_restaurantes;
    @Bind(R.id.search)
    EditText search;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        displayListView();

    }

    private void displayListView() {

        ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
        restaurantList.add(new Restaurant("http://1.bp.blogspot.com/_SVRUUXuPSK4/TIWd-leTvvI/AAAAAAAAAsM/bhGKKoMlW9c/s400/Restaurant%2Blogos%2B2.png", "Restaurante - Bar", "RESTAURANT D ORD", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "394"));
        restaurantList.add(new Restaurant("http://www.vectorportal.com/img_novi/pixel77-free-vector-eco-log.jpg", "Bar", "TOWN BAR", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "975"));
        restaurantList.add(new Restaurant("http://1.bp.blogspot.com/_SVRUUXuPSK4/TIWd-leTvvI/AAAAAAAAAsM/bhGKKoMlW9c/s400/Restaurant%2Blogos%2B2.png", "Restaurante", "LA TRAVIATA", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "146"));
        restaurantList.add(new Restaurant("https://image.freepik.com/free-vector/organic-food-restaurant-logo-template_23-2147492558.jpg", "Bar", "BEERS", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "98"));
        restaurantList.add(new Restaurant("https://webdesignviews.com/media/2013/15526/21-back-to-organic-foods-logo.png", "Restaurante", "GOOD FOOD", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "875"));
        restaurantList.add(new Restaurant("https://image.freepik.com/vector-gratis/ilustracion-entrega-de-comida-saludable_439-2147510954.jpg", "Restaurante - Bar", "FRIDAYS", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "1.201"));
        restaurantList.add(new Restaurant("https://image.freepik.com/vector-gratis/ilustracion-entrega-de-comida-saludable_439-2147510954.jpg", "Pizzeria", "PIZZA HOT", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "397"));
        restaurantList.add(new Restaurant("http://www.vectorportal.com/img_novi/pixel77-free-vector-eco-log.jpg", "Restaurante - Bar", "DOLCE VITA", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "126"));
        restaurantList.add(new Restaurant("https://image.freepik.com/free-vector/organic-food-restaurant-logo-template_23-2147492558.jpg", "Restaurante - Bar", "JOES", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "234"));
        restaurantList.add(new Restaurant("https://webdesignviews.com/media/2013/15526/21-back-to-organic-foods-logo.png", "Restaurante", "OSAKA", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "2.465"));
        restaurantList.add(new Restaurant("http://1.bp.blogspot.com/_SVRUUXuPSK4/TIWd-leTvvI/AAAAAAAAAsM/bhGKKoMlW9c/s400/Restaurant%2Blogos%2B2.png", "Restaurante", "KAKAO", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "987"));
        restaurantList.add(new Restaurant("http://1.bp.blogspot.com/_SVRUUXuPSK4/TIWd-leTvvI/AAAAAAAAAsM/bhGKKoMlW9c/s400/Restaurant%2Blogos%2B2.png", "Café - Restaurante", "SAHARA", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "457"));
        restaurantList.add(new Restaurant("http://www.vectorportal.com/img_novi/pixel77-free-vector-eco-log.jpg", "Restaurante - Bar", "CABO GRILL", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "1.254"));
        restaurantList.add(new Restaurant("https://image.freepik.com/free-vector/organic-food-restaurant-logo-template_23-2147492558.jpg", "Restaurante - Pizzeria", "PICCOLA ITALIA", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "456"));
        restaurantList.add(new Restaurant("http://1.bp.blogspot.com/_SVRUUXuPSK4/TIWd-leTvvI/AAAAAAAAAsM/bhGKKoMlW9c/s400/Restaurant%2Blogos%2B2.png", "Restaurante", "TRIBAKER", "12,00 B/", "Horario: 11:00 a.m a 10:30 p.m.", "798"));


        adaptador = new ListaRestaurantesAdapter(this, R.layout.lista_restaurantes, restaurantList);
        lista_restaurantes.setAdapter(adaptador);
        lista_restaurantes.setTextFilterEnabled(true);

        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence a, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                adaptador.getFilter().filter(s.toString());
            }
        });

    }
}
