package com.example.sendsms.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendsms.R;
import com.example.sendsms.activity.DetailActivity;
import com.example.sendsms.model.ContactDetails;

import java.util.List;

/**
 * Created by neel on 17/7/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Fragment context;
    private List<ContactDetails> list;
    private TextView tvFirstName, tvLastname, tvPhoneNumber;
    private CardView cardView;

    /**
     *
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        /**
         * @param view view
         */
        public MyViewHolder(final View view) {

            super(view);

            tvFirstName = (TextView) itemView.findViewById(R.id.tvFirtName);
            tvLastname = (TextView) itemView.findViewById(R.id.tvLastName);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            cardView = (CardView) itemView.findViewById(R.id.idCardView);

        }

        @Override
        public void onClick(View v) {


        }
    }

    /**
     * @param context context
     * @param list    list
     */
    public RecyclerAdapter(final Fragment context, final List<ContactDetails> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        tvFirstName.setText(list.get(position).getFirstName());
        tvLastname.setText(list.get(position).getLastName());


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                ContactDetails contactDetails = new ContactDetails();


                contactDetails.setFirstName(list.get(position).getFirstName());
                contactDetails.setLastName(list.get(position).getLastName());
                contactDetails.setPhoneNumber(list.get(position).getPhoneNumber());

                Bundle bundle = new Bundle();
                bundle.putParcelable("contact", contactDetails);
                Intent i = new Intent(context.getActivity(), DetailActivity.class);
                i.putExtras(bundle);
                context.startActivityForResult(i,1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
