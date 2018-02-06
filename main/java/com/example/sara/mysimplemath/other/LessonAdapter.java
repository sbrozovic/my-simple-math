package com.example.sara.mysimplemath.other;

/**
 * Created by Sara on 14.3.2017..
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.activity.TabLessonActivity;

import java.util.List;

/**
 * It is part of LessonActivity
 *
 * Here is created adapter for Lesson
 */

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.MyViewHolder> {
    private Context mContext;
    private List<Lesson> lessonList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView title, description;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View v){
            super(v);
            title = (TextView)v.findViewById(R.id.text_title);
            description = (TextView)v.findViewById(R.id.text_description);
            thumbnail = (ImageView)v.findViewById(R.id.image_thumbnail);

            v.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(v.getContext(),TabLessonActivity.class);
                    intent.putExtra("CardTitle", title.getText().toString());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public LessonAdapter(Context mContext, List<Lesson> lessonList) {
        this.mContext = mContext;
        this.lessonList = lessonList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Lesson lesson = lessonList.get(position);
        holder.title.setText(lesson.getName());
        holder.description.setText(lesson.getDescription());
        Glide.with(mContext).load(lesson.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }
}
