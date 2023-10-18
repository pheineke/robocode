package advanced;

import advanced.my_data.*;
public class enemy_data {

    static double enemy_x = 0;
    static double enemy_y = 0;
    static double enemy_Distance = 0;
    static double enemy_Bearing = 0;
    static double enemy_Heading = 0;
    static double enemy_Velocity = 0;
    static double enemy_Energy = 100;


    public double getEnemy_x() {
        return enemy_x;
    }

    public static void setEnemy_x() {
        double my_x = my_data.getMy_x();
        double my_RadarHeading = my_data.getMy_RadarHeading();
        double enemy_x = Math.cos(my_RadarHeading) * enemy_Distance;

        this.enemy_x = enemy_x;
    }

    public double getEnemy_y() {
        return enemy_y;
    }

    public static void setEnemy_y() {
        double my_y = my_data.getMy_y();
        double enemy_y = Math.sqrt(Math.pow(enemy_Distance,2) - Math.pow(enemy_x,2));
        this.enemy_y = enemy_y;
    }
}
