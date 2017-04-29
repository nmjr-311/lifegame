package utility;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

/**
 * Created by numajiri on 17/01/04.
 */
public class RandColor {
    static public Paint calcRandomRGB(Random r){
        return Color.rgb(r.nextInt(255),
                r.nextInt(255), r.nextInt(255));
    }

//    static public Paint calcRandomRGB(Random r){
//        return calcRandomBlue(r);
//    }

    static public Paint calcRandomRed(Random r){
        return Color.rgb(r.nextInt(150)+105,
                r.nextInt(100), r.nextInt(40));
    }

    static public Paint calcRandomYellow(Random r){
        return Color.rgb(255,
                r.nextInt(100)+155, r.nextInt(50));
    }

    static public Paint calcRandomGreen(Random r){
        return Color.rgb(r.nextInt(130),
                r.nextInt(150)+105, r.nextInt(50));
    }

    static public Paint calcRandomBlue(Random r){
        return Color.rgb(r.nextInt(80),
                r.nextInt(130), r.nextInt(150)+100);
    }

}
