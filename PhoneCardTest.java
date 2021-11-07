public class PhoneCardTest {
    public static void main(String[] args){
        PhoneCard a=new CardIp("account1",30,5,0.3);
        PhoneCard b=new Card201("account2",30,5,0.45);
        double a1=a.getInitMoney()-(a.getTime()*a.getMinMoney());
        double b1=b.getInitMoney()-(b.getTime()*b.getMinMoney());
        System.out.println("IP卡剩余金额"+a1);
        System.out.println("201卡剩余金额"+b1);
    }
}
class PhoneCard{
    private String cardNumber;
    private double initMoney;
    private double time;
    private double minMoney;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getInitMoney() {
        return initMoney;
    }

    public void setInitMoney(double initMoney) {
        this.initMoney = initMoney;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(double minMoney) {
        this.minMoney = minMoney;
    }
}
class CardIp extends PhoneCard{
     public CardIp(){

     }
     public CardIp(String cardNumber,double initMoney,double time,double minMoney){
         this.setCardNumber(cardNumber);
         this.setInitMoney(initMoney);
         this.setTime(time);
         this.setMinMoney(minMoney);
     }
}
class Card201 extends PhoneCard {
    public Card201() {

    }
    public Card201(String cardNumber,double initMoney,double time,double minMoney){
            this.setCardNumber(cardNumber);
            this.setInitMoney(initMoney);
            this.setTime(time);
            this.setMinMoney(minMoney);
        }
}