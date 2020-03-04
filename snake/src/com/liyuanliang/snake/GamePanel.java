package com.liyuanliang.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int lenth;//蛇的长度
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];
    String fx; //蛇头方向

    boolean isStart = false;//游戏是否开始

    Timer timer = new Timer(100,this);//定时器

    //定义一个食物
    int foodX;
    int foodY;
    Random random = new Random();//随机数

    //构造器 用于初始化
    public GamePanel(){
        init();
        //获取键盘的监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();//让时间动起来
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

        //食物
        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);
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

        //画静态小蛇头部
        if (fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        //画小蛇身体
        for (int i = 1;i < lenth;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //画食物
        Data.food.paintIcon(this,g,foodX,foodY);

        //游戏提示：是否开始
        if(isStart==false){
            //显示一个文字
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }
    }


    //接收键盘的输入
    @Override
    public void keyPressed(KeyEvent e) {
        //获取按下键盘是哪个键
        int keyCode = e.getKeyCode();
        if (keyCode==KeyEvent.VK_SPACE){//如果按下的是空格键
            isStart = !isStart;
            repaint();//刷新界面
        }
        //键盘控制走向
        if(keyCode==KeyEvent.VK_LEFT){
            fx = "L";
        }else if(keyCode==KeyEvent.VK_RIGHT){
            fx = "R";
        }else if(keyCode==KeyEvent.VK_UP){
            fx = "U";
        }else if(keyCode==KeyEvent.VK_DOWN){
            fx = "D";
        }
    }

    //定时器 监听时间：帧       ||（接口实现方法）
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始
        if(isStart){
            //右移
            for (int i = lenth-1; i > 0; i--){
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }
            //通过控制方向让头部移动
            if(fx.equals("R")){
                snakeX[0] = snakeX[0] + 25;//头部移动
                if(snakeX[0]>850){ snakeX[0]=25; }//边界判断
            }else if(fx.equals("L")){
                snakeX[0] = snakeX[0] - 25;//头部移动
                if(snakeX[0]<25){ snakeX[0]=850; }//边界判断
            }
            else if(fx.equals("U")){
                snakeY[0] = snakeY[0] - 25;//头部移动
                if(snakeY[0]<75){ snakeY[0]=650; }//边界判断
            }
            else if(fx.equals("D")){
                snakeY[0] = snakeY[0] + 25;//头部移动
                if(snakeY[0]>650){ snakeY[0]=75; }//边界判断
            }

            //如果小蛇的头部与食物的坐标重合
            if (snakeX[0]==foodX && snakeY[0]==foodY){
                lenth ++;//小蛇长度+1
                //重新生成食物
                foodX = 25 + 25 * random.nextInt(34);
                foodY = 75 + 25 * random.nextInt(24);
            }
            repaint();//刷新页面
        }
        timer.start();//让时间动起来
    }




    //键盘按下弹起
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //释放某个键

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
