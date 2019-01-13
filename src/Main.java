import com.ul.fr.graphe.SeamCarving;

import java.io.IOException;

public class Main {

    public static void main(String[] args)
{

    int [][] image=SeamCarving.readpgm("data/ex1.pgm");
    SeamCarving.writerpg(image, "/data/test.pgm");

}
}
