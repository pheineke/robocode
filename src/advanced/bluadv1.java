package advanced;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import advanced.my_data;
import advanced.enemy_data;

public class bluadv1 extends AdvancedRobot {



    //My

    double my_x = my_data.getMy_x();
    double my_y = my_data.getMy_y();
    double my_heading = my_data.my_RadarHeading;

    //Enemy
    double current_energy = 100;
    double enemy_x = enemy_data.enemy_x;
    double enemy_y = enemy_data.enemy_y;
    double enemy_Distance = enemy_data.enemy_Distance;
    double enemy_Bearing = enemy_data.enemy_Bearing;
    double enemy_Heading = enemy_data.enemy_Heading;
    double enemy_Velocity = enemy_data.enemy_Velocity;
    double enemy_Energy = enemy_data.enemy_Energy;

    public void run() {
        setAdjustRadarForRobotTurn(true);


        while (true) {
            turnRadarRight(360);
        }
    }



    int minusplus = 1;

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        onScannedInit(e);
        //

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

    public void onScannedInit(ScannedRobotEvent e){
        my_data.my_x = getX();
        my_data.my_y = getY();
        my_data.my_RadarHeading = getRadarHeading();
        enemy_data.enemy_Distance = e.getDistance();
        enemy_data.enemy_Bearing = e.getBearing();
        enemy_data.enemy_Heading = e.getHeading();
        enemy_data.enemy_Velocity = e.getVelocity();
        enemy_data.enemy_Energy = e.getEnergy();

        enemy_data.setEnemy_x();
        enemy_data.setEnemy_y();
    }

    public double move(ScannedRobotEvent event) {
        my_x = getX();
        my_y = getY();
        my_heading = getHeading();
        return 0.0;//
    }



}
