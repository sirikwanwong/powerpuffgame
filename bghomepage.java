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
public class bghomepage {
    private BufferedImage bgImage, textImage;
    public bghomepage(){
        bgImage = Resource.getResourceImage("Pic/bghome2.jpg");
        textImage = Resource.getResourceImage("Pic/iconplay.PNG");
        
    }
    public void draw(Graphics g){
        g.drawImage(bgImage,-68,0, null);
        g.drawImage(textImage,375,550,250,100, null);
        
    }
}
