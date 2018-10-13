package ui;

import javax.swing.*;

/**
 * @author gujiewei
 * @create 2018/9/30
 * @desc
 **/
/*
 * 该类是结果显示窗口类
 */
public class ResultDisplay extends JPanel{
    private JFrame frame;
    private double result;

    public ResultDisplay(double result){
        this.result=result;
    }

    public void init(){
        frame = new JFrame("测试");
        frame.setSize(420, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        placeComponents(this);
        frame.setVisible(true);
    }

    public void placeComponents(JPanel panel){
        this.setLayout(null);

        JLabel ques=new JLabel("最终得分："+result);
        ques.setBounds(20,40,300,25);
        panel.add(ques);

        JButton jump=new JButton("重新测试");
        jump.setBounds(160,170,100,25);
        panel.add(jump);

        JButton exit=new JButton("退出程序");
        exit.setBounds(160,200,100,25);
        panel.add(exit);

        DisplayListener dl=new DisplayListener(frame);
        jump.addActionListener(dl);
        exit.addActionListener(dl);

    }
}
