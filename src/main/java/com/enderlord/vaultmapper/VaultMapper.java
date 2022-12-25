package com.enderlord.vaultmapper;

import com.enderlord.vaultmapper.gui.VaultMapOverlay;
import com.enderlord.vaultmapper.shapes.VaultShapes;
import com.mojang.logging.LogUtils;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;

@Mod("vaultmapper")
public class VaultMapper
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    private static VaultMapOverlay graphicmap;
    private boolean mapping = false;
    private boolean portalRoomWalled = false;
    private Pair<Integer, Integer> lastPlayerCoordinates;
    private List<boolean[][]> predictedShapes = new ArrayList<>();
    private String currentVault = "";

    public VaultMapper() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        graphicmap = new VaultMapOverlay();
        OverlayRegistry.registerOverlayBottom("Vault Map", graphicmap);
        OverlayRegistry.enableOverlay(graphicmap, false);
    }

    private void enableMap() {
        mapping = true;
        portalRoomWalled = false;

        graphicmap.discoverRoom(0,0);
        graphicmap.setStartingRoom(0,0);
        graphicmap.togglePlayerRoom(0,0);
        lastPlayerCoordinates = new Pair<>(0,0);

        predictedShapes = VaultShapes.possibleShapes();

        graphicmap.setPredicted(predictedShapes.get(0));

        OverlayRegistry.enableOverlay(graphicmap, true);
    }
    private void disableMap() {
        OverlayRegistry.enableOverlay(graphicmap, false);

        mapping = false;
        portalRoomWalled = false;
        lastPlayerCoordinates = new Pair<>(0,0);
        predictedShapes = new ArrayList<>();
        graphicmap.reset();

        currentVault = "";
    }
    private int clamp(int input) {
        int output = input;
        if (output > 8) {
            output = 8;
        } else if (output < -8) {
            output = -8;
        }
        return output;
    }
    private void moveNorth() {
        if (!portalRoomWalled) {
            System.out.println("WALLING POTALLL");
            portalRoomWalled = true;
            graphicmap.toggleEastWall(0,0);
            graphicmap.toggleSouthWall(0,0);
            graphicmap.toggleWestWall(0,0);
        }
        graphicmap.togglePlayerRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        lastPlayerCoordinates = new Pair<>(lastPlayerCoordinates.getA(), clamp(lastPlayerCoordinates.getB() + 1));
        graphicmap.discoverRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        updatePredictionWithDiscovery(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        graphicmap.togglePlayerRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
    }
    private void moveEast() {
        if (!portalRoomWalled) {
            portalRoomWalled = true;
            graphicmap.toggleNorthWall(0,0);
            graphicmap.toggleSouthWall(0,0);
            graphicmap.toggleWestWall(0,0);
        }
        graphicmap.togglePlayerRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        lastPlayerCoordinates = new Pair<>(clamp(lastPlayerCoordinates.getA() + 1), lastPlayerCoordinates.getB());
        graphicmap.discoverRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        updatePredictionWithDiscovery(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        graphicmap.togglePlayerRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
    }
    private void moveSouth() {
        if (!portalRoomWalled) {
            portalRoomWalled = true;
            graphicmap.toggleNorthWall(0,0);
            graphicmap.toggleEastWall(0,0);
            graphicmap.toggleWestWall(0,0);
        }
        graphicmap.togglePlayerRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        lastPlayerCoordinates = new Pair<>(lastPlayerCoordinates.getA(), clamp(lastPlayerCoordinates.getB() - 1));
        graphicmap.discoverRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        updatePredictionWithDiscovery(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        graphicmap.togglePlayerRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
    }
    private void moveWest() {
        if (!portalRoomWalled) {
            portalRoomWalled = true;
            graphicmap.toggleNorthWall(0,0);
            graphicmap.toggleEastWall(0,0);
            graphicmap.toggleSouthWall(0,0);
        }
        graphicmap.togglePlayerRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        lastPlayerCoordinates = new Pair<>(clamp(lastPlayerCoordinates.getA() - 1), lastPlayerCoordinates.getB());
        graphicmap.discoverRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        updatePredictionWithDiscovery(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
        graphicmap.togglePlayerRoom(lastPlayerCoordinates.getA(), lastPlayerCoordinates.getB());
    }
    private void updatePredictionWithDiscovery(int x, int y) {
        if (predictedShapes.size() > 1) {
            for (int i = 0; i < predictedShapes.size(); i++) {
                if (!predictedShapes.get(i)[x + 8][8 - y]) {
                    predictedShapes.remove(i);
                }
            }
            graphicmap.setPredicted(predictedShapes.get(0));
        }
    }
    private void updatePredictionWithWall(int x, int y) {
        if (predictedShapes.size() > 1) {
            for (int i = 0; i < predictedShapes.size(); i++) {
                if (predictedShapes.get(i)[x + 8][8 - y]) {
                    predictedShapes.remove(i);
                }
            }
            graphicmap.setPredicted(predictedShapes.get(0));
        }
    }

    @SubscribeEvent
    public void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.getTo().location().toString().matches("minecraft:the_nether")) {// test with minecraft:the_nether the_vault:vault_.*
            enableMap();
            currentVault = event.getTo().location().toString();
        } else {
            disableMap();
        }
    }

    @SubscribeEvent
    public void onPlayerDeath(PlayerEvent.PlayerRespawnEvent event) {
        disableMap();
    }

    @SubscribeEvent
    public void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getPlayer().level.dimension().location().toString().equals(currentVault)) {
            disableMap();
        }
    }

    @SubscribeEvent
    public void onPlayerChat(ClientChatEvent event) {
        if (event.getMessage().equals("WALL")) {
            graphicmap.toggleNorthWall(0,0);
            graphicmap.toggleEastWall(0,0);
            graphicmap.toggleSouthWall(0,0);
            graphicmap.toggleWestWall(0,0);
        } else if (event.getMessage().equals("RESET")) {
            disableMap();
            enableMap();
        }
        if (mapping) {
            if (event.getMessage().toLowerCase().contains("wall")) {
                String messageWithoutWall = event.getMessage().toLowerCase().replace("wall", "");
                if (messageWithoutWall.contains("n")) {
                    graphicmap.toggleNorthWall(lastPlayerCoordinates.getA(),lastPlayerCoordinates.getB());
                    updatePredictionWithWall(lastPlayerCoordinates.getA(),clamp(lastPlayerCoordinates.getB() + 1));
                }
                if (messageWithoutWall.contains("e")) {
                    graphicmap.toggleEastWall(lastPlayerCoordinates.getA(),lastPlayerCoordinates.getB());
                    updatePredictionWithWall(clamp(lastPlayerCoordinates.getA() + 1),lastPlayerCoordinates.getB());
                }
                if (messageWithoutWall.contains("s")) {
                    graphicmap.toggleSouthWall(lastPlayerCoordinates.getA(),lastPlayerCoordinates.getB());
                    updatePredictionWithWall(lastPlayerCoordinates.getA(),clamp(lastPlayerCoordinates.getB() - 1));
                }
                if (messageWithoutWall.contains("w")) {
                    graphicmap.toggleWestWall(lastPlayerCoordinates.getA(),lastPlayerCoordinates.getB());
                    updatePredictionWithWall(clamp(lastPlayerCoordinates.getA() - 1),lastPlayerCoordinates.getB());
                }
            } else if (event.getMessage().length() == 1) {
                String lowercaseMessage = event.getMessage().toLowerCase();
                switch (lowercaseMessage) {
                    case "n" -> moveNorth();
                    case "e" -> moveEast();
                    case "s" -> moveSouth();
                    case "w" -> moveWest();
                }
            }
        }
    }
}
