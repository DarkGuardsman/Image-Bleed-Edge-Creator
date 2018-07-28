package com.darkguardsman.imagebleeder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Test grid pattern
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 7/27/2018.
 */
public class GridMaker
{
    public static void main(String args[]) throws IOException
    {

        final int grid_size = 16;
        final int spacing = 2;

        //Get size of image
        final int width = 256;
        final int height = 256;

        //Get number of tiles in sheet (assume no existing spacing or edges)
        final int tiles_w = width / grid_size;
        final int tiles_h = height / grid_size;

        //Get spacing to add
        final int space_w = tiles_w * spacing * 2; //2 spacers, 1 on each side
        final int space_h = tiles_h * spacing * 2;

        final int size_per_slot = spacing * 2 + grid_size;

        //Create new image with increased size for spacing
        BufferedImage edit_image = new BufferedImage(width + space_w, height + space_h, BufferedImage.TYPE_INT_ARGB);

        //Loop through tiles
        for (int w = 0; w < tiles_w; w++)
        {
            for (int h = 0; h < tiles_h; h++)
            {
                int x = w * size_per_slot;
                int y = h * size_per_slot;

                //Generate random pixels for testing
                for (int i = 0; i < grid_size; i++) //x
                {
                    for (int j = 0; j < grid_size; j++) //y
                    {
                        //random color
                        Color color = new Color(
                                (int)Math.floor(Math.random() * 255),
                                (int)Math.floor(Math.random() * 255),
                                (int)Math.floor(Math.random() * 255));

                        edit_image.setRGB(x + spacing + i, y + spacing + j, color.getRGB());
                    }
                }

                //TOP-LEFT corner
                edit_image.setRGB(x, y, Color.CYAN.getRGB()); //TODO handle spacing for corner
                //TOP-RIGHT corner
                edit_image.setRGB(x + grid_size + spacing, y, Color.CYAN.getRGB());

                //BOTTOM-LEFT corner
                edit_image.setRGB(x, y + grid_size + spacing, Color.CYAN.getRGB());
                //BOTTOM-RIGHT corner
                edit_image.setRGB(x + grid_size + spacing, y + grid_size + spacing, Color.CYAN.getRGB());

                //Left side
                for (int b = 0; b < spacing; b++) //Lines
                {
                    for (int i = 0; i < grid_size; i++) //Pixels for line
                    {
                        edit_image.setRGB(x + b, y + spacing + i, Color.RED.getRGB());
                    }
                }

                //Right side
                for (int b = 0; b < spacing; b++) //Lines
                {
                    for (int i = 0; i < grid_size; i++) //Pixels for line
                    {
                        edit_image.setRGB(x + b + grid_size + spacing, y + spacing + i, Color.RED.getRGB());
                    }
                }

                //Top side
                for (int b = 0; b < spacing; b++) //Lines
                {
                    for (int i = 0; i < grid_size; i++) //Pixels for line
                    {
                        edit_image.setRGB(x + i + spacing, y + b, Color.GREEN.getRGB());
                    }
                }

                //Bottom side
                for (int b = 0; b < spacing; b++) //Lines
                {
                    for (int i = 0; i < grid_size; i++) //Pixels for line
                    {
                        edit_image.setRGB(x + i + spacing, y + b + spacing + grid_size, Color.PINK.getRGB());
                    }
                }

                //write image
                try
                {
                    File output_file = new File("./out/grid-" + w + "-" + h + ".png");
                    ImageIO.write(edit_image, "png", output_file);
                }
                catch (IOException e)
                {
                    System.out.println(e);
                }
            }
        }
    }
}
