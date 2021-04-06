package com.app.urest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.app.urest.R;
import com.app.urest.classes.Restaurant;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mariexi on 08/04/16.
 */
public class ListaRestaurantesAdapter extends ArrayAdapter<Restaurant>{

    private ArrayList<Restaurant> originalList;
    private ArrayList<Restaurant> restaurantList;
    private RestaurantFilter filter;

    public ListaRestaurantesAdapter(Context context, int textViewResourceId, ArrayList<Restaurant> restaurantList) {
        super(context, 0, restaurantList);
        this.restaurantList = new ArrayList<Restaurant>();
        this.restaurantList.addAll(restaurantList);
        this.originalList = new ArrayList<Restaurant>();
        this.originalList.addAll(restaurantList);
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter  = new RestaurantFilter();
        }
        return filter;
    }

    private class ViewHolder {
        CircleImageView logo;
        TextView tipo;
        TextView nombre;
        TextView promedio;
        TextView horario;
        TextView favoritos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder holder = null;
        //View listItemView = convertView;

        if (null == convertView) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.lista_restaurantes, null);

            holder = new ViewHolder();
            holder.logo = (CircleImageView)convertView.findViewById(R.id.logo_rest);
            holder.tipo = (TextView)convertView.findViewById(R.id.tipo_rest);
            holder.nombre = (TextView)convertView.findViewById(R.id.nombre_rest);
            holder.promedio = (TextView)convertView.findViewById(R.id.promedio_rest);
            holder.horario = (TextView)convertView.findViewById(R.id.horario_rest);
            holder.favoritos = (TextView)convertView.findViewById(R.id.fav_rest);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        Restaurant item = restaurantList.get(position);

        Glide.with(getContext())
                .load(item.getLogo())
                .error(R.drawable.circle)
                .into(holder.logo);
        holder.tipo.setText(item.getTipo());
        holder.nombre.setText(item.getNombre());
        holder.promedio.setText(item.getPromedio());
        holder.horario.setText(item.getHorario());
        holder.favoritos.setText(item.getFavoritos());

        return convertView;

    }

    private class RestaurantFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if(constraint != null && constraint.toString().length() > 0)
            {
                ArrayList<Restaurant> filteredItems = new ArrayList<Restaurant>();

                for(int i = 0, l = originalList.size(); i < l; i++)
                {
                    Restaurant country = originalList.get(i);
                    if(country.toString().toLowerCase().contains(constraint))
                        filteredItems.add(country);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }
            else
            {
                synchronized(this)
                {
                    result.values = originalList;
                    result.count = originalList.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            restaurantList = (ArrayList<Restaurant>)results.values;
            notifyDataSetChanged();
            clear();
            for(int i = 0, l = restaurantList.size(); i < l; i++)
                add(restaurantList.get(i));
            notifyDataSetInvalidated();
        }
    }

}