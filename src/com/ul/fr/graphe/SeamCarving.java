package com.ul.fr.graphe;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class SeamCarving
{
	private static final String MAGIC="P2";
	private static final int MAXVAL=255;

   public static int[][] readpgm(String fn)
	 {		
        try {
            InputStream f = ClassLoader.getSystemClassLoader().getResourceAsStream(fn);
            BufferedReader d = new BufferedReader(new InputStreamReader(f));
            String magic = d.readLine();
            String line = d.readLine();
             System.out.println(magic);

		   while (line.startsWith("#")) {

		   	line = d.readLine();

		   }
		   System.out.println(line);
		   Scanner s = new Scanner(line);
		   int width = s.nextInt();
		   int height = s.nextInt();

		   line = d.readLine();
		   s = new Scanner(line);
		   int maxVal = s.nextInt();
		   int[][] im = new int[height][width];
		   s = new Scanner(d);
		   int count = 0;
		   while (count < height*width) {

			  im[count / width][count % width] = s.nextInt();
			  count++;
		   }
		   return im;
        }
		
        catch(IOException e) {
            //t.printStackTrace(System.err) ;
            e.printStackTrace();
            return null;
        }
    }
    public static void writerpg(int[][] image,String filename)
	{
		PrintWriter out=null;
		try {
			File f=new File(filename);
			if(!f.getParentFile().exists())
				f.getParentFile().mkdirs();
			if(!f.exists())
				f.createNewFile();
			out= new PrintWriter(filename);

			int h=image.length;
			int w=image[0].length;
			 out.println(MAGIC);
			 out.println(w+" "+h);
			 out.println(MAXVAL);
			 int count=0;
			while (count < h*w) {

				int k=image[count / w][count % w];
				out.println(k);
				count++;
			}

		}catch (IOException e)
		{
			e.printStackTrace();
		}finally {
			if(out!=null)
			out.close();
		}
	}

   
}
