package com.example.attendo2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendo2.R;
import com.example.attendo2.models.ResoursesUpload0;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Recylerview_resourses0 extends RecyclerView.Adapter<Recylerview_resourses0.Resourses_ImageViewHolder>{

    Recylerview_resourses0.OnNoteListener mOnNoteListener;
    private Context mcontext;
    private List<ResoursesUpload0> muploads;

    public Recylerview_resourses0(Context context, List<ResoursesUpload0> uploads, OnNoteListener onNoteListener){
        mcontext = context;
        muploads = uploads;
        this.mOnNoteListener = onNoteListener;

    }
    @NonNull
    @Override
    public Recylerview_resourses0.Resourses_ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.resources_items_0,parent,false);
        return new Recylerview_resourses0.Resourses_ImageViewHolder(v, mOnNoteListener);

    }

    @Override
    public void onBindViewHolder(@NonNull Recylerview_resourses0.Resourses_ImageViewHolder holder, int position) {
        ResoursesUpload0 uploadCurrent = muploads.get(position);
        holder.resourcesKa_item_Name.setText(uploadCurrent.getName());
        Picasso.get()
                .load(uploadCurrent.getImageUrl())
                .into(holder.Resources_Ka_Item_image);

    }

    @Override
    public int getItemCount() {
        return muploads.size();
    }

    public class Resourses_ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView resourcesKa_item_Name;
        public ImageView Resources_Ka_Item_image;
        Recylerview_resourses0.OnNoteListener OnNoteListener;

        public Resourses_ImageViewHolder(@NonNull View itemView, Recylerview_resourses0.OnNoteListener onNoteListener) {
            super(itemView);

            resourcesKa_item_Name = itemView.findViewById(R.id.resourcesKa_item_Name0);
            Resources_Ka_Item_image = itemView.findViewById(R.id.Resources_Ka_Item_image0);
            this.OnNoteListener= onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            OnNoteListener.onNoteClickkk(getAdapterPosition());

        }
    }

    public  interface  OnNoteListener{
        void onNoteClickkk(int position);
    }
}

