package com.surroundsync.ashrayjoshi.comment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CommentInfo> commentsList;
    private RecyclerView mRecyclerView;
    private CommentAdapter adapter;
    private TextView tvClick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvClick= (TextView)findViewById(R.id.txtName);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        commentsList = new ArrayList<>();
for(int i=0;i<10;i++){
        CommentInfo commentInfo = new CommentInfo("Hi Ashray,\n" +
                "Congratulations on your 1-month Firebase anniversary!\n" +
                "At Firebase, we're constantly trying to improve. But we need your help! If you can spare 5 minutes, I'd appreciate it if you'd click here to tell us about your experience. \n" +
                "Keep Building,\n" +
                "-Max, on behalf of the whole Firebase team\n" );
        commentsList.add(commentInfo);}
        adapter = new CommentAdapter(MainActivity.this, commentsList);


        mRecyclerView.setAdapter(adapter);

    }
}
