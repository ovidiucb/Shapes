package com.ovidiucb.shapes;

import com.ovidiucb.interfaces.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ovidiucb
 */
public class CompositeShape implements Drawable {

    private String name;

    private boolean wasAccessed;
    protected List<Drawable> compositionElements;

    public CompositeShape(String name) {
        this.name = name;
        compositionElements = new ArrayList<Drawable>();
        wasAccessed = false;
    }

    public String getName() {
        return name;
    }

    public final void add(Drawable s) {
        compositionElements.add(s);
    }

    public final void addAll(List<Drawable> elements) {
        for (Drawable d : elements) {
            add(d);
        }
    }

    public final void remove(int index) {
        compositionElements.remove(index);
    }

    public final void remove(Drawable s) {
        compositionElements.remove(s);
    }

    public final List<Drawable> getCompositionElements() {
        return compositionElements;
    }

    public String draw() {
        wasAccessed = true;
        String drawing = "";

        if (!compositionElements.isEmpty()) {
            drawing += "Sub Shapes:\n\n";
            for (Drawable s : getCompositionElements()) {
                if (s instanceof CompositeShape) {
                    if (((CompositeShape) s).wasAccessed) {
                        continue;
                    }
                }
                drawing += s.draw();
            }
            drawing += "\nEnd Sub Shapes\n";
        }

        wasAccessed = false;

        return drawing;
    }

    public final boolean getWasAccessed() {
        return wasAccessed;
    }

    public final void setWasAccessed(boolean value) {
        wasAccessed = value;
    }
}
