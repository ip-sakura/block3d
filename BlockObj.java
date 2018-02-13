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




public class BlockObj extends GameObject{
    Box block[];
    int show[];
    double size = 200.0d;

    BlockObj(int num, Group root){
        super(num);
        block = new Box[num];
        show = new int[num];

        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(new Color(0d, 1d, 0d, 1d));
        for (int i = 0; i < num; i++) {
            block[i] = new Box(size, 10.0d, size);
            block[i].setMaterial(material);
        }

        // block[0].setTranslateX();
        // block[0].setTranslateY(100.0d);
        // block[0].setTranslateZ();
        root.getChildren().addAll(block);

    }


    void setPlace(int num) {
        for (int i = 0; i < num; i++) {
            show[i] = 1;
        }
        if (num == 8){
            int x0 = -100;
            int y0 = -0;
            int z0 = -100;
            X[0] = x0;
            Y[0] = y0;
            Z[0] = z0;
            x0 += 200;
            X[1] = x0;
            Y[1] = y0;
            Z[1] = z0;
            z0 += 200;
            X[2] = x0;
            Y[2] = y0;
            Z[2] = z0;
            x0 += -200;
            X[3] = x0;
            Y[3] = y0;
            Z[3] = z0;
            z0 += -200;
            y0 += -100;
            X[4] = x0;
            Y[4] = y0;
            Z[4] = z0;
            x0 += 200;
            X[5] = x0;
            Y[5] = y0;
            Z[5] = z0;
            z0 += 200;
            X[6] = x0;
            Y[6] = y0;
            Z[6] = z0;
            x0 += -200;
            X[7] = x0;
            Y[7] = y0;
            Z[7] = z0;

        }

        // for (int i = 0; i < num; i++) {
        //     X[i] = x0;
        //     Y[i] = y0;
        //     Z[i] = z0;
        //     x0 += 100;
        //     y0 += 0;
        //     z0 += 100;
        //     if (i == 3){
        //         y0 -= 100;
        //     }
        // }

        move(0,0,0,0);
    }

    void move(int xSize,int ySize, int zSize, int speed) {
        for (int i = 0; i < num; i++) {
            X[i] += xSize * speed;
            Y[i] += ySize * speed;
            Z[i] += zSize * speed;
            block[i].setTranslateX(X[i]);
            block[i].setTranslateY(Y[i]);
            block[i].setTranslateZ(Z[i]);
        }

    }
}
