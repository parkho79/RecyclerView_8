package com.parkho.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PhMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List 설정
        bindList();
    }

    /**
     * List 설정
     */
    private void bindList() {
        // List item 생성
        final List<PhRecyclerItem> itemList = new ArrayList<>();
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f600, "emoji_u1f600"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f601, "emoji_u1f601"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f602, "emoji_u1f602"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f603, "emoji_u1f603"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f604, "emoji_u1f604"));
        itemList.add(new PhRecyclerItem(R.drawable.emoji_u1f605, "emoji_u1f605"));

        // Recycler view
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Adapter 설정
        PhRecyclerViewAdapter adapter = new PhRecyclerViewAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Layout manager 추가
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Simple divider 추가
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        /*
        // Custom divider Item decoration 추가
        PhDividerItemDecoration itemDecoration = new PhDividerItemDecoration(10F, Color.BLUE);
        recyclerView.addItemDecoration(itemDecoration);

        // Offset Item decoration 추가
        PhOffsetItemDecoration itemDecoration = new PhOffsetItemDecoration(50);
        recyclerView.addItemDecoration(itemDecoration);
        */
    }
}