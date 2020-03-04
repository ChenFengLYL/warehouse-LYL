package com.liyuanliang.snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
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
    }
}
