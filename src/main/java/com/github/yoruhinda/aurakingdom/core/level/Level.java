package main.java.com.github.yoruhinda.aurakingdom.core.level;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.github.yoruhinda.aurakingdom.core.entity.player.Player;
import main.java.com.github.yoruhinda.aurakingdom.core.level.layer.Layer;
import main.java.com.github.yoruhinda.aurakingdom.core.level.layer.LayerType;
import main.java.com.github.yoruhinda.aurakingdom.core.util.SpriteLoader;

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

    public Level(String levelName){
        convertJsonInLayerClass();
        Layer layer1 = layers.stream().filter(layer -> layer.getLayerType().equals(LayerType.TILE_LAYER)).findFirst().orElseThrow();
    }

    public void render(){

    }

    private void convertJsonInLayerClass(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            layers = new ArrayList<>();
            JsonNode jsonNode = objectMapper.readTree(new File(this.getClass().getClassLoader().getResource(SpriteLoader.RESOURCE_FOLDER + "/levels/" + levelName + ".json").getPath()));
            for (JsonNode node : jsonNode.get("layers")) {
                if(node.get("type").asText().equalsIgnoreCase(LayerType.TILE_LAYER.getLayerType())){
                    List<Integer> tileData = new ArrayList<>();
                    for (JsonNode data : node.get("data")) {
                        tileData.add(data.asInt());
                    }
                    int[] array = tileData.stream().mapToInt(i -> i).toArray();
                    layers.add(new Layer(node.get("id").asInt(), node.get("type").asText(), node.get("name").asText(), array));
                }else{
                    layers.add(new Layer(node.get("id").asInt(), node.get("type").asText() ,node.get("name").asText()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
