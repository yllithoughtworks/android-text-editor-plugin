package com.thoughtworks.text.editor.layout.api;

import android.content.Context;
import android.view.ViewGroup;
import com.thoughtworks.text.editor.mode.api.Mode;
import com.thoughtworks.text.editor.mode.api.Workspace;

public interface EditorLayout {
    void active(Context context);

    ViewGroup getViewGroup();

    void addMode(Mode mode);

    Workspace getWorkspace();
}
