import java.util.List;
import net.reduls.igo.Tagger;

public class sample {
  public static void main(String[] args) {
    // 辞書ディレクトリを引数で指定
    try {
      Tagger tagger = new Tagger("ipadic");
      // 分かち書きの実行
      List<String> wakati = tagger.wakati("この文字列を分かち書きしてみる");
      System.out.println(wakati);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
