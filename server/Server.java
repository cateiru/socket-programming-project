public class Server {
  public static void main(String[] args) {
    MarkovChain chain = new MarkovChain();

    chain.addElement("ある日の超暮方の事である。");
    chain.addElement("一人の下人が、クソデカい羅生門の完全な真下で雨やみを気持ち悪いほどずっと待ちまくっていた。");
    chain.addElement("馬鹿みたいに広い門の真下には、この大男のほかに全然誰もいない。");

    // chain.printData();

    System.out.println(chain.generate());
  }
}
