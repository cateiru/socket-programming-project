public class sampleCall {
  public static void main(String[] args) {
    MarkovChain chain = new MarkovChain();

    chain.addElement(
        "ある日の超暮方の事である。一人の下人が、クソデカい羅生門の完全な真下で雨やみを気持ち悪いほどずっと待ちまくっていた。馬鹿みたいに広い門の真下には、この大男のほかに全然誰もいない。");
    chain.addElement("ただ、所々丹塗のびっくりするくらい剥げた、信じられないほど大きな円柱に、象くらいある蟋蟀が一匹とまっている");

    chain.printData();

    System.out.println(chain.generate());
  }
}
