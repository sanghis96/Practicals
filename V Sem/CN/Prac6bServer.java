package prac6b;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;

public class Prac6b 
{
    public static void main(String[] args) throws IOException 
    {
        try (ServerSocket s = new ServerSocket(6666)) {
            Socket s1 = s.accept();
            BufferedImage img = ImageIO.read(s1.getInputStream());
            File file = new File("D:abc.png");
            ImageIO.write(img,"png", file);
            //DataInputStream d1 = new DataInputStream(s1.getInputStream());
            //String ss = (String)d1.readUTF();
            //System.out.println("Hello" + ss);
        }
    } 
}
