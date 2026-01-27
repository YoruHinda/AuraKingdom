package com.github.yoruhinda.aurakingdom.core.level.layer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Layer {
    private int id;
    private String name;
    private LayerType layerType;
    private int[][] data;
    private BufferedImage image;

    public Layer(int id, String layerType, String name, int[] data) {
        this.id = id;
        this.name = name;
        this.data = new int[8][16];
        convertJsonDataToMultiDimensionalArrayData(data);
        verifyTileType(layerType);
    }

    public Layer(int id, String layerType, String name, String image) {
        this.id = id;
        this.name = name;
        try {
            this.image = ImageIO.read(this.getClass().getClassLoader().getResource(image));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        verifyTileType(layerType);
    }

    private void verifyTileType(String layerType) {
        if (layerType.equalsIgnoreCase("imagelayer")) this.layerType = LayerType.IMAGE_LAYER;
        if (layerType.equalsIgnoreCase("tilelayer")) this.layerType = LayerType.TILE_LAYER;
    }

    public LayerType getLayerType() {
        return layerType;
    }

    public void convertJsonDataToMultiDimensionalArrayData(int[] data) {
        for (int row = 0; row < 8; row++) {
            System.arraycopy(data, row * 16, this.data[row], 0, 16);
        }
    }

    public int[][] getData() {
        return data;
    }

    public BufferedImage getImage() {
        return image;
    }
}
