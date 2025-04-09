package main.java.com.github.yoruhinda.aurakingdom.core.level;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.github.yoruhinda.aurakingdom.core.entity.player.Player;
import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameWindow;
import main.java.com.github.yoruhinda.aurakingdom.core.level.layer.Layer;
import main.java.com.github.yoruhinda.aurakingdom.core.level.layer.LayerType;
import main.java.com.github.yoruhinda.aurakingdom.core.util.SpriteLoader;
import main.java.com.github.yoruhinda.aurakingdom.core.util.SpriteSheet;
import main.java.com.github.yoruhinda.aurakingdom.core.util.resourcedirectory.MapDirectory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private String levelName;
    private Player player;
    private int[] enemies;
    private int[][][] levelTileMap;
    private List<Layer> layers;
    private SpriteSheet spriteSheet;

    public Level(String levelName) {
        this.levelName = levelName;
        this.spriteSheet = new SpriteSheet(SpriteLoader.getTileMap(MapDirectory.MAP));
        spriteSheet.withSpriteSize(16, 16);
        spriteSheet.withRowsAndCols(10, 31);
        convertJsonInLayerClass();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(layers.get(0).getImage(),0,0, layers.get(0).getImage().getWidth() * GameWindow.SCALE, layers.get(0).getImage().getHeight() * GameWindow.SCALE, null);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 16; col++) {
                if (layers.get(1).getData()[row][col] == 0) {
                    continue;
                }
                graphics.drawImage(spriteSheet.sprite().get(layers.get(1).getData()[row][col] - 1), col * GameWindow.TILE_SIZE, row * GameWindow.TILE_SIZE, GameWindow.TILE_SIZE, GameWindow.TILE_SIZE, null);
            }
        }
    }

    private void convertJsonInLayerClass() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            layers = new ArrayList<>();
            JsonNode jsonNode = objectMapper.readTree(new File(this.getClass().getClassLoader().getResource(SpriteLoader.RESOURCE_FOLDER + "/levels/" + levelName + ".json").getPath()));
            for (JsonNode node : jsonNode.get("layers")) {
                if (node.get("type").asText().equalsIgnoreCase(LayerType.TILE_LAYER.getLayerType())) {
                    List<Integer> tileData = new ArrayList<>();
                    for (JsonNode data : node.get("data")) {
                        tileData.add(data.asInt());
                    }
                    int[] array = tileData.stream().mapToInt(i -> i).toArray();
                    layers.add(new Layer(node.get("id").asInt(), node.get("type").asText(), node.get("name").asText(), array));
                } else {
                    layers.add(new Layer(node.get("id").asInt(), node.get("type").asText(), node.get("name").asText(), node.get("image").asText()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
