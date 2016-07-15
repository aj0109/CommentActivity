package com.surroundsync.ashrayjoshi.comment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ashray Joshi on 05-Jul-16.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    boolean isTextViewClicked = false;
    private int lastExpandedPosition = -1;



    private List<CommentInfo> commentList;

    public CommentAdapter(Context context, List<CommentInfo> commentList) {
        this.commentList = commentList;
    }
    public static class CommentViewHolder extends RecyclerView.ViewHolder {
        protected TextView vTitle;


        public CommentViewHolder(View v) {
            super(v);
        vTitle = (TextView) v.findViewById(R.id.txtName);


        }
    }


    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_comment_view, null);

        CommentViewHolder viewHolder = new CommentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CommentViewHolder commentViewHolder, int i) {
        CommentInfo ci = commentList.get(i);
        commentViewHolder.vTitle.setText(ci.comment);
        commentViewHolder.vTitle.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            if (isTextViewClicked) {
                                                                collapseTextView(commentViewHolder.vTitle,2);

                                                                //This will shrink textview to 2 lines if it is expanded.
                                                                commentViewHolder.vTitle.setMaxLines(2);

                                                                isTextViewClicked = false;


                                                            } else {
                                                                expandTextView(commentViewHolder.vTitle);
                                                                //This will expand the textview if it is of 2 lines
                                                                commentViewHolder.vTitle.setMaxLines(Integer.MAX_VALUE);

                                                                isTextViewClicked = true;

                                                                }

                                                            }
                                                    }
        );

    }
    @Override
    public int getItemCount() {
        return commentList.size();

    }
    private void collapseTextView(TextView tv, int numLines){
        ObjectAnimator animation = ObjectAnimator.ofInt(tv, "maxLines", numLines);
        animation.setDuration(200).start();
    }
    private void expandTextView(TextView tv){
        ObjectAnimator animation = ObjectAnimator.ofInt(tv, "maxLines", tv.getLineCount());
        animation.setDuration(200).start();
    }


}

