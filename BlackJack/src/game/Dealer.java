package game;

/**
 * プレイヤーの機能をすべて持ちながら、親としての機能を持つDealerクラス
 * @author oda
 * @version 1.0
 */
class Dealer extends Player{

    /**
     * コンストラクタ
     * 親クラスのコンストラクタを実行して初期化する
     * @param name
     * @param icon
     * @param deck
     */
    Dealer(String name, String icon, CardDeck deck){
        super(name,icon,deck);
    }

    /**
     * over16メソッド
     * 手札の点数合計が16以下の間、手札を引く
     */
    void over16(){
        //手札の点数合計が16以下の場合true
        while(score() <= 16){
            //手札を１枚引く
            addACard();
        }
    }

    /**
     * halfメソッド
     * アイコン、名前、スコアと手札の１枚目の文字列表現を返す
     * 手札の２枚目以降は**を返す
     * 
     * @return アイコン、名前、スコアと手札の１枚目の文字列表現
     * と手札の２枚目以降の枚数分の**を連結した値
     */
    String half(){
        StringBuilder status = new StringBuilder();
        //アイコン、名前、点数の文字列を連結
        status.append(getIcon())
              .append(getName())
              .append("[?点]---");
        //手札の1枚目の文字列を連結
        halfStr(status);
        //手札の２枚目以降の枚数分の文字列"**"を連結
        for(int i=1; i < getHand().size(); i++){
            status.append(" **");
        }
        //連結した文字列をString型に変換して返却
        return status.toString();
    }
    
    /**
     * halfStrメソッド
     * １枚目の手札の文字列表現を引数に追加する
     * @param handNumOne 手札の１枚目
     */
    private void halfStr(StringBuilder handNumOne){
        //引数handNumOneに手札の１枚目を連結
        handNumOne.append(getHand().get(0));
    }
}
