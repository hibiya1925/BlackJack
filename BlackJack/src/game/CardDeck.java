package game;

import java.util.List;
import java.util.ArrayList;
/**
 * 52枚のカードをセットしたクラスCardDeck
 * @author oda
 * @version 1.0
 */
class CardDeck {

    /**
     * セットするカード枚数
     */
    private int max;

    /**
     * カードの配列
     */
    private List <Card> deck;

    /**
     * コンストラクタ
     * maxをフィールドにセットする
     * フィールドdeckのインスタンス生成
     * カードデッキを初期化する
     * @param max セットするカード枚数
     */
    CardDeck(int max){
        //maxをフィールドにセット
        this.max = max;
        //デッキのインスタンス生成
        deck = new ArrayList<Card>(max);
        //カードデッキを初期化
        initialize();
    }

    /**
     * initializeメソッド
     * deckの中身をすべて削除する
     * deckにカードをmax枚まで追加する
     */
    private void initialize(){
        //deckの中身をすべて削除する
        deck.clear();
        //deckにカード(Cardオブジェクト)をmax枚まで追加
        for(int i=0; i < max; i++){
            //deckのListのi番目の要素にiの値を格納
            deck.add(new Card(i));
        }
    }

    /**
     * indexOfメソッド
     * k番目のカードを返却する
     * @param k 返却するカードの番号
     * @return　k番目のカードを返却する
     */
    private Card indexOf(int k){
        //deckのListのk番目の要素を返却
        return deck.get(k);
    }

    /**
     * sizeメソッド
     * 現在の残りカード枚数を返す
     * @return　deck配列のnullではない要素の数
     */
    int size(){
        //カウンタ用変数、戻り値
        int count = 0;
        //Listの要素を0番目からすべて取り出すループ
        for(Card allCard : deck){
            //取り出した要素がnullではなかった場合true
            if(!(allCard == null)){
                //カウンタに１足す
                count++;
            }
        }

        //deckのListのnullではない要素の数を戻り値として返却
        return count;
    }

    /**
     * nextメソッド
     * デッキから１枚カードを取り出す時に使う
     * @return　deck配列のランダム番目のカード
     */
    Card next(){
        //戻り値
        Card card;

        //デッキの残り枚数
        int size = size();

        //デッキの残り枚数が0の時nullを返す
        if(size == 0){
            card = null;
        }
        //デッキの残り枚数が0ではない場合
        else{
            //乱数を取得
            int p = (int)(Math.random() * size);
            //デッキの乱数番目の要素を戻り値用変数に格納
            card = indexOf(p);
            //デッキの取り出した乱数番目の要素を削除
            deck.remove(p);
        }

        return card;
    }
}