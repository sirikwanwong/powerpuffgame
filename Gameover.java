/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import Until.Resource;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author sirikwan
 */
public class Gameover {
     private BufferedImage backImage, textoverImage;
    public Gameover(){
        backImage = Resource.getResourceImage("Pic/back2.jpg");
        textoverImage = Resource.getResourceImage("Pic/over.PNG");
        
    }
    public void draw(Graphics g){
        g.drawImage(backImage,-150,0, null);
        g.drawImage(textoverImage,280,200,500,300, null);
        
    }
}
