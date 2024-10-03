package game;

import java.util.List;
import java.util.ArrayList;

/**
 * ゲームに参加するPlayerクラス
 * @author oda
 * @version 1.0
 */
class Player {

    /**
     * カードデッキ
     */
    private CardDeck deck;

    /**
     * 手札
     */
    private List <Card> hand;

    /**
     * プレイヤーの名前
     */
    private String name;

    /**
     * プレイヤーのアイコン
     */
    private String icon;

    /**
     * コンストラクタ
     * 名前、アイコン、カードデッキを対応するフィールドへセットする
     * 手札を保存する配列handのインスタンスを作成する
     * 手札の初期化を実行する
     * @param name プレイヤーの名前
     * @param icon プレイヤーのアイコン
     * @param deck カードデッキ
     */
    Player(String name, String icon, CardDeck deck){
        //名前、アイコン、カードデッキを対応するフィールドへセット
        this.name = name;
        this.icon = icon;
        this.deck = deck;
        //手札を保存する配列handのインスタンス作成
        hand = new ArrayList<Card>();
        //手札の初期化
        initialize();
    }

    /**
     * handのgetter
     * @return 手札
     */
    List<Card> getHand(){
        return hand;
    }

    /**
     * nameのgetter
     * @return 名前
     */
    String getName(){
        return name;
    }

    /**
     * iconのgetter
     * @return アイコン
     */
    String getIcon(){
        return icon;
    }


    /**
     * initializeメソッド
     * 手札の配列の中身をすべて削除する
     * 手札の配列にカードを2枚追加する
     */
    void initialize(){
        //手札の配列の中身をすべて削除
        hand.clear();
        //配列にカードを２枚追加
        for(int i=0; i < 2; i++){
            addACard();    
        } 
    }

    /**
     * addACardメソッド
     * カードデッキから１枚引く
     * 引いたカードがnullではないとき手札の配列にカードを追加する
     */
    void addACard(){
        Card draw = deck.next();
        //引いたカードがnullではないときtrue
        if(draw != null){
            //手札の配列に引いたカードを追加し処理終了
            hand.add(draw);
        }
    }

    /**
     * scoreメソッド
     * 全カードの得点合計を返す
     * @return 手札配列の全カードの得点合計
     */
    int score(){

        //得点合計
        int sum = 0;

        //手札のAの存在の有無
        boolean haveA = false;

        //手札の配列の要素を0番目からすべて取得
        for(Card allCard : hand){
            //取得したカードの得点をsumに加算
            sum += allCard.score();
            
            //取得したカード内にAが存在すればtrue
            if(allCard.cardNumber() == 1){
                //手札にAが存在するためtrueを格納
                haveA = true;
            }
        }

        //手札にAが存在し、Aの点数1を11に変更しても21を超えない場合
        //Aの点数を11として扱う
        if(haveA && sum <= 10){
            //Aの点数が 1 → 11 になるため、合計点数に10を足す
            sum += 10;
        }

        return sum;
    }

    /**
     * cardStrメソッド
     * 手札の全カードの文字列表現を返す
     * @return 手札の全カードの文字列を連結した値
     */
    private String cardStr(){
        StringBuilder handStr = new StringBuilder();
        //手札の配列の0番目の要素からすべて取得
        for(Card allCard : hand){
            //手札のカードの文字列を連結
            handStr.append(allCard)
                   .append(" ");
        }
        //手札の文字列を連結したhandStrをString型に変換して返却
        return handStr.toString();
    }

    /**
     * toStringメソッド
     * アイコン、名前、スコアと手札（全カード）の<br>
     * 文字列表現を返す
     * {@inheritDoc}
     * @override
     * @return アイコン、名前、スコアと手札（全カード）の
     * 文字列を連結した値
     */
    public String toString(){
        StringBuilder status = new StringBuilder();
        //アイコン、名前、スコア、手札の文字列を連結
        status.append(icon)
              .append(name)
              .append("[")
              .append(score())
              .append("点]---")
              .append(cardStr());
        //文字列を連結したstatusをString型に変換して返却する
        return status.toString();
    }
}











