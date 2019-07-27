
import robocode.*;
import java.awt.Color;


public class Prime_movers extends BravoBot
{
	int turnDirection = 1; 
	public void run() {
	
		setBodyColor(Color.black);
		setGunColor(Color.black);
		setRadarColor(Color.black);
	while (true) {
			turnRight(5 * turnDirection);
		}
	}


	public void onScannedRobot(ScannedRobotEvent e) {
	
		  if (getGunHeat() == 0) {
          fire(Rules.MAX_BULLET_POWER);}
	   
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}

		turnRight(e.getBearing());
		ahead(e.getDistance() + 5);
		scan(); 
	}
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		turnRight(e.getBearing());

		
		if (e.getEnergy() > 16) {
			fire(3);
		} else if (e.getEnergy() > 10) {
			fire(2);
		} else if (e.getEnergy() > 4) {
			fire(1);
		} else if (e.getEnergy() > 2) {
			fire(.5);
		} else if (e.getEnergy() > .4) {
			fire(.1);
		}
		ahead(40);
	}

	public void onHitByBullet(HitByBulletEvent e) {
	
		back(100);
	}
	

	public void onHitWall(HitWallEvent e) {
	
		back(20);
	}	
}
