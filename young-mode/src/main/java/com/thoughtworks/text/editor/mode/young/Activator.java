package com.thoughtworks.text.editor.mode.young;

import com.thoughtworks.text.editor.mode.api.Mode;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        context.registerService(Mode.class, new YoungMode(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }
}
