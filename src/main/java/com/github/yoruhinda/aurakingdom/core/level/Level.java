package main.java.com.github.yoruhinda.aurakingdom.core.level;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.github.yoruhinda.aurakingdom.core.entity.player.Player;
import main.java.com.github.yoruhinda.aurakingdom.core.level.layer.LayerType;

import java.io.File;
import java.io.IOException;

public class Level {
    private String levelName;
    private Player player;
    private int[] enemies;
    private LayerType layerType;
    private int[][][] levelTileMap;

    public Level(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(this.getClass().getClassLoader().getResource("main/resources/levels/starter_level.json").getPath()));
            System.out.println(jsonNode.get("layers"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(){

    }
}
