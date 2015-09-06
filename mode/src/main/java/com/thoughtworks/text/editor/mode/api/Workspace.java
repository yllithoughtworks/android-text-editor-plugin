package com.thoughtworks.text.editor.mode.api;

import android.view.ViewGroup;
import android.widget.TextView;

public interface Workspace {
    ViewGroup getViewGroup();

    TextView getEditor();
}
