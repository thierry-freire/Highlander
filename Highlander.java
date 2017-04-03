package cco;
import robocode.*;
import java.awt.Color;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;


public class Highlander extends AdvancedRobot{

	public void run(){
		setColors(Color.gray,Color.gray,Color.red);	
		while(true){
			turnGunRight(360);
		}	
	}
   	 
    public void onScannedRobot(ScannedRobotEvent e){
		double absoluteBearing = getHeading() + e.getBearing();
		double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
		setAhead(Double.POSITIVE_INFINITY);
		setTurnRight(getEnergy());		
		setMaxVelocity(120);
		
		if (Math.abs(bearingFromGun) <= 3) {
			turnGunRight(bearingFromGun);
		
			if (getGunHeat() == 0) {
				fire(Math.min(3 - Math.abs(bearingFromGun), getEnergy() - .1));
			}
		}
		else {
			turnGunRight(bearingFromGun);
		}
	
		if (bearingFromGun == 0) {
			scan();
		}	
		
		if(e.getDistance()<2000){
			if(getEnergy()>65 && e.getDistance()<=100){
				fire(3);
			}
			if(getEnergy()>65 && e.getDistance()>100){
				fire(2);
			}	
			if(getEnergy()<=65 && e.getDistance()<=100){
				fire(3);
			}
			if(getEnergy()<65 && e.getDistance()>100){
				fire(1);
			}	
		}
	}
	
	public void onWin(WinEvent e) {
		turnRight(36000);
	}
}
	