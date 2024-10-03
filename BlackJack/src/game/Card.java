package game;

/**
 * トランプのカードを表すクラスCard
 * @author oda
 * @version 1.0
 */
class Card {

    /**
     * １～５２のどれか、物理番号
     */
    private int n;

    /**
     * 1つの種類のカードの枚数
     */
    private static final int RANK = 13;

    /**
     * 得点の配列
     */
    private static final int[] SCORESTR = {1,2,3,4,5,6,7,8,9,10,10,10,10};

    /**
     * 札文字列の配列
     */
    private static final String[] NUMSTR = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    /**
     * 札種類文字列の配列
     */
    private static final String[] SUISTR = {"♠","♦","♣","♥"};

    /**
     * コンストラクタ
     * @param n カードの物理番号
     * カードの物理番号をフィールドにセットする
     */
    Card(int n){
        //カードの物理番号をフィールドにセット
        this.n = n;
    }

    /**
     * getNumメソッド
     * 物理番号（１～５２）を返す
     * @return カードの物理番号
     */
    private int getNum(){
        return n;
    }

    /**
     * cardNumberメソッド
     * カードの札番号（１～１３）を返す
     * @return 物理番号　剰余　１つの種類のカード枚数（剰余が0の時は13)
     */
    int cardNumber(){
        //札番号 = 物理番号 剰余 １つの種類のカード枚数(13)
        int rt = getNum() % RANK;

        //物理番号 剰余 1つの種類のカード枚数(13) = 0 の時true
        //剰余が0 = 札番号13
        if(rt == 0){
            rt = RANK;
        }

        //札番号
        return rt;
    }

    /**
     * suitNumberメソッド
     * 札の種類番号（０～３）を返す
     * @return (カードの物理番号　引く　１)　割る　１つの種類のカードの枚数
     */
    private int suitNumber(){
        //種類番号 = (物理番号 - 1) / 1つの種類のカードの枚数
        return (getNum() - 1) / RANK;
    }

    /**
     * scoreメソッド
     * 札の点数を返す
     * @return 得点の配列の札番号の要素
     */
    int score(){
        //札の点数 = 点数配列の(札番号 - 1)番目の要素
        return SCORESTR[cardNumber()-1];
    }

    /**
     * cardNumberStringメソッド
     * 札番号の文字列表現を返す
     * @return 札文字列の配列の札番号の要素
     */
    private String cardNumberString(){
        //札番号の文字列表現 = 札文字列配列の(札番号 - 1)番目の要素
        return NUMSTR[cardNumber()-1];
    }

    /**
     * suitNameメソッド
     * 札の種類の文字列表現を返す
     * @return 札種類文字列の配列の札種類番号の要素
     */
    private String suitName(){
        //札種類の文字列表現 = 札種類文字列配列の(札種類番号)番目の要素
        return SUISTR[suitNumber()];
    }

    /**
     * toStringメソッド
     * このクラスの文字列表現を返す
     * @return 札種類文字列 + 札文字列
     * {@inheritDoc}
     * @override 
     */
    public String toString(){
        //文字列を連結するための変数
        StringBuilder rt = new StringBuilder();

        //札種類文字列を札文字列を連結
        rt.append(suitName())
          .append(cardNumberString());

        //連結した文字列をString型に変換して返却
        return rt.toString();
    }
}