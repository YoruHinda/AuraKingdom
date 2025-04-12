package main.java.com.github.yoruhinda.aurakingdom.core.level.layer;

import java.awt.image.BufferedImage;

public class ImageLayer {
    private int id;
    private String name;
    private BufferedImage image;

    public ImageLayer(int id, String name, BufferedImage image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }
}
