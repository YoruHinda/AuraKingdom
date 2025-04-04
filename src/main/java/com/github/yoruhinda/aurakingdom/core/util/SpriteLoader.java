package main.java.com.github.yoruhinda.aurakingdom.core.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpriteLoader {
    public static final String RESOURCE_FOLDER = "main/resources/";

    public static List<BufferedImage> getWarriorSprite(String warriorSpriteDir){
        List<BufferedImage> warriorSprites = new ArrayList<>();
        try {
            File file = new File(SpriteLoader.class.getClassLoader().getResource(RESOURCE_FOLDER + warriorSpriteDir).getPath());
            for (File listFile : file.listFiles()) {
                warriorSprites.add(ImageIO.read(listFile));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return warriorSprites;
    }

    public static BufferedImage getTileMap(String tileMapDir){
        try {
            return ImageIO.read(SpriteLoader.class.getClassLoader().getResource(RESOURCE_FOLDER + tileMapDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
