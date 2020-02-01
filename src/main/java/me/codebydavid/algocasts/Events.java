package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// --- Directions
// Create an 'eventing' library out of the
// Events class.  The Events class should
// have methods 'on', 'trigger', and 'off'.
public class Events {

    Map<String, List<Callback>> callbacks;

    public Events() {
        this.callbacks = new HashMap<String, List<Callback>>();
    }

    public void on(String event, Callback callback) {
        if (!callbacks.containsKey(event)) {
            callbacks.put(event, new ArrayList<Callback>());
        }

        callbacks.get(event).add(callback);
    }
    
    public void trigger(String event) {
        if (!callbacks.containsKey(event)) return;

        for (Callback cb: callbacks.get(event)) {
            cb.execute();
        }
    }

    public void off(String event) {
        callbacks.remove(event);
    }

    public static interface Callback {
        public void execute();
    }
}