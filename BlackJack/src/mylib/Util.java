package mylib;

import java.util.Scanner;
import java.util.NoSuchElementException;
// import java.lang.NullPointerException;

/**
 * いろいろなアプリケーションで利⽤できる汎⽤メソッドを持つクラス
 * @author oda
 * @version 1.0
 */
public class Util {
    /**
     * キーボードからの入力用
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * getStringメソッド
     * 引数で受けとった文字列を入力ガイダンスとして表示し
     * キーボードから入力された文字列を受け取って返す
     * 入力された文字列長が0以下の場合はnullを返す
     * @param guidance 入力ガイダンスの文字列
     * @return キーボードから入力された文字列
     */
    public static String getString(String guidance){

        //入力ガイダンスを表示
        System.out.println(guidance);

        //キーボードからの入力を受け取る
        //rt = 戻り値
        String rt;
        try {
            //キーボードからの入力
            String input = scanner.nextLine();
            //入力された文字列長が０の場合true
            if(input.length() <= 0){
                rt = null;
            }else{
                rt = input;
            }
        }
        //キーボードからの入力時に例外が起きた場合の処理
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("入力されたのはnull"); 
            rt = null;
        }
        return rt;        
    }

    /**
     * 引数で受けとった文字列を入力ガイダンスとして表示し
     * キーボードから入力された文字列を受け取ってint型に変換して返す
     * @param guidance 入力ガイダンスの文字列
     * @return キーボードから入力された文字列をint型に変換した値
     */
    public static int getInt(String guidance){

        //入力ガイダンスを表示
        System.out.println(guidance);

        //rt = 戻り値
        int rt = 0;
        //キーボードから入力を受け取る
        try {
            //キーボードからの入力
            String input = scanner.nextLine();
            //入力した文字列がすべて数字だった場合true
            if(input.matches("\\d+")){
                //入力した文字列の数値をint型に変換
                rt = Integer.parseInt(input);
            }
        }
        //入力された文字列が整数値のみでない場合の例外
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("入力された文字列が整数値のみではないため0を返します");
        }
        //入力がnullだった場合の例外
        catch(NullPointerException e){
            System.out.println("入力が行われなかったため0を返します");
        }

        return rt;
    }

    /**
     * 引数で受けとった文字列を入力ガイダンスとして表示し
     * キーボードから入力された文字列を受け取ってdouble型に変換して返す
     * @param guidance 入力ガイダンスの文字列
     * @return キーボードから入力された文字列をdouble型に変換した値
     */
    public static double getDouble(String guidance){

        //入力ガイダンスを表示
        System.out.println(guidance);

        //戻り値
        double rt = 0;

        //キーボードからの入力を受け取る
        try {
            //キーボードからの入力
            String input = scanner.nextLine();
            //入力した文字列をdouble型に変換
            rt = Double.parseDouble(input);
        }
        //キーボードから入力時に起きる例外処理と
        //入力した文字列をdouble型に変換したときに起きる例外処理
        catch (NoSuchElementException | IllegalStateException 
               | NullPointerException | NumberFormatException e) {
            System.out.println("文字列が数値でなかったため0を返します");
        }

        return rt;
    }

    /**
     * 引数で受けとった文字列を入力ガイダンスとして表示し
     * キーボードから入力された文字列を受け取って1文字目をchar型に変換して返す
     * @param guidance 入力ガイダンスの文字列
     * @return キーボードから入力された文字列の1文字目をhc型に変換した値
     */
    public static char getChar(String guidance){

        //入力ガイダンスを表示
        System.out.println(guidance);

        //戻り値
        char rt = '0';

        //キーボードからの入力を受け取る
        try {
            //キーボードからの入力
            String input = scanner.nextLine();
            //入力した文字列の1文字目をchar型に変換
            rt = input.charAt(0);
        }
        //キーボードからの入力が文字でなかった場合の例外処理
        catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("文字でなかったため0を返します");
        }
        //キーボードからの入力がnullだった場合の例外処理
        catch (IndexOutOfBoundsException e){
            System.out.println("入力が行われなかったため0を返します");
        }
        
        return rt; 
    }
}
