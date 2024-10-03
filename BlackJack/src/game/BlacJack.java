package game;
import mylib.Util;

/**
 * 作成したオブジェクトを管理するクラスBlacJack
 * @author oda
 * @version 1.0
 */
public class BlacJack {
    
    /**
     * カードデッキ
     */
    private CardDeck deck;

    /**
     * ディーラー
     */
    private Dealer dealer;

    /**
     * プレイヤー
     */
    private Player player;


    /**
     * ディーラーのアイコン
     */
    private static final String DEALER_ICON = "□";

    /**
     * プレイヤーのアイコン
     */
    private static final String PLAYER_ICON = "■";

    /**
     * ゲームのバナー
     */
    private static final String BANNER = "■□■□■□■□■□■□■□";

    /**
     * カードの枚数
     */
    private static final int CARDS = 52;

    /**
     * 問い合わせメッセージ
     */
    private static final String MSG_CONTINUE = "続けますか？(ENTER or n)";

    /**
     * 1ゲームに必要なカード枚数
     */
    private static final int LIMIT = 17;

    /**
     * カードを引くか確認のメッセージ
     */
    private static final String Q_DEAL = "さらにカードを引きますか?(Enter or n)";

    /**
     * 勝負が引き分けの結果メッセージ
     */
    private static final String EVEN = "引き分け";

    /**
     * 勝負があなたの勝ちの結果メッセージ
     */
    private static final String WIN = "あなたの勝ち";

    /**
     * 勝負がディーラーの勝ちの結果メッセージ
     */
    private static final String LOST = "ディーラーの勝ち";

    /**
     * アニメーション文字アイコン
     */
    private static final String ANIME_ICON = "□■";

    /**
     * 表示回数
     */
    private static final int TIMES = 25;

    /**
     * 表示時間
     */
    private static final int DELAY = 20;



    /**
     * コンストラクタ
     * 引数をCARDS(52)を使用してdeckのインスタンス作成
     * 引数のdNmameを使用してdealreのインスタンス作成
     * 引数のpNameを使用してplayerのインスタンス作成
     * @param dName ディーラーの名前
     * @param pName プレイヤーの名前
     */
    public BlacJack(String dName, String pName){
        //デッキのインスタンス作成
        deck = new CardDeck(CARDS);
        //ディーラーのインスタンス作成
        dealer = new Dealer(dName, DEALER_ICON, deck);
        //プレイヤーのインスタンス作成
        player = new Player(pName, PLAYER_ICON, deck);
    }

    /**
     * initializeメソッド
     * デッキの残り枚数が1ゲームに必要なカード枚数より少ないときdeckを初期化する
     * dealerを初期化する。playerを初期化する。
     */
    private void initialize(){
        //デッキの残り枚数がLIMIT(17)より少ない場合true
        if(deck.size() < LIMIT){
            //デッキを５２枚で初期化
            deck = new CardDeck(CARDS);
        }
        //dealerを初期化
        dealer.initialize();
        //playerを初期化
        player.initialize();
    }

    /**
     * showメソッド
     * ディーラーとプレイヤーの手札を表示する
     */
    private void show(){
        //ディーラーの手札を表示
        System.out.println(dealer);
        //プレイヤーの手札を表示
        System.out.println(player);
    }

    /**
     * playメソッド
     * BlackJackのゲームを始める
     */
    public void play(){

        //バナーを表示
        System.out.println(BANNER);

        //無限ループ
        while(true){

            //デッキの残り枚数が１ゲームに必要なカード枚数より少ない時
            //deck, dealer, playerを初期化する
            initialize();

            //ディーラーの手札は１枚だけ
            //プレイヤーの手札はすべて表示する
            showHalf();

            //プレイヤーは必要なだけ手札を引く
            deal();

            //ディーラーの点数が１６超えるまでカード引く

            dealer.over16();

            //バナーを表示
            animation(TIMES,DELAY,ANIME_ICON);

            //ディーラーとプレイヤーの手札公開
            show();

            //ディーラーとプレイヤーの点数を比較し、判定結果を表示する
            judge();

            //続けてゲームを実行するか問い合わせメッセージを表示
            String type = Util.getString(MSG_CONTINUE);

            //応答がnullであればゲームの初期化から繰り返す
            //応答がnull以外であればゲーム終了
            if(type != null){
                System.out.printf("%sBlackJack END%s",BANNER
                                                     ,BANNER);
                break;
            }
        }        
    }

    /**
     * showHalfメソッド
     * ディーラーの手札は１枚だけ、プレイヤーの手札はすべて表示する
     */
    private void showHalf(){
        //ディーラーの手札を１枚だけ表示
        System.out.println(dealer.half());
        //プレイヤーの手札をすべて表示
        System.out.println(player.toString());
    }

    /**
     * dealメソッド
     * プレイヤーの必要なだけカードを引く
     * スコアが２１点を超えたらそれ以上は引けない
     * さらにカードを引くかメッセージを表示する
     * キーボードから入力してもらう
     * 入力値がnull以外なら、もうこれ以上引かない
     * 入力値がnullなら１枚カードを引く
     * ディーラーの手札は１枚だけ見せる
     * プレイヤーの手札はすべて見せる
     */
    private void deal(){
        //プレイヤーの点数が21より大きい場合ループを抜ける
        while(player.score() <= 21){
            //カードを引くかメッセージを表示し
            //キーボードから入力した値をtypeに格納
            String type = Util.getString(Q_DEAL);
            //キーボードから入力した値がnullだった場合カードを引く
            if(type == null){
                player.addACard();
            }
            //入力した値がnull以外だった場合ループを抜ける
            else{
                break;
            }
            //ディーラーの手札を１枚だけ表示し
            //プレイヤーの手札をすべて見せる
            showHalf();
        }
    }


    /**
     * judgeメソッド
     * スコアを比較し勝敗を表示する
     * お互い２１より大きい または 同じなら引き分け
     * プレイヤーが２１以下でディーラーより大きい または
     * ディーラーが２１を超えているならプレイヤーの勝ち
     * 上記以外は負け。
     */
    private void judge(){

        //得点の上限
        int maxScore = 21;
        
        //プレイヤーの点数
        int pScore = player.score();

        //ディーラーの点数
        int dScore = dealer.score();

        //プレイヤーの点数 差 ディーラーの点数 をreslutに格納
        //result = 0 同点
        //result > 0 プレイヤーの勝ち
        //result < 0 ディーラーの勝ち
        int result = pScore - dScore;

        //プレイヤーとディーラー両方の点数が21を超えた場合
        //もしくはプレイヤーとディーラーの点数が同じ場合true
        if((pScore > maxScore && dScore > maxScore) || result == 0){
            //引き分けと表示
            System.out.println(EVEN);
        }
        //プレイヤーの点数が21以下 かつ
        //ディーラーの点数より大きい もしくは ディーラーの点数が21を超えている場合true
        else if(pScore <= maxScore
                 &&(dScore > maxScore || result > 0)){
            //プレイヤーの勝ちと表示
            System.out.println(WIN);
        }
        //上記以外の条件の場合
        else{
            //ディーラーの勝ちと表示
            System.out.println(LOST);
        }
    }

    /**
     * animationメソッド
     * バナーのアニメーションを表示する
     * @param time 表示回数
     * @param delay 表示時間
     * @param icon 表示するアイコン
     */
    private void animation(int time,int delay,String icon){
        //スレッドを宣言
        Thread th = new Thread();
        //スレッドを開始
        th.start();
        //引数の表示回数分処理を行うループ
        for(int i=0; i < time; i++){
            try {
                //アイコンを表示
                System.out.printf("%s",icon);
                //引数の表示時間の間スレッドを一時休止
                Thread.sleep(delay);
            }
            //sleepメソッドの例外処理
            catch (InterruptedException e) {
                //例外の情報を表示
                e.printStackTrace();
            }
        }
        //改行
        System.out.println();
    }


}
