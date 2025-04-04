package main.java.com.github.yoruhinda.aurakingdom.core.level.layer;

public enum LayerType {
    IMAGE_LAYER("imagelayer"), TILE_LAYER("tilelayer");

    private String layerType;

    LayerType(String layerType){
        this.layerType = layerType;
    }

    public String getLayerType() {
        return layerType;
    }
}
