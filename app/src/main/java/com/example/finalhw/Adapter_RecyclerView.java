package com.example.finalhw;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_RecyclerView extends RecyclerView.Adapter<Adapter_RecyclerView.ViewHolder> {
    List<String> titels;
    List<Integer> images;
    Context context;
    LayoutInflater inflater;
    public Adapter_RecyclerView(List<String> titels, List<Integer> images, Context context) {
        this.titels = titels;
        this.images = images;
        this.context = context;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_actionlist, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titels.get(position));
        holder.gridIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titels.size();
    }

    //inner class
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView2);
            gridIcon = itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (title.getText().toString()){
                        case Main_ActionsList_Enum.Open_error:
                            context.startActivity(new Intent(context, Add_Problem_Screen.class));
                            break;
                        case Main_ActionsList_Enum.Fix_Team:
                            context.startActivity(new Intent(context, Add_Problem_Screen.class));
                            break;
                        case Main_ActionsList_Enum.Map:
                            context.startActivity(new Intent(context, Map_Screen.class));
                            break;
                        case Main_ActionsList_Enum.Notify:
                            context.startActivity(new Intent(context, NotifyScreen.class));
                            break;
                        default:
                            Toast.makeText(context, "select notify or map", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
