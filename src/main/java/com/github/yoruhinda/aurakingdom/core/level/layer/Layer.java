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
        this.data = new int[16][8];
        convertJsonDataToMultiDimensionalArrayData(data);
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

    public void convertJsonDataToMultiDimensionalArrayData(int[] data){
        for(int x = 0; x < 16; x++){
            for(int y = 0;y < 8;y++){
                this.data[x][y] = data[x * 8 + y];
            }
        }
    }

    public int[][] getData() {
        return data;
    }
}
