package com.darkguardsman.imagebleeder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 7/27/2018.
 */
public class Main
{
    public static void main(String args[]) throws IOException
    {
        //Args:
        //  0: input
        //  1: output
        //  2: grid size input
        //  3: spacing size for output
        if (args != null && args.length == 4)
        {
            final String input_path = args[0];
            final String output_path = args[1];

            final int grid_size = Integer.parseInt(args[2]);
            final int spacing = Integer.parseInt(args[3]);

            BufferedImage ordinal_image = null;

            //read image
            try
            {
                File input_file = new File(input_path);
                ordinal_image = ImageIO.read(input_file);
            }
            catch (IOException e)
            {
                System.out.println("Failed to read image input file");
                System.out.println(e);
                System.exit(-1);
            }

            //Get size of image
            final int width = ordinal_image.getWidth();
            final int height = ordinal_image.getHeight();

            //Get number of tiles in sheet (assume no existing spacing or edges)
            final int tiles_w = width / grid_size;
            final int tiles_h = height / grid_size;

            //Get spacing to add
            final int space_w = tiles_w * spacing + spacing; //Space for each tile + 1
            final int space_h = tiles_h * spacing + spacing;

            //Create new image with increased size for spacing
            BufferedImage edit_image = new BufferedImage(width + space_w, height + space_h, BufferedImage.TYPE_INT_ARGB);

            //Loop through tiles
            for (int w = 0; w < tiles_w; w++)
            {
                for (int h = 0; h < tiles_h; h++)
                {
                    int x = w * 16 + spacing + spacing * w;
                    int y = h * 16 + spacing + spacing * h;
                }
            }

            //write image
            try
            {
                File output_file = new File(output_path);
                ImageIO.write(edit_image, "png", output_file);
            }
            catch (IOException e)
            {
                System.out.println(e);
            }

        }
        else
        {
            System.out.println("Program requires 4 arguments to operate 'input file, output file, grid size, spacing for output'. Example: 'tiles-raw.png tiles.png 16 1'");
            System.exit(1);
        }
    }
}
