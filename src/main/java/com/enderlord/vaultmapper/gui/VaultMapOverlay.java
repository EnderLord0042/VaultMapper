package com.enderlord.vaultmapper.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;

public class VaultMapOverlay implements IIngameOverlay {

    private byte[][] roomGrid = new byte[17][17];
    private static final int WIDTH = 85;
    private static final int HEIGHT = 85;

    public void reset() {
        roomGrid = new byte[17][17];
    }
    private void renderRoom(PoseStack poseStack,int roomX, int roomY, byte roomInfo) {
        if (isDiscovered(roomInfo)) {
            ForgeIngameGui.fill(poseStack, roomX, roomY, roomX + 5, roomY + 5, 0xFFFFFFFF);
            if (isPlayerRoom(roomInfo)) {
                ForgeIngameGui.fill(poseStack, roomX + 1, roomY + 1, roomX + 4, roomY + 4, 0xFFFF0000);
            }
            if (isStartingRoom(roomInfo)) {
                ForgeIngameGui.fill(poseStack, roomX + 1, roomY + 1, roomX + 4, roomY + 4, 0xFF00FF00);
            }
        } else if (isPredicted(roomInfo)) {
            poseStack.translate(0.0F,0.0F,-100.0F);
            ForgeIngameGui.fill(poseStack, roomX, roomY, roomX + 5, roomY + 5, 0xFF808080);
            poseStack.translate(0.0F,0.0F,100.0F);
        }
        poseStack.translate(0.0F,0.0F,100.0F);
        if (hasNorthWall(roomInfo)) {
            ForgeIngameGui.fill(poseStack, roomX, roomY, roomX + 5, roomY + 1, 0xFF000000);
        }
        if (hasEastWall(roomInfo)) {
            ForgeIngameGui.fill(poseStack, roomX + 4, roomY, roomX + 5, roomY + 5, 0xFF000000);
        }
        if (hasSouthWall(roomInfo)) {
            ForgeIngameGui.fill(poseStack, roomX, roomY + 5, roomX + 5, roomY + 4, 0xFF000000);
        }
        if (hasWestWall(roomInfo)) {
            ForgeIngameGui.fill(poseStack, roomX, roomY, roomX + 1, roomY + 5, 0xFF000000);
        }
        poseStack.translate(0.0F,0.0F,-100.0F);

    }

    private boolean isDiscovered(byte roomInfo) {
        return (roomInfo & 0x01) == 0x01;
    }
    private boolean isStartingRoom(byte roomInfo) {
        return (roomInfo & 0x02) == 0x02;
    }
    private boolean isPlayerRoom(byte roomInfo) {
        return (roomInfo & 0x04) == 0x04;
    }
    private boolean isPredicted(byte roomInfo) {
        return (roomInfo & 0x08) == 0x08;
    }
    private boolean hasNorthWall(byte roomInfo) {
        return (roomInfo & 0x10) == 0x10;
    }
    private boolean hasEastWall(byte roomInfo) {
        return (roomInfo & 0x20) == 0x20;
    }
    private boolean hasSouthWall(byte roomInfo) {
        return (roomInfo & 0x40) == 0x40;
    }
    private boolean hasWestWall(byte roomInfo) {
        return (roomInfo & 0x80) == 0x80;
    }

    public void discoverRoom(int x, int y) {
        roomGrid[x + 8][8 - y] = (byte)(roomGrid[x + 8][8 - y] | 0x01);
    }

    public void setStartingRoom(int x, int y) {
        roomGrid[x + 8][8 - y] = (byte)(roomGrid[x + 8][8 - y] | 0x02);
    }

    public void togglePlayerRoom(int x, int y) {
        roomGrid[x + 8][8 - y] = (byte)(roomGrid[x + 8][8 - y] ^ 0x04);
    }
    public void toggleNorthWall(int x, int y) {
        roomGrid[x + 8][8 - y] = (byte)(roomGrid[x + 8][8 - y] ^ 0x10);
    }
    public void toggleEastWall(int x, int y) {
        roomGrid[x + 8][8 - y] = (byte)(roomGrid[x + 8][8 - y] ^ 0x20);
    }
    public void toggleSouthWall(int x, int y) {
        roomGrid[x + 8][8 - y] = (byte)(roomGrid[x + 8][8 - y] ^ 0x40);
    }
    public void toggleWestWall(int x, int y) {
        roomGrid[x + 8][8 - y] = (byte)(roomGrid[x + 8][8 - y] ^ 0x80);
    }
    public void setPredicted(boolean[][] predictedShape) {
        for (int y = 0; y < 17; y++) {
            for (int x = 0; x < 17;x++) {
                if (predictedShape[x][y]) {
                    roomGrid[x][y] = (byte)(roomGrid[x][y] | 0x08);
                }
            }
        }
    }

    public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        gui.setupOverlayRenderState(true, true);
        for (int y = 0; y < 17; y++) {
            for (int x = 0; x < 17;x++) {
                renderRoom(poseStack, screenWidth - 10 - WIDTH + 5*x, 10 + 5*y, roomGrid[x][y]);
            }
        }
    }

}
