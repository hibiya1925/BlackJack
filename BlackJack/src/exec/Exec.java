package exec;
import game.BlacJack;

/**
 * BlacJackを起動するためのクラス
 * @author oda
 * @version 1.0
 */
public class Exec {
    public static void main(String[] args){

        //ブラックジャックのインスタンス作成
        BlacJack bj = new BlacJack("コンピュータ","プレイヤー");
        //ブラックジャックのゲームを始める
        bj.play();

    }
}
