package main.java.com.github.yoruhinda.aurakingdom.core.level.layer;

import java.awt.image.BufferedImage;
import java.util.List;

public class TileLayer {
    private int id;
    private String name;
    private int[][] data;
    private List<BufferedImage> tiles;

    public TileLayer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
