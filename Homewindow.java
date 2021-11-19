/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sirikwan
 */
public class Homewindow extends JFrame{
    private GameScreen gameScreen;
    
    public Homewindow(){ 
       super("POWER GIRLS");//namegame
       setSize(1000,700);//
       setLocation(200,100);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
        gameScreen = new GameScreen();
        add(gameScreen);
        addKeyListener(gameScreen);
    }
    public void startGame(){
        gameScreen.startgame();
    }
    
    public static void main(String[] args) {
       Homewindow gw = new Homewindow();
       gw.setVisible(true);
       gw.startGame();

    }
    
    
}
