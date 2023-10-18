package advanced;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

public class bluadv1 extends AdvancedRobot {

    //Enemy
    double current_energy = 100;

    //My

    double my_x = 0;
    double my_y = 0;

    double my_heading = 0;



    public void run() {
        setAdjustRadarForRobotTurn(true);
        while (true) {
            turnRadarRight(360);
        }
    }



    int minusplus = 1;

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        current_energy = e.getEnergy();

        double RelativeEnemyHeading = getHeading() - getRadarHeading() + e.getBearing();
        System.out.println("RELEHEAD: " + RelativeEnemyHeading);
        setTurnRadarRight(RelativeEnemyHeading);
        setTurnRight(e.getBearing() + 90);
        setTurnGunRight(e.getBearing() + 90);

        for(int i = 0; i < Math.random()*9; i++) {
            double temp_energy = e.getEnergy();
            if (temp_energy < current_energy) {
                ahead(Math.random()*10+48);
                current_energy = temp_energy;

            }
            ahead(Math.random()*10+48 * minusplus);
            minusplus *=-1;
        }
    }

    public double move(ScannedRobotEvent event) {
        my_x = getX();
        my_y = getY();
        my_heading = getHeading();
        return 0.0;//
    }



}
