package com.example.sherin.zoomcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        imageView=findViewById(R.id.imageId);
        zoomControls=findViewById(R.id.zoomControlsId);

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x=imageView.getScaleX();
                float y= imageView.getScaleY();

                if(x<5 && y<5)
                {
                    imageView.setScaleX(x+0.5f);
                    imageView.setScaleY(y+0.5f);
                }
                else{
                    Toast.makeText(MainActivity.this, "Limit crossed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x=imageView.getScaleX();
                float y=imageView.getScaleY();
                if(x>1 && y>1)
                {
                    imageView.setScaleX(x-0.5f);
                    imageView.setScaleY(y-0.5f);
                }
                else{
                    Toast.makeText(MainActivity.this, "Limit crossed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
