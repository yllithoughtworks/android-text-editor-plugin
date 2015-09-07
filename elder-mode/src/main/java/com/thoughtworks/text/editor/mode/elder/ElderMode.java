package com.thoughtworks.text.editor.mode.elder;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.thoughtworks.text.editor.mode.api.Mode;
import com.thoughtworks.text.editor.mode.api.Workspace;

public class ElderMode implements Mode {
    private LinearLayout controlBar;

    @Override
    public String getName() {
        return "Elder";
    }

    @Override
    public void active(Context context, Workspace workspace) {

        final TextView content = workspace.getEditor();
        content.setTextSize(30);

        controlBar = new LinearLayout(context);

        Button zoomOut = new Button(context);
        zoomOut.setText("-");
        zoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setTextSize(25);
            }
        });


        Button zoomIn = new Button(context);
        zoomIn.setText("+");
        zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setTextSize(35);
            }
        });


        Button reset = new Button(context);
        reset.setText("Reset");
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setTextSize(30);
            }
        });

        controlBar.addView(zoomIn);
        controlBar.addView(zoomOut);
        controlBar.addView(reset);
        workspace.getViewGroup().addView(controlBar);
    }

    @Override
    public void inActive(Context context, Workspace workspace) {
        workspace.getViewGroup().removeView(controlBar);
    }
}
