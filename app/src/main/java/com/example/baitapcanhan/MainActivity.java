package com.example.baitapcanhan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.baitapcanhan.Adapter.MyPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    BottomNavigationView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager2 = findViewById(R.id.view_pager);
        bottom = findViewById(R.id.bottom);

        // Set Adapter for ViewPager2
        MyPagerAdapter adapter = new MyPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        // Disable swipe animation if needed
        viewPager2.setUserInputEnabled(false);

        // Handle BottomNavigationView item selection
        bottom.setOnNavigationItemSelectedListener(item -> {
                if(item.getItemId() == R.id.home) {
                    viewPager2.setCurrentItem(0, false);
                    return true;
                }
                else if(item.getItemId() == R.id.profile) {
                    viewPager2.setCurrentItem(1, false);
                    return true;
                }
                else {
                    viewPager2.setCurrentItem(0, false);
                    return true;
                }
        });

        // Sync ViewPager2 with BottomNavigationView
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottom.setSelectedItemId(R.id.home);
                        break;
                    case 1:
                        bottom.setSelectedItemId(R.id.profile);
                        break;
                }
            }
        });
    }
}