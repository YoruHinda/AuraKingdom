package com.github.yoruhinda.aurakingdom.core.util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class SpriteSheet {
    private BufferedImage spriteSheet;
    private int rows, cols;
    private int spriteWidth, spriteHeight;
    private int spriteCount;

    public SpriteSheet(BufferedImage spriteSheet){
        this.spriteSheet = spriteSheet;
    }

    public List<BufferedImage> sprite(){
        int rows = this.rows;
        int cols = this.cols;
        int count = spriteCount;
        if(spriteCount == 0){
            count = rows * cols;
        }
        BufferedImage sheet = this.spriteSheet;
        int width = this.spriteWidth;
        int height = this.spriteHeight;
        if(width == 0){
            width = sheet.getWidth() / rows;
        }
        if(height == 0){
            height = sheet.getHeight() / cols;
        }

        int x = 0;
        int y = 0;
        List<BufferedImage> sprites = new ArrayList<>(count);
        for(int i = 0; i < count; i++){
            sprites.add(sheet.getSubimage(x, y, width, height));
            x += width;
            if(x >= width * cols){
                x = 0;
                y += height;
            }
        }
        return sprites;
    }

    public void withRowsAndCols(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public void withSpriteSize(int spriteWidth, int spriteHeight){
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
    }

    public void setSpriteCount(int spriteCount){
        this.spriteCount = spriteCount;
    }
}
