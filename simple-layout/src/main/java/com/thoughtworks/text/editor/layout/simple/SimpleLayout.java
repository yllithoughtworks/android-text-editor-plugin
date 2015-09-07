package com.thoughtworks.text.editor.layout.simple;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.thoughtworks.text.editor.layout.api.EditorLayout;
import com.thoughtworks.text.editor.mode.api.Mode;
import com.thoughtworks.text.editor.mode.api.Workspace;

public class SimpleLayout implements EditorLayout {
    private Context context;
    private LinearLayout viewGroup;
    private Workspace workspace;
    private ModesControl modesControl;

    @Override
    public void active(Context context) {
        this.context = context;
        viewGroup = new LinearLayout(context);
        viewGroup.setOrientation(LinearLayout.VERTICAL);

        //add modes control
        modesControl = new ModesControl();
        viewGroup.addView(modesControl.getViewGroup());

        //add workspace
        workspace = new SimpleWorkspace();
        viewGroup.addView(workspace.getViewGroup());
    }

    @Override
    public ViewGroup getViewGroup() {
        return viewGroup;
    }

    @Override
    public void addMode(Mode mode) {
        modesControl.addMode(mode);
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    class ModesControl {
        private final LinearLayout viewGroup;
        private Mode currentMode;

        public ModesControl() {
            viewGroup = new LinearLayout(context);
            viewGroup.setOrientation(LinearLayout.HORIZONTAL);
            viewGroup.setGravity(Gravity.CENTER);
            viewGroup.setBackgroundColor(Color.parseColor("#ff8d8d8d"));
        }

        public ViewGroup getViewGroup() {
            return viewGroup;
        }

        public void addMode(final Mode mode) {
            Button chooseModeButton = new Button(context);
            chooseModeButton.setText(mode.getName());
            chooseModeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentMode.inActive(context, workspace);
                    mode.active(context, workspace);
                    currentMode = mode;
                }
            });
            viewGroup.addView(chooseModeButton);

            if (currentMode == null) {
                mode.active(context, workspace);
                currentMode = mode;
            }
        }
    }

    class SimpleWorkspace implements Workspace {
        private final TextView editor;
        private LinearLayout viewGroup;

        public SimpleWorkspace() {
            viewGroup = new LinearLayout(context);
            viewGroup.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
            viewGroup.setOrientation(LinearLayout.VERTICAL);

            editor = new TextView(context);
            editor.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.FILL_PARENT, 1));

            viewGroup.addView(editor);
        }

        @Override
        public ViewGroup getViewGroup() {
            return viewGroup;
        }

        @Override
        public TextView getEditor() {
            return editor;
        }
    }
}
