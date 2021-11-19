/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import Until.Resource;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author sirikwan
 */
public class Spacedead extends Enemy{
    private BufferedImage image;
    private int posX,posY;
    private Rectangle rect;
    private MainCharacter mainCharacter;
    private boolean isScoreGot=false;
    public Spacedead(MainCharacter mainCharacter){
        this.mainCharacter=mainCharacter;
        image = Resource.getResourceImage("Pic/space.png");
        posX =400;
        posY =600;
        rect = new Rectangle();
    }

    Spacedead() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void update(){
        posX -=10;
        rect.x=posX;
        rect.y=posY;
        rect.width = image.getWidth();
        rect.height = image.getHeight();
    }
    @Override
    public Rectangle getBound(){
    return rect;
    }
    
    @Override
    public void draw(Graphics g){
        g.drawImage(image,posX,posY,null);
    }
    public void setX(int x){
        posX = x;
    }
    public void setY(int y){
        posY = y;
    }
    public void setImage(BufferedImage image){
        this.image= image;
    }
    @Override
    public boolean isOutOfScreen(){
        return(posX + image.getWidth()<0);
    }

    @Override
    public boolean isOver() {
        return (mainCharacter.getX()>posX);
    }
    @Override
    public boolean isScoreGot(){
        return isScoreGot;
    }
    @Override
    public void setIsScoreGot(boolean isScoreGot){
        this.isScoreGot = isScoreGot;
    }
}
