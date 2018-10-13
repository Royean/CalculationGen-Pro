package creator;

import java.util.Random;

/**
 * @author gujiewei
 * @create 2018/10/4
 * @desc
 **/

public class Primary{
    protected String[] doubleOpt={"+", "-", "×", "÷"};
    private int[] priority={0,0,1,1};
    protected Random rand =new Random();
    protected double sum=0d;
    protected int optNum;
    protected String res;
    protected int minPri=3;

    public Primary(){}

    public Primary(int optNum){
        this.optNum=optNum;
        res=getSingleOpe();
        sum=parseNum(res);
    }

    public double getSum(){
        return sum;
    }

    public String getRes(){
        while(optNum>0){
            int dice=rand.nextInt(2);
            //往右边延申式子
            if(dice==0){
                dice=rand.nextInt(4);
                String tmp=addDoubleOptR(dice);
                res=res+tmp;
                optNum--;
            }
            //往左边延申式子
            else {
                dice=rand.nextInt(4);
                res=addDoubleOptL(dice)+res;
                optNum--;
            }
            singleOptOverBra();
        }
        return res+"=";
    }

    public void singleOptOverBra(){
        return ;
    }
    //为当前操作数添加括号
    public String addBrakets(){
        res= "("+res+")";
        return res;
    }

    //产生一个随机数
    public String getSingleOpe(){
        return (rand.nextInt(100)+1)+"";
    }

    public double parseNum(String tmp){
        return Integer.parseInt(tmp);
    }

    //双元 运算符 向右  添加
    public String addDoubleOptR(int dice){
        String tmp=getSingleOpe();
        //对新的操作数 进行解析
        double num=parseNum(tmp);
        sum=calculate(dice,sum,num);
        if(priority[dice]>=minPri){
            res=addBrakets();
            minPri=priority[dice];
        }
        if(priority[dice]<minPri) minPri=priority[dice];
        return doubleOpt[dice]+tmp;
    }

    //双元运算符向左添加
    public String addDoubleOptL(int dice){
        String tmp=getSingleOpe();
        double num=parseNum(tmp);
        sum=calculate(dice,num,sum);
        if(priority[dice]>=minPri){
            addBrakets();
            minPri=priority[dice];
        }
        if(priority[dice]<minPri) minPri=priority[dice];
        return tmp+doubleOpt[dice];
    }

    //四则运算
    public double calculate(int dice,double tmp1,double tmp2){
        if(dice==0){
            return tmp1+tmp2;
        }
        else if(dice==1){
            return tmp1-tmp2;
        }
        else if(dice==2){
            return tmp1*tmp2;
        }
        else{

            return tmp1/tmp2;
        }
    }
}
