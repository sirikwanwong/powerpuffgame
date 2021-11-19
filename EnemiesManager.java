/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectgame;


import Until.Resource;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import window.GameScreen;

/**
 *
 * @author sirikwan
 */
public class EnemiesManager {
    private List<Enemy> enemies;
    private Random random;
    
    private BufferedImage imageSpace1,imageSpace2;
    private MainCharacter mainCharacter;
    private GameScreen gameScreen;
    
    public EnemiesManager(MainCharacter mainCharacter,GameScreen gameScreen){
        this.gameScreen= gameScreen;
        this.mainCharacter = mainCharacter;
        enemies = new ArrayList<Enemy>();
        imageSpace1 = Resource.getResourceImage("Pic/space.png");
        imageSpace2 = Resource.getResourceImage("Pic/bird1.png");
        random = new Random();
        enemies.add(getRandomSpacedead());
        random = new Random();
    }
    public void update(){
        for(Enemy e : enemies){
            e.update();
            if(e.isOver() && !e.isScoreGot()){
                gameScreen.plusScore(20);
                e.setIsScoreGot(true);
            }
            if(e.getBound().intersects(mainCharacter.getBound())){
            mainCharacter.setAlive(false);
            }
        }
        Enemy firstEnermy = enemies.get(0);
        if(firstEnermy.isOutOfScreen()){
            enemies.remove(firstEnermy);
            enemies.add(getRandomSpacedead());
        }
    }
   public void draw(Graphics g){
       for(Enemy e : enemies){
       e.draw(g);
       }
   }
   public void reset(){
       enemies.clear();
       enemies.add(getRandomSpacedead());
   }
   private Spacedead getRandomSpacedead(){
       Spacedead spacedead;
       spacedead = new Spacedead(mainCharacter);
       spacedead.setX(900);
       spacedead.setY(200);
   if(random.nextBoolean()){
       spacedead.setImage(imageSpace1);
    }else{
       spacedead.setImage(imageSpace2);
   }
   return spacedead;
}
    
}
