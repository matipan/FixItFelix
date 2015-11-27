package grafica.dinamica.personajes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Felix extends GGO {
  private BufferedImage aloneRunL1, aloneRunL2, aloneRunR1, aloneRunR2, basicStanding, cakeLStanding, cakeRStanding, happyStanding;

  public Felix (double xParam, double yParam) {
    this.setX(xParam);
    this.setY(yParam);
    this.setIP("src/grafica/imagenes/felix/");
    this.uploadImages();
  }

  public void uploadImages(){
    try {
        if (aloneRunL1 == null) {
            aloneRunL1 = this.up("a_runNoAxe_left_1.png");
        }
        if (aloneRunL2 == null) {
            aloneRunL2 = this.up("a_runNoAxe_left_2.png");
        }
        if (aloneRunR1 == null) {
            aloneRunR1 = this.up("a_runNoAxe_right_1.png");
        }
        if (aloneRunR2 == null) {
            aloneRunR2 = this.up("a_runNoAxe_right_2.png");
        }
        if (basicStanding == null) {
            basicStanding = this.up("a_standing_basic.png");
        }
        if (cakeLStanding == null) {
            cakeLStanding = this.up("a_standing_cake_left.png");
        }
        if (cakeRStanding == null) {
            cakeRStanding = this.up("a_standing_cake_right.png");
        }
        if (happyStanding == null) {
            happyStanding = this.up("a_standing_happy.png");
        }
    } catch (IOException e) {
        System.out.println("Internal Error:" + e.getMessage());
    }
  }
}