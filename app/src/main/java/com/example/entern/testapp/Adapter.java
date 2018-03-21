package com.example.entern.testapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<BaseViewHolder> {
    public List<PersonInfo> mDataset = new ArrayList<>();

    int position;


    public class ViewHolder extends BaseViewHolder {

        TextView mTvFast_Name,
                mTvLast_Name,
                mTvFather_Name,
                mTvMather_Name,
                mTvDarth_Of_Barth,
                mTvAge,
                mTvMobile_Number,
                mTvAddress,
                mTvPermanent_Address;
        ImageView mIvIcon;

        public ViewHolder(View v) {
            super(v);
            mTvFast_Name = v.findViewById(R.id.tv_fast_name);
            mTvLast_Name = v.findViewById(R.id.tv_last_name);
            mTvFather_Name = v.findViewById(R.id.tv_father_name);
            mTvMather_Name = v.findViewById(R.id.tv_mather_name);
            mTvDarth_Of_Barth = v.findViewById(R.id.tv_darth_of_barth);
            mTvMobile_Number = v.findViewById(R.id.tv_mobile_number);
            mTvAddress = v.findViewById(R.id.tv_address);
            mTvAge = v.findViewById(R.id.tv_age);
            mIvIcon = v.findViewById(R.id.ivPhoto);
        }

        @Override
        protected void clear() {

        }

        public void onBind(int position) {
            super.onBind(position);

            mIvIcon.setImageBitmap(mDataset.get(position).getProfileImage());
            mTvFast_Name.setText(mDataset.get(position).getFast_Name());
            mTvLast_Name.setText(mDataset.get(position).getLast_Name());
            mTvFather_Name.setText(mDataset.get(position).getFather_Name());
            mTvMather_Name.setText(mDataset.get(position).getMather_name());
            mTvDarth_Of_Barth.setText(mDataset.get(position).getBarth_Of_Date());
            mTvMobile_Number.setText(String.valueOf(mDataset.get(position).getContact().getMobile_Number()));
            mTvAddress.setText(mDataset.get(position).getContact().getAddress());
            mTvAge.setText(String.valueOf(mDataset.get(position).getAge()));
        }
    }

    public class EmptyHolder extends BaseViewHolder {
        // each data item is just a string in this case
        public TextView mTvFast_Name;

        public EmptyHolder(View v) {
            super(v);
            mTvFast_Name = v.findViewById(R.id.tv_fast_name);
//            mTvName.setText("NO Item Found");

        }

        @Override
        protected void clear() {

        }
    }


    public void addItems(List<PersonInfo> myDataset) {
        mDataset.addAll(myDataset);
        notifyDataSetChanged();
    }

    public void  addItem(PersonInfo personInfo) {
        mDataset.add(personInfo);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new ViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.my_text_view, parent, false));
            case 1:
                return new EmptyHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.test_layout, parent, false));
            default:
                return new ViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.my_text_view, parent, false));
        }


    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemViewType(int position) {
        if (mDataset.size() > 0) {
            return 0;
        } else {
            return 1;
        }


    }

    @Override
    public int getItemCount() {
        if (mDataset.size()>0) {
            return mDataset.size();

        }else
        {
            return 1;
        }
    }
}

