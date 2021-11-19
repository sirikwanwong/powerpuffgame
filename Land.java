/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import Until.Resource;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import window.GameScreen;
import static window.GameScreen.GROUNDY;

/**
 *
 * @author sirikwan
 */
public class Land {
    private List<ImageLand>listImage;
    private BufferedImage imageLand1,imageLand2,imageLand3;
    private Random random;
    public Land(GameScreen game){
        random = new Random();
        imageLand1 = Resource.getResourceImage("Pic/land_1.jpg"); 
        imageLand2 = Resource.getResourceImage("Pic/land3.jpg");
        imageLand3 = Resource.getResourceImage("Pic/land2.jpg");
        listImage =  new  ArrayList<ImageLand>();
        int numberOfLandTitle = game.getWidth()/imageLand1.getWidth()+5;
        for(int i=0;i<5;i++){
            ImageLand imageLand = new ImageLand();
            imageLand.posX = (int) (i*imageLand1.getWidth());
            imageLand.image = getImageLand();
            listImage.add(imageLand);
        }
    }
    public void update(){
        for(ImageLand imageLand:listImage){
        imageLand.posX-=2;
        }
        ImageLand firstElement = listImage.get(0);
        if(firstElement.posX+imageLand1.getWidth()<0){
           firstElement.posX = listImage.get(listImage.size()-1).posX+imageLand1.getWidth();
           listImage.add(firstElement);
           listImage.remove(0);
        }
    }   
    public void draw(Graphics g){
        for(ImageLand imageLand:listImage){
            g.drawImage(imageLand.image,imageLand.posX,0,null);
        }
        
    }
    private BufferedImage getImageLand(){
        int i = random.nextInt(30);
        switch(i){
            case 0: return imageLand1;
            case 1: return imageLand3;
            default : return imageLand2;
        }
    }
   

    private class ImageLand{
    int posX;
    BufferedImage image;
    }
    
}
    
    
    
    
    
    
    

    