package com.liyuanliang.snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    int lenth;//蛇的长度
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];
    String fx; //蛇头方向

    //构造器 用于初始化
    public GamePanel(){
        init();
    }

    //初始化
    public void init(){
        lenth = 3;
        //头部坐标
        snakeX[0] = 100;snakeY[0] = 100;
        //第一个身体坐标
        snakeX[1] = 75;snakeY[1] = 100;
        //第二个身体坐标
        snakeX[2] = 50;snakeY[2] = 100;
        fx = "R";
    }

    //画板
    //Graphics 画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);//背景颜色
        //绘制头部
        Data.header.paintIcon(this,g,25,11);

        //绘制游戏区域
        g.fillRect(25,75,850,600);

        //画一条静态小蛇
        if (fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        for (int i = 1;i < lenth;i++)
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
    }
}
