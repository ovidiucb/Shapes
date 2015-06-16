package com.ovidiucb.webapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ovidiucb.shapes.helpers.ShapeGenerator;
import com.ovidiucb.shapes.serializers.SerializerBuilder;
import com.ovidiucb.shapes.serializers.VisitableShape;
import com.ovidiucb.shapes.shapes.CompositeShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by ovidiucb
 */
@Service
public class WebAppShapeSerializer {

    @Autowired
    private ObjectMapper mapper;
    private CompositeShape root;

    private void setUp() {
        root = new CompositeShape("root");
        CompositeShape graphic1 = new CompositeShape("g1");

        root.addAll(ShapeGenerator.generateShapes(2));
        graphic1.addAll(ShapeGenerator.generateShapes(2));
        graphic1.add(graphic1);
    }

    public CompositeShape getRoot() {
        return root;
    }

    public String readFromFile(String fileName) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }

            return sb.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return "";
    }

    public void writeToFile(String fileName) {
        setUp();

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            VisitableShape visitableCompositeShape = new VisitableShape(getRoot());
            String json = visitableCompositeShape.accept(SerializerBuilder.buildJSONSerializer());

            bw.write(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
