package com.example.yszhu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import org.artoolkit.ar.base.ARActivity;
import org.artoolkit.ar.base.rendering.ARRenderer;

public class ARSimple extends ARActivity {
    private int level;
    private float rotate;
    private float x;
    private float y;
    private float z;
    private PracticeCube cube;
    private Button theRotate;
    private Button theLevel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        cube= new PracticeCube(40.0f, 0.0f, 0.0f, 20.0f);
        theRotate=(Button)findViewById(R.id.romate);
        theRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotate+=20*level;
                cube.setData(rotate,0f,0f,1f);
            }
        });
        theLevel=(Button)findViewById(R.id.level);
        level=1;
        theLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level=(level+1)%5>0?(level+1)%5:5;
                theLevel.setText("degree level:"+level);
            }
        });
    }

    /**
     * Provide our own SimpleRenderer.
     */
    @Override
    protected ARRenderer supplyRenderer() {
        return new SimpleRenderer(cube);
        //return new SimpleRenderer(cube);
    }

    /**
     * Use the FrameLayout in this Activity's UI.
     */
    @Override
    protected FrameLayout supplyFrameLayout() {
        return (FrameLayout) this.findViewById(R.id.mainLayout);
    }
}
