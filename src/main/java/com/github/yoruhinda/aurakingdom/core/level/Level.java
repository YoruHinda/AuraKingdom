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
    private List<Layer> layers;
    private ObjectMapper objectMapper;
    private SpriteSheet spriteSheet;

    public Level(String levelName) {
        this.levelName = levelName;
        this.spriteSheet = new SpriteSheet(SpriteLoader.getTileMap(MapDirectory.MAP));
        this.objectMapper = new ObjectMapper();
        this.layers = new ArrayList<>();
        spriteSheet.withSpriteSize(16, 16);
        spriteSheet.withRowsAndCols(10, 31);
        convertJsonInLayer();
    }

    public void render(Graphics graphics) {
        for (Layer layer : layers) {
            if(layer.getLayerType().equals(LayerType.IMAGE_LAYER)){
                graphics.drawImage(layer.getImage(), 0, 0, layer.getImage().getWidth() * GameWindow.SCALE, layer.getImage().getHeight() * GameWindow.SCALE, null);
            }

            if(layer.getLayerType().equals(LayerType.TILE_LAYER)){
                for(int row = 0; row < layer.getData().length; row++){
                    for(int col = 0; col < layer.getData()[0].length; col++){
                        if(layer.getData()[row][col] == 0) continue;
                        graphics.drawImage(spriteSheet.sprite().get(layer.getData()[row][col] - 1), col * GameWindow.TILE_SIZE, row * GameWindow.TILE_SIZE, GameWindow.TILE_SIZE, GameWindow.TILE_SIZE, null);
                    }
                }
            }
        }
    }

    private void convertJsonInLayer(){
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(this.getClass().getClassLoader().getResource(SpriteLoader.RESOURCE_FOLDER + "/levels/" + levelName + ".json").getPath()));
            for(JsonNode node : jsonNode.get("layers")){
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
            throw new RuntimeException(e);
        }
    }
}