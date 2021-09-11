package event.center.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        models = new ArrayList<>();
        models.add(new model(R.drawable.fish_rice, "Fried Rice", "Rice and Fish with Vegetables,NGN 800 per plate."));
        models.add(new model(R.drawable.coconut_jollof_rice, "Jollof Rice", " Jollof Rice with pear, NGN 800 per plate"));
        models.add(new model(R.drawable.white_coconut_rice, "White Rice", " White Rice with Beef soup, NGN 850 per plate"));
        models.add(new model(R.drawable.colored_fried_rice, "Party Jollof Rice", "Party Jollof Rice with  fried chicken, NGN 800 per plate "));
        adapter = new Adapter(models,this);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] color_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),

        };
        colors= color_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position <(adapter.getCount()-1)&&position<(colors.length-1)){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(
                            positionOffset,
                            colors[position],
                            colors[position + 1])
                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}