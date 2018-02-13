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

import javafx.scene.text.*;


public class Main extends Application {
    double x = 0.0d;
    double z = 0.0d;
    int score = 0;
    boolean dead = false;

    @Override
    public void start(Stage primaryStage) {
        final PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(new Color(0, 0, 0.1d, 0.001d));

        final Group root = new Group();
        final Sphere ball = new Sphere(20.0d);
        final Box box = new Box(100.0d, 2.0d, 100.0d);
        final Box wallL = new Box(1.0d, 500.0d, 500.0d);
        final Box wallR = new Box(1.0d, 500.0d, 500.0d);
        final Box wallB = new Box(500.0d, 500.0d, 1.0d);
        final Box wallF = new Box(500.0d, 500.0d, 1.0d);
        final Box wallO = new Box(500.0d, 1.0d, 500.0d);
        final Box wallU = new Box(500.0d, 1.0d, 500.0d);
        wallF.setMaterial(material);

        // final PhongMaterial material2 = new PhongMaterial();
        // material2.setDiffuseColor(new Color(0, 0, 1d, 1d));
        // ball.setMaterial(material2);
        // wallF.setColors(0.2);
        // final Box box2 = new Box(20.0d, 20.0d, 20.0d);
        // final Box box3 = new Box(100.0d, 20.0d, 20.0d);

        // box.setTranslateX(-200.0d);
        box.setTranslateY(200.0d);

        wallL.setTranslateX(250.0d);
        wallR.setTranslateX(-250.0d);
        wallF.setTranslateZ(-250.0d);
        wallB.setTranslateZ(250.0d);
        wallO.setTranslateY(-250.0d);
        wallU.setTranslateY(250.0d);
        // box.setTranslateZ(-200.0d);

        // 透視投影カメラ
        final PerspectiveCamera cam = new PerspectiveCamera(true);

        cam.setFieldOfView(45.5d);
        // Clipping Planes
        cam.setNearClip(1.0d);
        cam.setFarClip(1_000_000.0d);

        // カメラを移動
        cam.setTranslateZ(-900.0d);
        cam.setTranslateX(100.0d);
        cam.setTranslateY(70.0d);

        // cam.getTransforms().addAll(
        //                            new Rotate(-20, Rotate.Y_AXIS),
        //                            new Rotate(-20, Rotate.X_AXIS),
        //                            new Translate(0, 0, -15)
        //                            );
        // root.getChildren().addAll(wallF);
        root.getChildren().addAll(wallL);
        root.getChildren().addAll(wallR);
        root.getChildren().addAll(wallO);
        root.getChildren().addAll(wallU);
        // root.getChildren().addAll(box);
        // root.getChildren().addAll(wallB);
        BallObj ballObj = new BallObj(1, root);
        BoardObj boardObj = new BoardObj(1, root);
        BlockObj blockObj = new BlockObj(8, root);

        // root.getChildren().addAll(ball);
        // root.getChildren().addAll(box2);

        Scene scene = new Scene(root, 640.0d, 360.0d, Color.BLACK);
        scene.setCamera(cam);

        Text t = new Text(10, 50, "This is a test");
        t.setFont(new Font(20));
        root.getChildren().addAll(t);

        //http://krr.blog.shinobi.jp/javafx/javafx%20キーボード処理
        /* アクションイベント、キーイベントの使い方を確認 */
        // ボタンに押下処理を追加する
        // Button      btn     = new Button( "push me" );
        // EventHandler<ActionEvent>      btnActionFilter = ( event ) -> { System.out.println( "button push!" ); event.consume(); };
        // btn.addEventHandler( ActionEvent.ANY , btnActionFilter );
        int speed = 30;
        // シーンにキー入力処理を追加する
        EventHandler<KeyEvent>      sceneKeyFilter  = ( event ) -> {
            // System.out.println( "key input(" + event.getText() + ")" );
            if (event.getText().equals("u")){
                // System.out.println( "uuuuukey input(" + event.getText() + ")" );
                if ((boardObj.Z[0] + boardObj.size/2) < 250){
                    this.z = 10.0d;
                    boardObj.move(0, 0, 1, speed);
                }
            } else if (event.getText().equals("h")){
                // System.out.println( "hhhhhkey input(" + event.getText() + ")" );
                if ((boardObj.X[0] - boardObj.size/2) > -250){
                    this.x = -10.0d;
                    boardObj.move(-1, 0, 0, speed);
                }
            } else if (event.getText().equals("n")){
                // System.out.println( "nnnnnkey input(" + event.getText() + ")" );
                if ((boardObj.Z[0] - boardObj.size/2) > -250){
                    this.x = -10.0d;
                    boardObj.move(0, 0, -1, speed);
                }
                this.z = -10.0d;
            } else if (event.getText().equals("j")){
                // System.out.println( "jjjjjkey input(" + event.getText() + ")" );
                if ((boardObj.X[0] + boardObj.size/2) < 250){
                    this.x = -10.0d;
                    boardObj.move(1, 0, 0, speed);
                }
                this.x = 10.0d;
            } else if (event.getText().equals("r")){
                //restart
                // score = 0;
                // blockObj.setPlace(8);
                dead = false;
                ballObj.X[0] = 0;
                ballObj.Y[0] = 0;
                ballObj.Z[0] = 0;
                int tmp = (int)((Math.random()-0.5) * 10);
                ballObj.move(tmp, Math.abs(tmp), tmp, 10);

            }else if (event.getText().equals("s")){
                // pose
                ballObj.pose();
            } else {
                // System.out.println( "xxxxxkey input(" + event.getText() + ")" );
                boardObj.move(0, 0, 0, 0);
                this.x = 100.0d;
                this.z = 100.0d;
            }

        };
        scene.addEventFilter( KeyEvent.KEY_PRESSED , sceneKeyFilter );

        primaryStage.setTitle("JavaFX 3D 1");
        primaryStage.setScene(scene);
        primaryStage.show();
        blockObj.setPlace(8);

        //set first speed  -0.5~0.5 -> -5~5
        int tmp = (int)((Math.random()-0.5) * 10);
        ballObj.move(tmp, Math.abs(tmp), tmp, 10);
        // ballObj.move(1, 1, 1, 10);

        new AnimationTimer() {
            @Override public void handle(long currentNanoTime) {
                ballObj.move(ballObj.x, ballObj.y, ballObj.z, ballObj.s);
                boardObj.move(0, 0, 0, 0);
                blockObj.move(0,0,0,0);
                if (dead==true){
                    ballObj.move(0, 0, 0, 0);
                    return;
                }

                // check corrision

                //ball <-> wall
                if (ballObj.X[0]+ballObj.radius > 250) {
                    ballObj.move(ballObj.x*(-1), ballObj.y, ballObj.z, ballObj.s);
                }
                if (ballObj.X[0]-ballObj.radius < -250) {
                    ballObj.move(ballObj.x*(-1), ballObj.y, ballObj.z, ballObj.s);
                }
                if (ballObj.Y[0]-ballObj.radius < -250) {
                    ballObj.move(ballObj.x, ballObj.y*(-1), ballObj.z, ballObj.s);
                }
                if (ballObj.Y[0]+ballObj.radius > 250) {
                    ballObj.move(ballObj.x, ballObj.y*(-1), ballObj.z, ballObj.s);
                    System.out.println("dead");
                    dead = true;
                }
                if (ballObj.Z[0]+ballObj.radius > 250) {
                    ballObj.move(ballObj.x, ballObj.y, ballObj.z*(-1), ballObj.s);
                }
                if (ballObj.Z[0]-ballObj.radius < -250) {
                    ballObj.move(ballObj.x, ballObj.y, ballObj.z*(-1), ballObj.s);
                }

                //break a block
                for (int i = 0; i < blockObj.num; i++) {
                    if ((blockObj.show[i] == 1) &&
                        (blockObj.X[i] + blockObj.size/2) > ballObj.X[0] &&
                        (blockObj.X[i] - blockObj.size/2) < ballObj.X[0] &&
                        (blockObj.Z[i] + blockObj.size/2) > ballObj.Z[0] &&
                        (blockObj.Z[i] - blockObj.size/2) < ballObj.Z[0] &&
                         (
                          ((blockObj.Y[i] + ballObj.radius) > ballObj.Y[0]
                           &&
                           (blockObj.Y[i]) < ballObj.Y[0])
                         ||
                          ((blockObj.Y[i] - ballObj.radius) < ballObj.Y[0]
                           &&
                           (blockObj.Y[i]) > ballObj.Y[0])
                         )
                        )
                        {
                            score += 1;
                            System.out.print("Score:");
                            System.out.println(score);
                            ballObj.move(ballObj.x, ballObj.y*(-1), ballObj.z, ballObj.s);
                            blockObj.show[i] = 0;
                            root.getChildren().remove(blockObj.block[i]);
                            if (score%8 == 0){
                                blockObj.setPlace(8);
                            }

                        // System.out.print("hit:");
                        // System.out.print(i);
                        // System.out.print("  ");
                        // System.out.print(ballObj.Y[0]);
                        // System.out.print("  ");
                        // System.out.print(blockObj.Y[i]);
                        // System.out.print("  ");
                        // System.out.print(Math.random());
                        // System.out.println(i);
                    }
                }

                // board
                    if (
                        (boardObj.X[0] + boardObj.size/2) > ballObj.X[0] &&
                        (boardObj.X[0] - boardObj.size/2) < ballObj.X[0] &&
                        (boardObj.Z[0] + boardObj.size/2) > ballObj.Z[0] &&
                        (boardObj.Z[0] - boardObj.size/2) < ballObj.Z[0] &&
                         (
                          ((boardObj.Y[0] + ballObj.radius) > ballObj.Y[0]
                           &&
                           (boardObj.Y[0]) < ballObj.Y[0])
                         ||
                          ((boardObj.Y[0] - ballObj.radius) < ballObj.Y[0]
                           &&
                           (boardObj.Y[0]) > ballObj.Y[0])
                         )
                        )
                        {
                            // System.out.print("board");
                            ballObj.move(ballObj.x, ballObj.y*(-1), ballObj.z, ballObj.s);
                        }


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
