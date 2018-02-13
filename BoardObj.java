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




public class BoardObj extends GameObject{
    Box board[];
    double size = 300.0d;

    BoardObj(int num, Group root){
        super(1);
        board = new Box[1];
        board[0] = new Box(size, 10.0d, size);
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(new Color(1d, 0d, 0d, 1d));
        board[0].setMaterial(material);
        // board[0].setTranslateX();
        board[0].setTranslateY(200.0d);
        Y[0] = 200;
        // board[0].setTranslateZ();
        root.getChildren().addAll(board[0]);
    }

    void move(int xSize,int ySize, int zSize, int speed) {
        for (int i = 0; i < num; i++) {
            X[i] += xSize * speed;
            Y[i] += ySize * speed;
            Z[i] += zSize * speed;
            board[i].setTranslateX(X[i]);
            board[i].setTranslateY(200);
            // board[i].setTranslateY(Y[i]);
            board[i].setTranslateZ(Z[i]);
        }
    }

    // void bound(int x, int y, int z){
    //     // 0 is not, 1 is bound
    //     if (x > 0){

    //     }
    // }

}
