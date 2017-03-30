package br.com.cco;
import robocode.*;

//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Highlander - a robot by (your name here)
 */
public class Highlander extends Robot
{


	
	/**
	 * run: Highlander's default behavior
	 */
	
	int ultimoMovimento = 45;
	
	public void smartFire(double robotDistance){

	if (robotDistance > 200 || getEnergy() < 15) {
                  fire(1);
            } else if (robotDistance > 50) {
                  fire(2);
            } else {
                  fire(3);
            }
	}
	public void run() {
	while(true){
			ahead(100);
		}

	}
	public void tiroSinuoso(){
		
	}
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		switch(ultimoMovimento){
			case 45:
				turnRight(315);
				ahead(100);
				ultimoMovimento = 315;
				break;
			case 90:
				turnLeft(270);
				back(90);
				ultimoMovimento = 270;
				break;
			case 180:
				turnRight(180);
				ahead(90);
				ultimoMovimento = 90;
				break;
			case 315:
				turnRight(45);
				back(100);
				ultimoMovimento = 180;
				break;
			case 270:
				turnRight(90);
				ahead(50);
				ultimoMovimento = 45;
				break;
			}
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		if(getHeading()< 90){
			turnRight(360- getHeading());
			}
		if(getHeading()>=90 && getHeading() < 180){
			turnRight(360- getHeading());
				}
		if(getHeading()>=180 && getHeading() < 270){
			turnRight(360- getHeading());
				}
		if(getHeading()>=270 && getHeading() < 360){
			turnRight(360- getHeading());
				}
			}
		}
	}	
}
