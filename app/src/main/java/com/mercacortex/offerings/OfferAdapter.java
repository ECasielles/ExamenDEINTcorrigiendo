package com.mercacortex.offerings;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    Context context;
    ArrayList<OfferModel> offers;
    boolean ASC = false;
    boolean DESC = false;
    boolean showHome, showElectronics, showSports;

    public OfferAdapter(Context context, boolean showHome, boolean showElectronics, boolean showSports) {
        this.context = context;
        this.offers = OfferRepository.getInstance().getOfferList();
        this.showHome = showHome;
        this.showElectronics = showElectronics;
        this.showSports = showSports;
    }

    @Override
    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View myView = inflater.inflate(R.layout.item_offer, parent, true);
        OfferViewHolder offerViewHolder = new OfferViewHolder(myView);
        return offerViewHolder;
    }

    @Override
    public void onBindViewHolder(OfferViewHolder holder, int position) {
        holder.imvItemHolder.setImageResource(offers.get(position).getImgId());
        holder.txvSellerHolder.setText(offers.get(position).getSeller());
        holder.txvNameHolder.setText(offers.get(position).getName());
        holder.txvDateHolder.setText(offers.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public void addNewOffer(OfferModel offerModel) {
        OfferRepository.getInstance().addOffer(offerModel);
        notifyDataSetChanged();
    }

    public void sortAsc() {
        if(!ASC) {
            ASC = true;
            DESC = false;
            Collections.sort(offers, OfferModel.NAME_ASC);
        }
    }
    public void sortDesc() {
        if(!DESC) {
            ASC = false;
            DESC = true;
            Collections.sort(offers, OfferModel.NAME_DESC);
        }
    }
    public void sortType() {
            ASC = false;
            DESC = false;
            Collections.sort(offers, OfferModel.TYPE_ASC);
    }

    class OfferViewHolder extends RecyclerView.ViewHolder {
        ImageView imvItemHolder;
        TextView txvSellerHolder, txvNameHolder, txvDateHolder;

        public OfferViewHolder(View itemView) {
            super(itemView);
            imvItemHolder = (ImageView) itemView.findViewById(R.id.imvItem);
            txvSellerHolder = (TextView) itemView.findViewById(R.id.txvSellerItem);
            txvNameHolder = (TextView) itemView.findViewById(R.id.txvNameItem);
            txvDateHolder = (TextView) itemView.findViewById(R.id.txvDateItem);
        }
    }
}
