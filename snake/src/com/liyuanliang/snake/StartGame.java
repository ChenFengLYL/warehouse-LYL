package com.liyuanliang.snake;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        //绘制一个静态窗口JFrame
        JFrame frame = new JFrame("贪吃蛇小游戏");
        frame.setBounds(10,10,900,720);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
