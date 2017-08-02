package com.example.sendsms.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sendsms.R;
import com.example.sendsms.model.MessageDetails;

import java.util.List;

/**
 * Created by neel on 17/7/17.
 */

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.MyViewHolder> {

    private Fragment context;
    private List<MessageDetails> list;
    private TextView tvName, tvTime, tvOtp;
    private CardView cardView;

    /**
     *
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {


        /**
         * @param view view
         */
        public MyViewHolder(final View view) {

            super(view);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvOtp = (TextView) itemView.findViewById(R.id.tvOtp);
            cardView = (CardView) itemView.findViewById(R.id.idCardView);

        }


    }

    /**
     * @param context context
     * @param list    list
     */
    public MessageRecyclerAdapter(final Fragment context, final List<MessageDetails> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_card_view_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        tvName.setText(list.get(position).getName());
        tvTime.setText(list.get(position).getTime());
        tvOtp.setText(list.get(position).getOtp());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
