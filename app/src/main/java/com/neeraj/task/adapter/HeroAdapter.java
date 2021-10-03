package com.neeraj.task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.neeraj.task.R;
import com.neeraj.task.model.HeroModel;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder> {
    Context context;
    List<HeroModel> heroList;

public HeroAdapter(Context context, List<HeroModel> heroList)
{
    this.context=context;
    this.heroList=heroList;
}
{

}
    @Override
    public HeroAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(context).inflate(R.layout.custom_layout,parent,false);
    MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HeroAdapter.MyViewHolder holder, int position) {
    Glide.with(context).load(heroList.get(position).getImageurl()).into(holder.image);
    holder.t.setText(heroList.get(position).getName());
    holder.t1.setText(heroList.get(position).getRealname());
    holder.t2.setText(heroList.get(position).getTeam());
    holder.t3.setText(heroList.get(position).getFirstappearance());
    holder.t4.setText(heroList.get(position).getCreatedby());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView t,t1,t2,t3,t4;
    ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.movie);
            t1=itemView.findViewById(R.id.real);
            t2=itemView.findViewById(R.id.team);
            t3=itemView.findViewById(R.id.first);
            t4=itemView.findViewById(R.id.create);
            image=itemView.findViewById(R.id.image);
        }
    }

}
