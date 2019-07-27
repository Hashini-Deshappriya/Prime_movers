
import robocode.*;
import java.awt.Color;

import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;



public class Prime_movers extends AlphaBot
{

	boolean peek;
	double moveAmount;
	boolean movingForward;

	public void run() {
	
		setBodyColor(Color.green);
		setGunColor(Color.green);
		setRadarColor(Color.green);
		setBulletColor(Color.green);
		setScanColor(Color.green);
	
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


public void reverseDirection() {
		if (movingForward) {
			back(40000);
			movingForward = false;
		} else {
			ahead(40000);
			movingForward = true;
		}
	}
public void onHitRobot(HitRobotEvent e) {
		
		if (e.isMyFault()) {
			reverseDirection();
		}
	}

	public void onHitByBullet(HitByBulletEvent e) {
	
		back(10);
	}
	


}
