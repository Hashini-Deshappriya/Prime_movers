
import robocode.*;
import java.awt.Color;

import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;



public class Prime_movers extends AlphaBot
{

	boolean peek;
	double moveAmount;

	public void run() {
	
		setBodyColor(Color.red);
		setGunColor(Color.red);
		setRadarColor(Color.orange);
		setBulletColor(Color.red);
		setScanColor(Color.red);
	
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		
		peek = false;

		
		turnLeft(getHeading() % 90);
		ahead(moveAmount);
	
		peek = true;
		turnGunRight(90);
		turnRight(90);

		while (true) {
			
			peek = true;
		
			ahead(moveAmount);
			
			peek = false;
		
			turnRight(90);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		  if (getGunHeat() == 0) {
       fire(Rules.MAX_BULLET_POWER);
   }
	
		if (peek) {
			scan();
		}
	}

	public void onHitRobot(HitRobotEvent e) {
	
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		}
		else {
			ahead(100);
		}
	}

	public void onHitByBullet(HitByBulletEvent e) {
	
		back(10);
	}
	


}
