import java.util.*;
import java.awt.*;

public class TileManager {
    
    private ArrayList<Tile> tiles;

    public TileManager() {
        tiles = new ArrayList<Tile>();
    }

    public void addTile(Tile rect) {
        tiles.add(rect);
    }

    public void drawAll(Graphics g) {
        for (Tile tile: tiles) {
            tile.draw(g);
        }
    }

    public void raise(int x, int y) {
        
        Tile tileRaised = null;
        for (Tile tile: tiles) {
            int xPos = tile.getX();
            int yPos = tile.getY();
            // if x-pos <= x <= x-pos + width
            // if y-pos <= y <= y-pos + height
            if (xPos <= x && x <= (xPos + tile.getWidth()) && yPos <= y && y <= (yPos + tile.getHeight())) {
                tileRaised = tile;
            }
        }
        if (tileRaised != null) {
            tiles.remove(tileRaised);
            tiles.add(tileRaised);
        }
    }

    public void lower(int x, int y) {
        Tile tileLowered = null;
        for (Tile tile: tiles) {
            int xPos = tile.getX();
            int yPos = tile.getY();
            // if x-pos <= x <= x-pos + width
            // if y-pos <= y <= y-pos + height
            if (xPos <= x && x <= (xPos + tile.getWidth()) && yPos <= y && y <= (yPos + tile.getHeight())) {
                tileLowered = tile;
            }
        }
        if (tileLowered != null) {
            tiles.remove(tileLowered);
            tiles.add(0, tileLowered);
        }
    }

    public void delete(int x, int y) {
        Tile tileDeleted = null;
        for (Tile tile: tiles) {
            int xPos = tile.getX();
            int yPos = tile.getY();
            // if x-pos <= x <= x-pos + width
            // if y-pos <= y <= y-pos + height
            if (xPos <= x && x <= (xPos + tile.getWidth()) && yPos <= y && y <= (yPos + tile.getHeight())) {
                tileDeleted = tile;
            }
        }
        if (tileDeleted != null) {
            tiles.remove(tileDeleted);
        }
    }

    public void deleteAll(int x, int y) {
        ArrayList<Tile> tilesDeleted = new ArrayList<Tile>();
        for (Tile tile: tiles) {
            int xPos = tile.getX();
            int yPos = tile.getY();
            // if x-pos <= x <= x-pos + width
            // if y-pos <= y <= y-pos + height
            if (xPos <= x && x <= (xPos + tile.getWidth()) && yPos <= y && y <= (yPos + tile.getHeight())) {
                tilesDeleted.add(tile);
            }
        }
        for (Tile tile: tilesDeleted) {
            tiles.remove(tile);
        }
    }

    public void shuffle(int width, int height) {
        Collections.shuffle(tiles);
        for (int i = 0; i < tiles.size(); i++) {
            // set the tile a random x position between 0 and widthWindow - widthTile
            // set the tile a random y position between 0 and heightWindow - heightTile
            tiles.get(i).setX((int)(Math.random() * (width - tiles.get(i).getX())));
            tiles.get(i).setY((int)(Math.random() * (height - tiles.get(i).getY())));
        }
    }

}