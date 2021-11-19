/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Until;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sirikwan
 */
public class Animation {
    private List <BufferedImage>frames;
    private int frameIndex = 0;
    private int deltaTime;
    private long previousTime;
    
    public Animation(int deltaTime){
        this.deltaTime = deltaTime;
        frames = new ArrayList<BufferedImage>();
    }
    
    public void update(){
        if(System.currentTimeMillis()-previousTime>deltaTime){
        frameIndex++;
        if(frameIndex >= frames.size()){
            frameIndex = 0;
        }
        previousTime = System.currentTimeMillis();
        }
    }
    
    public void addFrame(BufferedImage frame){
        frames.add(frame);
    }
    public BufferedImage getFrame(){
        if(frames.size()>0){
            return frames.get(frameIndex);
        }
        return null;
    }

   
    
}
   
