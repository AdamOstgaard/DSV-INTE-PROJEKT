package com.Grupp25.app.board.Textures;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class TextureHandler {
    private static HashMap<String, Image> textures;

    public TextureHandler() {

    }

    public Image getGrassTexture() {
        return getTexture("tile_grass.png");
    }

    public Image rockTexture() {
        return getTexture("tile_rock.png");
    }

    /**
     * gets the texture from the specified filename. Textures has to reside in the
     * same folder as this class.
     */
    private Image getTexture(String fileName) {
        try {
            if (textures.get(fileName) == null) {
                URL url = getClass().getResource(fileName);
                File file = new File(url.getPath());
                textures.put(fileName, ImageIO.read(file));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return textures.get(fileName);
    }
}