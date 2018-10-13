package ui;

import creator.High;
import creator.Middle;
import creator.Primary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author gujiewei
 * @create 2018/9/30
 * @desc
 **/
/*
 * 这是对题目显示窗口的监听和响应
 * */
public class QuesListener implements ActionListener {
    private String grade;
    private int numOfQues;
    private JLabel ques;
    private JRadioButton[] jr=new JRadioButton[4];
    private int count=0;
    private int iter=0;
    private JFrame frame;

    public QuesListener(JFrame frame,String grade,int numOfQues,JLabel ques,JRadioButton jr1,JRadioButton jr2,JRadioButton jr3,JRadioButton jr4 ){
        this.frame=frame;
        this.grade=grade;
        this.numOfQues=numOfQues;
        this.ques=ques;
        this.jr[0]=jr1;
        this.jr[1]=jr2;
        this.jr[2]=jr3;
        this.jr[3]=jr4;
        updateQues();
    }
    //检测答案是否正确并计算分数跳转到结算界面
    private int pos;
    private JRadioButton sel;

    public void updateQues(){
        Primary tmp=null;
        Random rand=new Random();
        int numOfOpt=rand.nextInt(5)+1;
        if(grade.equals("小学")){
            tmp=new Primary(numOfOpt);
        }
        else if(grade.equals("初中")){
            tmp=new Middle(numOfOpt);
        }
        else{
            tmp=new High(numOfOpt);
        }
        ques.setText(tmp.getRes());
        DecimalFormat df = new DecimalFormat("#.00");
        pos=rand.nextInt(4);
        if(tmp.getSum()<1 && -1<tmp.getSum()){
            df = new DecimalFormat("0.00");
        }
        jr[pos].setText(df.format(tmp.getSum()));
        for(int i=0;i<4;i++){
            if(i!=pos){
                jr[i].setText(df.format(tmp.getSum()+rand.nextInt(100)));
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("继续")){
            if(sel==jr[pos]) {
                count++;
            }
            if((++iter)<=numOfQues){
                updateQues();
            }
            else{
                frame.dispose();
                ResultDisplay rd=new ResultDisplay(count*100/numOfQues);
                rd.init();
            }
        }
        else{
            sel=(JRadioButton) e.getSource();
        }


    }
}
