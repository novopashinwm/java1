package ru.progwards.java1.SeaBattle.novopashinwm;

import ru.progwards.java1.SeaBattle.SeaBattle;
import ru.progwards.java1.SeaBattle.SeaBattle.FireResult;

public class SeaBattleAlg {
    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|
    private char[][] arrBoard ;

    public void battleAlgorithm(SeaBattle seaBattle) {
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        initBoard(seaBattle);
        int hit = 0;
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
        	for (int x = 0; x < seaBattle.getSizeY(); x++) {
        		SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
        		if (fireResult != FireResult.MISS) {
        		    hit++;
                }
        		if (hit>=20) {
        		    return;
                }
            }
        }
    }

    private void initBoard(SeaBattle seaBattle) {
        arrBoard = new char[seaBattle.getSizeX()][seaBattle.getSizeY()];
        for (int i = 0; i < arrBoard[0].length; i++) {
            for (int j = 0; j < arrBoard.length; j++) {
                arrBoard[i][j] = ' ';
            }
        }
    }

    // функция для отладки
    public static void main(String[] args) {
    	System.out.println("Sea battle");
    	SeaBattle seaBattle = new SeaBattle(true);
    	new SeaBattleAlg().battleAlgorithm(seaBattle);
    	System.out.println(seaBattle.getResult());
    }
}

