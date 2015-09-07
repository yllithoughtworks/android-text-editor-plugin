package com.thoughtworks.text.editor.mode.young;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.thoughtworks.text.editor.mode.api.Mode;
import com.thoughtworks.text.editor.mode.api.Workspace;

public class YoungMode implements Mode {
    private LinearLayout controlBar;

    @Override
    public String getName() {
        return "Young";
    }

    @Override
    public void active(Context context, Workspace workspace) {
        final TextView content = workspace.getEditor();

        controlBar = new LinearLayout(context);

        Button blue = new Button(context);
        blue.setText("蓝");
        blue.setTextColor(Color.BLUE);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setTextColor(Color.BLUE);
            }
        });

        Button black = new Button(context);
        black.setText("黑");
        black.setTextColor(Color.BLACK);
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setTextColor(Color.BLACK);
            }
        });


        controlBar.addView(black);
        controlBar.addView(blue);
        workspace.getViewGroup().addView(controlBar);
    }

    @Override
    public void inActive(Context context, Workspace workspace) {
        workspace.getViewGroup().removeView(controlBar);
    }
}
