package main.java.com.github.yoruhinda.aurakingdom.core.level.layer;

import java.io.File;

public class Layer {
    private int id;
    private String name;
    private LayerType layerType;
    private int[][] data;
    private File image;

    public Layer(int id, String layerType, String name, int[] data) {
        this.id = id;
        this.name = name;
        if(layerType.equalsIgnoreCase("imagelayer")) this.layerType = LayerType.IMAGE_LAYER;
        if(layerType.equalsIgnoreCase("tilelayer")) this.layerType = LayerType.TILE_LAYER;
    }

    public Layer(int id, String layerType, String name) {
        this.id = id;
        this.name = name;
        if(layerType.equalsIgnoreCase("imagelayer")) this.layerType = LayerType.IMAGE_LAYER;
        if(layerType.equalsIgnoreCase("tilelayer")) this.layerType = LayerType.TILE_LAYER;
    }

    public LayerType getLayerType() {
        return layerType;
    }
}
