package com.hkc.foodapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hkc.foodapp2.Adapter.CategoryAdapter;
import com.hkc.foodapp2.Adapter.PopularAdapter;
import com.hkc.foodapp2.Domain.CategoryDomain;
import com.hkc.foodapp2.Domain.FoodDomain;
import com.hkc.foodapp2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("總匯披薩", "pizza1", "", 399.0));
        foodList.add(new FoodDomain("起司漢堡", "burger", "", 99.0));
        foodList.add(new FoodDomain("蔬菜披薩", "pizza2", "", 349.0));
//        foodList.add(new FoodDomain("","","",));

        adapter2 = new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("披薩", "cat_1"));
        categoryList.add(new CategoryDomain("漢堡", "cat_2"));
        categoryList.add(new CategoryDomain("熱狗", "cat_3"));
        categoryList.add(new CategoryDomain("飲料", "cat_4"));
        categoryList.add(new CategoryDomain("甜甜圈", "cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);

    }
}