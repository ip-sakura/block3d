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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(new Color(0, 0, 0.1d, 0.001d));

        final Group root = new Group();
        final Box box = new Box(100.0d, 2.0d, 100.0d);
        final Box wallL = new Box(1.0d, 500.0d, 500.0d);
        final Box wallR = new Box(1.0d, 500.0d, 500.0d);
        final Box wallB = new Box(500.0d, 500.0d, 1.0d);
        final Box wallF = new Box(500.0d, 500.0d, 1.0d);
        wallF.setMaterial(material);
        // wallF.setColors(0.2);
        // final Box box2 = new Box(20.0d, 20.0d, 20.0d);
        // final Box box3 = new Box(100.0d, 20.0d, 20.0d);

        // box.setTranslateX(-200.0d);
        box.setTranslateY(300.0d);

        wallL.setTranslateX(250.0d);
        wallR.setTranslateX(-250.0d);
        wallF.setTranslateZ(-250.0d);
        wallB.setTranslateZ(250.0d);
        // box.setTranslateZ(-200.0d);

        // 透視投影カメラ
        final PerspectiveCamera cam = new PerspectiveCamera(true);

        cam.setFieldOfView(45.5d);
        // Clipping Planes
        cam.setNearClip(1.0d);
        cam.setFarClip(1_000_000.0d);

        // カメラを 500 後退させる。(Z 軸を -500)
        cam.setTranslateZ(-800.0d);

        // cam.getTransforms().addAll(
        //                            new Rotate(-20, Rotate.Y_AXIS),
        //                            new Rotate(-20, Rotate.X_AXIS),
        //                            new Translate(0, 0, -15)
        //                            );


        root.getChildren().addAll(box);
        root.getChildren().addAll(wallL);
        root.getChildren().addAll(wallR);
        root.getChildren().addAll(wallF);
        root.getChildren().addAll(wallB);
        // root.getChildren().addAll(box2);

        Scene scene = new Scene(root, 640.0d, 360.0d, Color.BLACK);
        scene.setCamera(cam);

        //http://krr.blog.shinobi.jp/javafx/javafx%20キーボード処理
        /* アクションイベント、キーイベントの使い方を確認 */
        // ボタンに押下処理を追加する
        // Button      btn     = new Button( "push me" );
        // EventHandler<ActionEvent>      btnActionFilter = ( event ) -> { System.out.println( "button push!" ); event.consume(); };
        // btn.addEventHandler( ActionEvent.ANY , btnActionFilter );

        // シーンにキー入力処理を追加する
        EventHandler<KeyEvent>      sceneKeyFilter  = ( event ) -> System.out.println( "key input(" + event.getText() + ")" );
        scene.addEventFilter( KeyEvent.KEY_PRESSED , sceneKeyFilter );

        primaryStage.setTitle("JavaFX 3D 1");
        primaryStage.setScene(scene);
        primaryStage.show();
        new AnimationTimer() {
            double iii = -500.0d;
            double jjj = 0.0d;
            @Override public void handle(long currentNanoTime) {
                for (int i = 0; i < 50; i++) {
                    // double ran = Math.random() * WIDTH;
                    // graphics.strokeOval(ran, ran, ran, ran);
                }
                // System.out.println("foo");
                System.out.println(iii);
                // cam.setTranslateZ(iii);
                iii-=1;
                jjj+=1;
                box.setTranslateX(jjj);
                // root.getChildren().addAll(box);

                // Scene scene = new Scene(root, 640.0d, 360.0d, Color.BLACK);

                //scene.setCamera(cam);

                // primaryStage.setTitle("JavaFX 3D 1");
                // primaryStage.setScene(scene);
                // primaryStage.show();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Do nothing
                }
            }
        }.start();

    }
}
