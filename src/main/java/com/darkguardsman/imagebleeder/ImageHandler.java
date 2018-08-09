package com.darkguardsman.imagebleeder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 7/28/2018.
 */
public class ImageHandler
{
    /**
     * Copies tile image to new location
     *
     * @param image      - image to read
     * @param edit_image - image to output
     * @param grid_size  - size of the tile
     * @param spacing    - spacing for the tile
     * @param w          - tile index x
     * @param h          - tile index y
     * @param x          - edit image output x start
     * @param y          - edit image output y start
     */
    public static void handleCenter(BufferedImage image, BufferedImage edit_image, int grid_size, int spacing, int w, int h, int x, int y)
    {
        for (int i = 0; i < grid_size; i++) //x
        {
            for (int j = 0; j < grid_size; j++) //y
            {
                //random color
                int pixel = image.getRGB(w * grid_size + i, h * grid_size + j);

                edit_image.setRGB(x + spacing + i, y + spacing + j, pixel);
            }
        }
    }

    /**
     * Generate corners
     *
     * @param image      - image to read
     * @param edit_image - image to output
     * @param grid_size  - size of the tile
     * @param spacing    - spacing for the tile
     * @param w          - tile index x
     * @param h          - tile index y
     * @param x          - edit image output x start
     * @param y          - edit image output y start
     */
    public static void handleCorners(BufferedImage image, BufferedImage edit_image, int grid_size, int spacing, int w, int h, int x, int y)
    {
        //TOP-LEFT corner
        int pixel = image.getRGB(w * grid_size, h * grid_size);
        for (int i = 0; i < spacing; i++) //x
        {
            for (int j = 0; j < spacing; j++) //y
            {
                edit_image.setRGB(x + i, y + j, pixel);
            }
        }

        //TOP-RIGHT corner
        pixel = image.getRGB(w * grid_size + (grid_size - 1), h * grid_size);
        for (int i = 0; i < spacing; i++) //x
        {
            for (int j = 0; j < spacing; j++) //y
            {
                edit_image.setRGB(x + grid_size + spacing + i, y + j, pixel);
            }
        }

        //BOTTOM-LEFT corner
        pixel = image.getRGB(w * grid_size, h * grid_size + (grid_size - 1));
        for (int i = 0; i < spacing; i++) //x
        {
            for (int j = 0; j < spacing; j++) //y
            {
                edit_image.setRGB(x + i, y + grid_size + spacing + j, pixel);
            }
        }

        //BOTTOM-RIGHT corner
        pixel = image.getRGB(w * grid_size + (grid_size - 1), h * grid_size + (grid_size - 1));
        for (int i = 0; i < spacing; i++) //x
        {
            for (int j = 0; j < spacing; j++) //y
            {
                edit_image.setRGB(x + grid_size + spacing + i, y + grid_size + spacing + j, pixel);
            }
        }
    }

    /**
     * Extrudes right edge
     *
     * @param image      - image to read
     * @param edit_image - image to output
     * @param grid_size  - size of the tile
     * @param spacing    - spacing for the tile
     * @param w          - tile index x
     * @param h          - tile index y
     * @param x          - edit image output x start
     * @param y          - edit image output y start
     */
    public static void handleRightEdge(BufferedImage image, BufferedImage edit_image, int grid_size, int spacing, int w, int h, int x, int y)
    {
        for (int b = 0; b < spacing; b++) //Lines
        {
            for (int i = 0; i < grid_size; i++) //Pixels for line
            {
                int pixel = image.getRGB(w * grid_size + grid_size - 1, h * grid_size + i);
                edit_image.setRGB(x + b + grid_size + spacing, y + spacing + i, pixel);
            }
        }
    }

    /**
     * Extrudes left edge
     *
     * @param image      - image to read
     * @param edit_image - image to output
     * @param grid_size  - size of the tile
     * @param spacing    - spacing for the tile
     * @param w          - tile index x
     * @param h          - tile index y
     * @param x          - edit image output x start
     * @param y          - edit image output y start
     */
    public static void handleLeftEdge(BufferedImage image, BufferedImage edit_image, int grid_size, int spacing, int w, int h, int x, int y)
    {
        for (int b = 0; b < spacing; b++) //Lines
        {
            for (int i = 0; i < grid_size; i++) //Pixels for line
            {
                int pixel = image.getRGB(w * grid_size, h * grid_size + i);
                edit_image.setRGB(x + b, y + spacing + i, pixel);
            }
        }
    }

    /**
     * Extrudes top edge
     *
     * @param image      - image to read
     * @param edit_image - image to output
     * @param grid_size  - size of the tile
     * @param spacing    - spacing for the tile
     * @param w          - tile index x
     * @param h          - tile index y
     * @param x          - edit image output x start
     * @param y          - edit image output y start
     */
    public static void handleTopEdge(BufferedImage image, BufferedImage edit_image, int grid_size, int spacing, int w, int h, int x, int y)
    {
        for (int b = 0; b < spacing; b++) //Lines
        {
            for (int i = 0; i < grid_size; i++) //Pixels for line
            {
                int pixel = image.getRGB(w * grid_size + i, h * grid_size);
                edit_image.setRGB(x + i + spacing, y + b, pixel);
            }
        }
    }

    /**
     * Extrudes bottom edge
     *
     * @param image      - image to read
     * @param edit_image - image to output
     * @param grid_size  - size of the tile
     * @param spacing    - spacing for the tile
     * @param w          - tile index x
     * @param h          - tile index y
     * @param x          - edit image output x start
     * @param y          - edit image output y start
     */
    public static void handleBottomEdge(BufferedImage image, BufferedImage edit_image, int grid_size, int spacing, int w, int h, int x, int y)
    {
        for (int b = 0; b < spacing; b++) //Lines
        {
            for (int i = 0; i < grid_size; i++) //Pixels for line
            {
                int pixel = image.getRGB(w * grid_size + i, h * grid_size + grid_size - 1);
                edit_image.setRGB(x + i + spacing, y + b + spacing + grid_size, pixel);
            }
        }
    }

    /**
     * Generates random tiles for testing logic
     *
     * @param grid_size - size of the tiles, try to match width:height ratio
     * @param width     - width of the image to create
     * @param height    - height of the image to create
     * @return generated image that looks like random noise
     */
    public static BufferedImage generateRandomImageGrid(int grid_size, int width, int height)
    {
        //Get number of tiles in sheet (assume no existing spacing or edges)
        final int tiles_w = width / grid_size;
        final int tiles_h = height / grid_size;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //Loop through tiles
        for (int w = 0; w < tiles_w; w++)
        {
            for (int h = 0; h < tiles_h; h++)
            {
                int x = w * grid_size;
                int y = h * grid_size;

                //Generate random pixels for testing
                for (int i = 0; i < grid_size; i++) //x
                {
                    for (int j = 0; j < grid_size; j++) //y
                    {
                        //random color
                        Color color = new Color(
                                (int) Math.floor(Math.random() * 255),
                                (int) Math.floor(Math.random() * 255),
                                (int) Math.floor(Math.random() * 255));

                        image.setRGB(x + i, y + j, color.getRGB());
                    }
                }
            }
        }
        return image;
    }

    /**
     * Extrudes the edges of the tiles
     *
     * @param image     - image to pull pixel data from
     * @param grid_size - size of each tile in the image
     * @param spacing   - spacing to extrude around tile
     * @return image with extruded edges
     */
    public static BufferedImage extrudeEdges(BufferedImage image, int grid_size, int spacing)
    {
        //Get size of image
        final int width = image.getWidth();
        final int height = image.getHeight();

        //Get number of tiles in sheet (assume no existing spacing or edges)
        final int tiles_w = width / grid_size;
        final int tiles_h = height / grid_size;

        //Get spacing to add
        final int space_w = tiles_w * spacing * 2; //2 spacers, 1 on each side
        final int space_h = tiles_h * spacing * 2;

        //Figure out the size of each output slot (saves math later)
        final int size_per_slot = spacing * 2 + grid_size;

        //Create new image with increased size for spacing
        BufferedImage edit_image = new BufferedImage(width + space_w, height + space_h, BufferedImage.TYPE_INT_ARGB);

        //Loop through tiles
        for (int tile_x = 0; tile_x < tiles_w; tile_x++)
        {
            for (int tile_y = 0; tile_y < tiles_h; tile_y++)
            {
                final int x = tile_x * size_per_slot;
                final int y = tile_y * size_per_slot;

                //Copy over images
                handleCenter(image, edit_image, grid_size, spacing, tile_x, tile_y, x, y);

                //Corners
                handleCorners(image, edit_image, grid_size, spacing, tile_x, tile_y, x, y);

                //Left side
                handleLeftEdge(image, edit_image, grid_size, spacing, tile_x, tile_y, x, y);

                //Right side
                handleRightEdge(image, edit_image, grid_size, spacing, tile_x, tile_y, x, y);

                //Top side
                handleTopEdge(image, edit_image, grid_size, spacing, tile_x, tile_y, x, y);

                //Bottom side
                handleBottomEdge(image, edit_image, grid_size, spacing, tile_x, tile_y, x, y);
            }
        }

        return edit_image;
    }
}
