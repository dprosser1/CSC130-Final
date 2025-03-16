package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import Data.Vector2D;
import Data.spriteInfo;
import logic.Control;
import timer.stopWatchX;

public class Main{
	
	public static boolean isImageDrawn = false;
	public static stopWatchX timer = new stopWatchX(500);
	//public static Queue<Vector2D> vecs1 = new LinkedList<>();
	//public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(-100, 100);
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static spriteInfo temp = new spriteInfo(currentVec, "fish");
	static int currentSpriteIndex = 0;
	
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		start();
		ctrl.gameLoop();							// Do NOT remove!
	}

	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		
		for(int i = -3; i<28; i++) {
			if(currentSpriteIndex == 0) {
				sprites.add(new spriteInfo(new Vector2D(i*50, 50), "fish1"));
				currentSpriteIndex++;
			}else if(currentSpriteIndex == 1) {
				sprites.add(new spriteInfo(new Vector2D(i*50, 50), "fish2"));
				currentSpriteIndex++;
			}else if(currentSpriteIndex == 2) {
				sprites.add(new spriteInfo(new Vector2D(i*50, 50), "fish1"));
				currentSpriteIndex++;
			}else if(currentSpriteIndex == 3) {
				sprites.add(new spriteInfo(new Vector2D(i*50, 50), "fish3"));
				currentSpriteIndex++;
			}
			
			if(currentSpriteIndex == 4) {
				currentSpriteIndex = 0;
			}
		}
		
		System.out.println(sprites.toString());	
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
    public static void update(Control ctrl) {
    	ctrl.addSpriteToFrontBuffer(currentVec.getX(), currentVec.getY(), temp.getTag());
        if(!isImageDrawn) {
            if(timer.isTimeUp()) {
            	temp = sprites.get(currentSpriteIndex);
            	currentVec = temp.getCoords();
            
                if(currentSpriteIndex == 36) {
                	currentSpriteIndex = 1;
                }else {
                	currentSpriteIndex++;
                }
            }

        }
           
        if(timer.isTimeUp()) {
            isImageDrawn = !isImageDrawn;
            timer.resetWatch();
        }            
    }
}

	



