package infovk23.p_heineke22;
import java.awt.Color;

public class MyFirstBehavior extends SimpleRobotBehavior {
	//Ged�chtnissektion
	private byte scanDirection = 1;


	public MyFirstBehavior(SimpleRobot robot) {
		super(robot);
	}
	
	@Override
	public void start() {
		setColors(Color.BLACK, Color.BLACK, Color.RED, Color.BLACK, Color.BLUE);
	  //Startfunktion
	}

	boolean truu = true;
	@Override
	public void execute() {
		turnRadar(10);

		int minusplus = 1;

		if (!getScannedRobotEvents().isEmpty()) {
			ScannedRobotEvent event = getScannedRobotEvents().lastElement();

			scanDirection *= -1; // changes value from 1 to -1
			turnRadar(360 * scanDirection);
			turnRadar(getHeading() - getRadarHeading() + event.getBearing());

			if (event != getScannedRobotEvents().lastElement()) {
				if (!getScannedRobotEvents().isEmpty()) {
					ScannedRobotEvent event2 = getScannedRobotEvents().lastElement();

					scanDirection *= -1; // changes value from 1 to -1
					turnRadar(360 * scanDirection);
					turnRadar(getHeading() - getRadarHeading() + event2.getBearing());
				}
			}

			turn(event.getBearing() + 90);


			for(int i = 0; i < Math.random()*9; i++) {

				double traveldistance = Math.random()*100+30;
				
				ahead( traveldistance * minusplus);

			}
			minusplus *=-1;


		} else { turnRadar(10);};


	}
	
	//Eigene Funktionen Sektion
}
