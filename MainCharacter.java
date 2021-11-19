/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;

import Until.Animation;
import Until.Resource;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import static window.GameScreen.GRAVITY;
import static window.GameScreen.GROUNDY;

/**
 *
 * @author sirikwan
 */
public class MainCharacter {
    private float x = 0;
    private float y = 0;
    private float speedY=0;
    private Animation characterRun;
    private Rectangle rect;
    private boolean isAlive=true;
   
public MainCharacter(){
    characterRun = new Animation(300);
    characterRun.addFrame(Resource.getResourceImage("Pic/Girlspuff.png"));
    rect = new Rectangle();
}
    
    public void update(){
        characterRun.update();
        //jump
        if(y>=GROUNDY-characterRun.getFrame().getHeight()){
                speedY=0;
                y=GROUNDY-characterRun.getFrame().getHeight();
               }else{
                speedY+=GRAVITY;
                y+=speedY;
               }
        rect.x = (int)x;
        rect.y = (int)y;
        rect.width = characterRun.getFrame().getWidth();
        rect.height = characterRun.getFrame().getHeight();
    }
    public Rectangle getBound(){
    return rect;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
       // g.drawRect((int) x,(int) y,characterImage.getWidth(),characterImage.getHeight());
        g.drawImage(characterRun.getFrame(),(int)x,(int) y,null);
    }
    
    public void jump(){
        speedY = -5;
    }
    

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
    public void setAlive(boolean alive){
        isAlive=alive;
    }
    public boolean getAlive(){
        return isAlive;
    }

}
