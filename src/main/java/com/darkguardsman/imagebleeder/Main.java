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
        if (args != null)
        {
            //Args:
            //  0: input
            //  1: grid_size
            if (args.length == 2)
            {
                System.out.println("Running two argument command");

                final String input_path = args[0];
                final int grid_size = Integer.parseInt(args[1]);

                if (!input_path.endsWith(".png"))
                {
                    throw new RuntimeException("Only .png is supported at the moment!");
                }

                runNormal(input_path, input_path.substring(0, input_path.length() - 4) + "-out.png", grid_size, 1);
                return;
            }
            //Args:
            //  0: input
            //  1: output
            //  2: grid size input
            //  3: spacing size for output
            else if (args.length == 4)
            {
                System.out.println("Running four argument command");

                final String input_path = args[0];
                final String output_path = args[1];

                final int grid_size = Integer.parseInt(args[2]);
                final int spacing = Integer.parseInt(args[3]);

                if (!input_path.endsWith(".png") || !output_path.endsWith(".png"))
                {
                    throw new RuntimeException("Only .png is supported at the moment!");
                }

                //Prevent users from overriding the input file by mistake
                if (input_path.equalsIgnoreCase(output_path))
                {
                    throw new RuntimeException("Input path can not match output path! This is done to prevent mistakes that result in asset loss.");
                }

                runNormal(input_path, output_path, grid_size, spacing);
                return;
            }
            else if (args[0].equalsIgnoreCase("random-test"))
            {
                System.out.println("Running random test command");

                testLogic();
                return;
            }
        }

        //Display error noting how to use the program
        System.out.println("Program requires 4 arguments to operate 'input file, output file, grid size, spacing for output'. Example: 'tiles-raw.png tiles.png 16 1'");
        System.exit(1);
    }

    private static void runNormal(String input_path, String output_path, int grid_size, int spacing)
    {
        //Load image
        BufferedImage image = loadImage(input_path);

        //Extrude
        BufferedImage output = ImageHandler.extrudeEdges(image, grid_size, spacing);

        //Save
        saveImage(output_path, output);
    }

    private static void testLogic()
    {
        final int grid_size = 16;
        final int spacing = 2;

        //Get size of image
        final int width = 256;
        final int height = 256;

        //Get image
        BufferedImage image = ImageHandler.generateRandomImageGrid(grid_size, width, height);

        //Extrude
        BufferedImage output = ImageHandler.extrudeEdges(image, grid_size, spacing);

        //Save
        saveImage("./random-test.png", output);
    }

    private static BufferedImage loadImage(String path)
    {
        try
        {
            File input_file = new File(path);
            return ImageIO.read(input_file);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Failed to read image input file", e);
        }
    }

    private static void saveImage(String path, BufferedImage image)
    {
        try
        {
            File output_file = new File(path);
            ImageIO.write(image, "png", output_file);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Failed to save image output file", e);
        }
    }
}
