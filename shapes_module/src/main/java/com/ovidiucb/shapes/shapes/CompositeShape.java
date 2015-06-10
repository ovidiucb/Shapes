package com.ovidiucb.shapes.shapes;

import com.ovidiucb.shapes.interfaces.Drawable;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ovidiucb
 */
public class CompositeShape implements Drawable {

    private String name;

    private boolean wasAccessed;
    @JsonProperty("children")
    protected List<Drawable> compositionElements;

    @JsonCreator
    public CompositeShape(@JsonProperty("name") String name) {
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

    @JsonIgnore
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

    @JsonIgnore
    public final boolean getWasAccessed() {
        return wasAccessed;
    }

    public final void setWasAccessed(boolean value) {
        wasAccessed = value;
    }
}
