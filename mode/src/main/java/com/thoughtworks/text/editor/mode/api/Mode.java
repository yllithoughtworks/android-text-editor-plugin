package com.thoughtworks.text.editor.mode.api;

import android.content.Context;

public interface Mode {
    String getName();

    void active(Context context, Workspace editorArea);

    void inActive(Context context, Workspace editorArea);
}
