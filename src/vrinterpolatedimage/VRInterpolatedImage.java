/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrinterpolatedimage;

/**
 *
 * @author Saurabh
 */

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class VRInterpolatedImage extends Component {

    public static void main(String[] args) {
        new VRInterpolatedImage();
    }

    
    
   
    public void printPixelARGB(int pixel) {//useless code unless you want to make changes to the pixel or make it blurry 
        int alpha = (pixel >> 24) & 0xff;
        int red = ((pixel >> 16) & 0xff);
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        pixel= (alpha<<24) | (red<<16) | (green<<8) | blue;
        //System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }

    private void IMAGE(BufferedImage image, int coordinatex, int coordinatey) {
        int w = image.getWidth();
        int h = image.getHeight();
        int xc= coordinatex;
        int yc =coordinatey;
         
        System.out.println("width, height: " + w + ", " + h);
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);//code modification 
       
      //  if ("L".equals(direction)||"l".equals(direction)){
            if (xc<=0&&yc>=0){
                xc=-xc;
            System.out.println("left motion ");
               for (int i =yc; i < h; i++) {//  North west  converted to south east  
            for (int j = xc; j < w; j++) {
                
                int pixel;
                pixel = image.getRGB(j-xc, i-yc);
                img.setRGB(j, i, pixel);
        }
        
          
        }
        
                         
  for (int i=yc; i < h; i++) {   //left
            for (int j = 0; j < xc; j++) {
                
                try{                
                    
                            int pixel;
                            pixel = img.getRGB(xc,i);
                            
                            img.setRGB(j, i, pixel);
                            //System.out.println("pixel valuw "+xc+"height"+i+ pixel);
                            }
                            catch (Exception e)
                            {System.out.println("Error: " + e);
                            }
                
                
            }
            }
         
                 for (int i=0; i < yc; i++) { //top
            for (int j = 0; j < w; j++) {
                
                try{                
                    
                            int pixel;
                            pixel = img.getRGB(j, yc);
                            img.setRGB(j, i, pixel);
                            //System.out.println("pixel valuw "+ pixel);
                            }
                            catch (Exception e)
                            {System.out.println("Error: " + e);
                            }
                
                
            }
            } 
                 
        
        }
        
      
        //else if ("NE".equals(direction)||"ne".equals(direction) ){
        else if (xc>0 && yc>0 ){
            System.out.println("North East ");
         for (int i =0; i < h-yc; i++) { //south west to be represented in north east
            for (int j = xc; j < w; j++) {
                
                int pixel;
                pixel = image.getRGB(j, i);
                img.setRGB(j-xc, i+yc, pixel);
        }
        
          
        }
        
                         
   for (int i=yc; i < h; i++) {   //right
            for (int j = w-xc; j <w; j++) {
                
                try{                
                    
                            int pixel;
                            pixel = img.getRGB(w-xc-1,i);
                           // int s= w-xc;
                            img.setRGB(j, i, pixel);
                            //System.out.println( s+"yo " + i+"" +"pixel valuw "+pixel);
                            }
                            catch (Exception e)
                            {System.out.println("Error: " + e);
                            }
                
                
            }
            }
         
                for (int i=0; i < yc; i++) { //top
            for (int j = 0; j < w; j++) {
                
                try{                
                    
                            int pixel;
                            pixel = img.getRGB(j, yc);
                            img.setRGB(j, i, pixel);
                            //System.out.println("pixel valuw "+ pixel);
                            }
                            catch (Exception e)
                            {System.out.println("Error: " + e);
                            }
                
            }
                 }
        
        
        }
             //else if ("SW".equals(direction)||"sw".equals(direction) ){
             else if (xc<0 && yc<0 ){
                 xc=-xc;
                 yc=-yc;
                 System.out.println("South West ");
       for (int i =yc; i < h; i++) { //north east  to be repesented in south west
            for (int j = 0; j < w-xc; j++) {
                
                int pixel;
                pixel = image.getRGB(j, i);
                img.setRGB(j+xc, i-yc, pixel);
        }
        
          
        }
        
                         
  for (int i=0; i < h; i++) {   //left
            for (int j = 0; j < xc; j++) {
                
                try{                
                    
                            int pixel;
                           pixel = img.getRGB(xc, i);
                           
                          img.setRGB(j, i, pixel);
                         // System.out.println( "pixel valuw "+pixel);
                            }
                            catch (Exception e)
                            {System.out.println("Error: " + e);
                            }
                
                
            }
            }
         
                for (int i=h-yc; i < h; i++) { //bottom 
            for (int j = 0; j < w; j++) {
                
                try{                
                    
                           int pixel;
                           pixel = img.getRGB(j, h-yc-1);
                           
                           int s= h-yc-1;
                           img.setRGB(j, i, pixel);
                            //System.out.println("width "+ j+"heing"+s+"pixel valuw "+ pixel);
                            }
                            catch (Exception e)
                            {System.out.println("Error: " + e);
                            }
                
            }
                 }
        
       
             }
    
      else
        {
            yc=-yc;
            System.out.println("Right Motion  ");
              for (int i =yc; i < h; i++) { //south east converted to north west 
            for (int j = xc; j < w; j++) {
                
                int pixel;
                pixel = image.getRGB(j, i);
                img.setRGB(j-xc, i-yc, pixel);
        }
        
          
        }
        
                         
         for (int i=yc; i < h; i++) {   //right 
            for (int j = w-xc; j < w; j++) {
                
                try{                
                    
                            int pixel;
                            pixel = img.getRGB(w-xc-1, i-yc);
                            img.setRGB(j, i-yc, pixel);
                            //System.out.println("pixel valuw "+ pixel);
                            }
                            catch (Exception e)
                            {System.out.println("Error: " + e);
                            }
                
                
            }
            }
         
           for (int i=h-yc; i < h; i++) { //bottom 
            for (int j = 0; j < w; j++) {
                
                try{                
                    
                            int pixel;
                            pixel = img.getRGB(j, h-yc-1);
                            img.setRGB(j, i, pixel);
                           // System.out.println("pixel valuw "+ pixel);
                            }
                            catch (Exception e)
                            {System.out.println("Error: " + e);
                            }
                
                
            }
            }
        
        }
        
         try {
                File f = new File("C:\\output\\output.jpg");
                ImageIO.write(img, "png", f);
               // File f2 = new File("C:\\output\\output2.jpg");
              //  ImageIO.write(img2, "png", f);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
    }
    
  

    public VRInterpolatedImage() {
        try {
            
            BufferedImage image
                    = ImageIO.read(this.getClass().getResource("Stud-2.jpg"));
               int w = image.getWidth();
        int h = image.getHeight();
            
            Scanner in= new Scanner(System.in);
int coordinatex;
int coordinatey;


System.out.println("Enter the x coordinaten between  " +"-"+w +"and:"+w);
coordinatex=in.nextInt();

coordinatex=checkx(coordinatex,w);

System.out.println("SET AS "+ coordinatex);
System.out.println("Enter the y coordinate less than " +"-"+h +"and:"+h);
coordinatey=in.nextInt();
coordinatey=checky(coordinatey,h);
System.out.println("SET AS "+ coordinatey);
            // get the BufferedImage, using the ImageIO class
           
            IMAGE(image,coordinatex,coordinatey);
           File imageUrl = new File("C:\\output\\output.jpg");
            BufferedImage image2
                    = ImageIO.read(imageUrl);
                   
                      
             int w1 = image2.getWidth();
        int h1= image.getHeight();
         System.out.println("width, height: " + w1 + ", " + h1); 
         
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private int checkx(int xnew, int w) {
          Scanner in= new Scanner(System.in);
       
          int neg=-1*w;
        if (xnew>=(w) ||xnew<=(neg) ) // check problem 
{
System.out.println("Wrong Input!Please Enter the x coordinaten between  " +"-"+w +"and:"+w);
xnew=in.nextInt();
System.out.println("iteration"+xnew);
xnew=checkx(xnew,w);
    
}
        
           
        return xnew;
    }

    private int checky(int coordinatey, int h) {
         Scanner in= new Scanner(System.in);
         int neg= -1*h;
       if (coordinatey>=(h) ||coordinatey<=(neg)  ) // check problem 
{
System.out.println("Wrong Input!PLease Enter the y coordinate less than " +"-"+h +"and:"+h);
coordinatey=in.nextInt();

coordinatey=checky(coordinatey,h);  

}    
    
        return coordinatey;
    }

}

