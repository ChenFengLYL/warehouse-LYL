package com.liyuanliang.snake;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        //1.绘制一个静态窗口JFrame
        JFrame frame = new JFrame("贪吃蛇小游戏");
        frame.setBounds(10,10,900,720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //2.面板JPanel
        frame.add(new GamePanel());

        frame.setVisible(true);
    }
}
