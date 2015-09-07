package com.thoughtworks.text.editor.layout.simple;

import android.util.Log;
import com.thoughtworks.text.editor.layout.api.EditorLayout;
import com.thoughtworks.text.editor.mode.api.Mode;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import java.util.Collection;

public class Activator implements BundleActivator {
    @Override
    public void start(final BundleContext context) throws Exception {
        Log.d("simple-layout", "start... ");
        final SimpleLayout layout = new SimpleLayout();
        context.registerService(EditorLayout.class, layout, null);

        final Collection<ServiceReference<Mode>> modes = context.getServiceReferences(Mode.class, null);
        ServiceTracker<Mode, Mode> tracker = new ServiceTracker<Mode, Mode>(context, Mode.class, new ServiceTrackerCustomizer<Mode, Mode>() {
            @Override
            public Mode addingService(ServiceReference<Mode> reference) {
                final Mode mode = context.getService(reference);
                if (!modes.contains(reference)) {
                    Log.d("simple-layout", "add new mode: " + mode.getName());
                    layout.addMode(mode);
                }
                return mode;
            }

            @Override
            public void modifiedService(ServiceReference<Mode> reference, Mode service) {

            }

            @Override
            public void removedService(ServiceReference<Mode> reference, Mode service) {

            }
        });
        tracker.open(true);

        for (ServiceReference<Mode> mode : modes) {
            final Mode service = context.getService(mode);
            Log.d("simple-layout", "add existing mode: " + service.getName());
            layout.addMode(service);
        }
        Log.d("simple-layout", "end... ");
    }

    @Override
    public void stop(BundleContext context) throws Exception {

    }
}
