package creator;

/**
 * @author gujiewei
 * @create 2018/10/7
 * @desc
 **/
public class High extends Middle{
    protected String[] singleOpt={"^2","^0.5","tan","cos","sin"};

    public High(){}
    public High(int optNum){
        this.optNum=optNum;
        res=singleOpt[rand.nextInt(3)+2]+(rand.nextInt(100)+1);
        sum=parseNum(res);
    }

    public String getSingleOpe(){
        String singleOpe=rand.nextInt(101)+"";
        singleOpe=addSingleOpt(singleOpe);
        return singleOpe;
    }

    public void singleOptOverBra(){
        int dice=rand.nextInt(15);
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
        else if(dice==2){
            addBrakets();
            res="tan"+res;
            sum=Math.tan(sum);
            minPri=3;
        }
        else if(dice==3){
            addBrakets();
            res="cos"+res;
            sum=Math.cos(sum);
            minPri=3;
        }
        else if(dice==4){
            addBrakets();
            res="sin"+res;
            sum=Math.sin(sum);
            minPri=3;
        }
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
        else if(tmp.contains("tan")){
            double a=Integer.parseInt(tmp.substring(3,tmp.length()));
            return Math.tan(a);
        }
        else if(tmp.contains("cos")){
            double a=Integer.parseInt(tmp.substring(3,tmp.length()));
            return Math.cos(a);
        }
        else if(tmp.contains("sin")){
            double a=Integer.parseInt(tmp.substring(3,tmp.length()));
            return Math.sin(a);
        }
        else{
            return Integer.parseInt(tmp);
        }
    }

    //对该操作数随机添加单操作符
    public String addSingleOpt(String formula){
        int dice=rand.nextInt(10);
        if(dice==0){
            return formula+singleOpt[0];
        }
        else if(dice==1){
            return formula+singleOpt[1];
        }
        else if(dice==2){
            return singleOpt[2]+formula;
        }
        else if(dice==3){
            return singleOpt[2]+formula;
        }
        else if(dice==4){
            return singleOpt[2]+formula;
        }
        return formula;
    }
}
