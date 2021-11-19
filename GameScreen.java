/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import Until.Resource;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import objectgame.EnemiesManager;
import objectgame.Gameover;
import objectgame.Land;
import objectgame.MainCharacter;
import objectgame.Spacedead;
import objectgame.bghomepage;


/**
 *
 * @author sirikwan
 */
public class GameScreen extends JPanel implements Runnable, KeyListener{
    public static final int GAME_FIRST_STAGE=0;
    public static final int GAME_PLAY_STAGE=1;
    public static final int GAME_OVER_STAGE=2;
    public static final float GRAVITY=0.3f;
    public static final float GROUNDY =700;
    
    private MainCharacter mainCharacter;
    private Thread thread;
    private Land land;
    private bghomepage home;
    private EnemiesManager enemiesManager;
    private int score;
    
    private int gameStage = GAME_FIRST_STAGE;
    private Gameover over;
   
    public GameScreen() {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(70);
        mainCharacter.setY(150);
        land = new Land(this);
        home = new bghomepage();
        over = new Gameover();
        enemiesManager = new EnemiesManager(mainCharacter,this);
        //imageGameoverText = Resource.getResourceImage("Pic/over.PNG");
         
    }
    public void startgame(){
        thread.start();
    }
    @Override
    public void run() {
        while(true){
            try {
                update();
                repaint();
               Thread.sleep(30);//
           } catch (InterruptedException e) {
               e.printStackTrace();
             }
        } 
    }
    public void update(){
        switch(gameStage){
            case GAME_PLAY_STAGE:
                mainCharacter.update();
                land.update();
                enemiesManager.update();
                if(!mainCharacter.getAlive()){
                    gameStage = GAME_OVER_STAGE;
            }
            break;
        }
       
    }
    public void plusScore(int score){
        this.score += score;
    }
    
    @Override
    public void paint(Graphics g){
    g.setColor(Color.white);
    g.fillRect(0,0, getWidth(), getHeight());
    
    switch(gameStage){
        case GAME_FIRST_STAGE :
            home.draw(g);
            break;
        case GAME_PLAY_STAGE:
            land.draw(g);
            mainCharacter.draw(g);
            enemiesManager.draw(g);
            g.drawString("SCORE  " +String.valueOf(score),880,80);
            break;
        case GAME_OVER_STAGE:
            over.draw(g);
           break; 
    }
  
    }
    private void resetGame(){
        mainCharacter.setAlive(true);
        mainCharacter.setX(70);
        mainCharacter.setY(150);
        enemiesManager.reset();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
       switch(e.getKeyCode()){
           case KeyEvent.VK_SPACE:
       if(gameStage ==GAME_FIRST_STAGE){
           gameStage= GAME_PLAY_STAGE;
         }else if(gameStage == GAME_PLAY_STAGE){
             mainCharacter.jump();
         }else if(gameStage == GAME_OVER_STAGE){
             resetGame();
             gameStage = GAME_PLAY_STAGE;
             
         }
       break;
       }
    }
}

    