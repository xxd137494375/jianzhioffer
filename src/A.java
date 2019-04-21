public class A {
    int s ;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public static void main(String[] args){
        try{
            System.out.println(doStuff(-1));
//            System.out.println(doStuff(100));
        }catch(DataFormatException e){
            System.out.println("这里是永远都不会到达的"+"---"+e.toString());
        }
    }
    //该方法抛出受检异常
    public static int doStuff(int _p)throws DataFormatException{
        try{
            if(_p < 0){
                throw new DataFormatException("数据格式错误");
            }else{
                return _p;
            }
        }catch(DataFormatException e){
            //异常处理
            throw e;
        }finally{

        }

    }
}
