package com.example.dgonzalez.recyclerviewtest;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by dgonzalez on 8/4/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    List<Person> persons;

    RVAdapter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder personViewHolder, final int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_layout, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//                    Toast.makeText(itemView.getContext(), personName.getText(), Toast.LENGTH_SHORT).show();
//                }
//            });

        }
    }
}
