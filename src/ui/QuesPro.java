package ui;

import javax.swing.*;

/**
 * @author gujiewe
 * @create 2018/9/30
 * @desc
 **/
/*
 * 该类是题目显示窗口类
 */
public class QuesPro extends JPanel{
    private String grade;
    private int numOfQues;
    private JFrame frame;

    public QuesPro(String grade,int numOfQues){
        this.grade=grade;
        this.numOfQues=numOfQues;
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

        JLabel ques=new JLabel();
        ques.setBounds(20,40,300,25);
        panel.add(ques);

        //四个选项按钮
        ButtonGroup buttonGroup1 = new ButtonGroup();

        JRadioButton jr1=new JRadioButton();
        jr1.setBounds(50,70,150,25);
        panel.add(jr1);

        JRadioButton jr2=new JRadioButton();
        jr2.setBounds(210,70,150,25);
        panel.add(jr2);

        JRadioButton jr3=new JRadioButton();
        jr3.setBounds(50,115,150,25);
        panel.add(jr3);

        JRadioButton jr4=new JRadioButton();
        jr4.setBounds(210,115,150,25);
        panel.add(jr4);

        buttonGroup1.add(jr1);
        buttonGroup1.add(jr2);
        buttonGroup1.add(jr3);
        buttonGroup1.add(jr4);

        JButton next=new JButton("继续");
        next.setBounds(160,170,100,25);
        panel.add(next);

        QuesListener quesListener=new QuesListener(frame,grade,numOfQues,ques,jr1,jr2,jr3,jr4);
        next.addActionListener(quesListener);
        jr1.addActionListener(quesListener);
        jr2.addActionListener(quesListener);
        jr3.addActionListener(quesListener);
        jr4.addActionListener(quesListener);
    }
}
