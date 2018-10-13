package creator;

/**
 * @author gujiewei
 * @create 2018/10/7
 * @desc
 **/
public class Middle extends  Primary{
    protected String[] singleOpt={"^2","^0.5"};

    public Middle(){}
    public Middle(int optNum){
        this.optNum=optNum;
        res=(rand.nextInt(100)+1)+singleOpt[rand.nextInt(2)];
        sum=parseNum(res);
    }

    public String getSingleOpe(){
        String singleOpe=rand.nextInt(101)+"";
        int dice=rand.nextInt(6);
        singleOpe=addSingleOpt(dice,singleOpe);
        return singleOpe;
    }

    public double parseNum(String tmp){
        if(tmp.contains("^2")){
            double a=Integer.parseInt(tmp.substring(0,tmp.length()-2));
            return a*a;
        }
        else if(tmp.contains("^0.5")){
            double a=Integer.parseInt(tmp.substring(0,tmp.length()-4));
            return Math.sqrt(a);
        }
        else{
            return Integer.parseInt(tmp);
        }
    }

    public void singleOptOverBra(){
        int dice=rand.nextInt(6);
        if(sum>=0 && dice==0){
            addBrakets();
            res+="^0.5";
            sum=Math.sqrt(sum);
            minPri=3;
        }
        else if(dice==1){
            addBrakets();
            res+="^2";
            sum=sum*sum;
            minPri=3;
        }
    }

    //对该操作数随机添加单操作符
    public String addSingleOpt(int dice,String formula){
        if(dice==0){
            return formula+singleOpt[0];
        }
        else if(dice==1){
            return formula+singleOpt[1];
        }
        return formula;
    }

}
