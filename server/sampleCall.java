public class sampleCall {
  public static void main(String[] args) {
    MarkovChain chain = new MarkovChain();

    chain.addElement("ある日の超暮方の事である。一人の下人が、クソデカい羅生門の完全な真下で雨やみを気持ち悪いほどずっと待ちまくっていた。");
    chain.addElement(
        "馬鹿みたいに広い門の真下には、この大男のほかに全然誰もいない。ただ、所々丹塗のびっくりするくらい剥げた、信じられないほど大きな円柱に、象くらいある蟋蟀が一匹とまっている。クソデカ羅生門が、大河のように広い朱雀大路にある以上は、この狂った男のほかにも、激・雨やみをする巨大市女笠や爆裂揉烏帽子が、もう二三百人はありそうなものである。それが、この珍妙男のほかには全然誰もマジで全くいない。");

    // chain.printData();

    System.out.println(chain.generate());
  }
}
