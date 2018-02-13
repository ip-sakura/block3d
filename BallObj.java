//main
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class BallObj extends GameObject{
    Sphere ball = new Sphere();
    //Setting the properties of the Sphere
    int VX[];
    int VY[];
    int VZ[];
    double radius = 20.0d;
    int x = 0;
    int y = 0;
    int z = 0;
    int s = 0;
    boolean pose = true;

    BallObj(int num, Group root){
        super(1);
        X[0] = 0;
        Y[0] = 0;
        Z[0] = 0;
        VX = new int[num];
        VY = new int[num];
        VZ = new int[num];
        // ball = new Sphere();
        ball.setRadius(radius);
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(new Color(0, 0d, 1d, 1d));
        ball.setMaterial(material);

        root.getChildren().addAll(ball);
    }
    void pose(){
        pose = !pose;
    }
    void move(int xSize,int ySize, int zSize, int speed) {
        if (pose){
            return;
        }
        for (int i = 0; i < num; i++) {
            x = xSize;
            y = ySize;
            z = zSize;
            s = speed;
            VX[i] = xSize * speed;
            VY[i] = ySize * speed;
            VZ[i] = zSize * speed;
            X[i] += VX[i];
            Y[i] += VY[i];
            Z[i] += VZ[i];
            ball.setTranslateX(X[i]);
            ball.setTranslateY(Y[i]);
            ball.setTranslateZ(Z[i]);
        }
    }
}
