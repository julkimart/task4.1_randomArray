/**
 * Задача: Массив размерностью 20, заполняется случайными целыми числами от -10 до 10.
 * Найти максимальный отрицательный и минимальный положительный элементы массива. Поменять их местами.
 * Комментарий: если первоначальный массив содержит несколько максимально отрицательных или минимально положительных эдементов,
 * то меняются местами только первые встретившиеся элементы в массиве.
 */

import java.util.Arrays;

public class Base {

    public static void main(String[] args){

        int[] array = new int[20];
        System.out.println("\nПервоначальный массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * 21) - 10);
            System.out.print(array[i] + ",  ");
        } //массив, который рандомно заполнен от -10 до 10
        System.out.println();

        int[] arrayCopy = new int[20];
        System.arraycopy(array, 0, arrayCopy, 0, 20); //создаю копию массива

        Arrays.sort(arrayCopy); //сортировка массива (который скопирован)

//        for(int i = 0; i <  arrayCopy.length; i++) {
//            System.out.print(arrayCopy[i] + ",  ");
//        } // вывод отсортированного скопированного массива

        int maxNegative = 0; //максимальный отрицательный элемент
        for(int l=0; l<arrayCopy.length; l++){
            if(arrayCopy[l] == 0 || arrayCopy[l] > 0){
                maxNegative = arrayCopy[l-1]; //максимальный отрицательный элемент
                break;
            }
        }
        System.out.println("\nмаксимальный отрицательный элемент: " + maxNegative);

        int indexOfMaxNegative = 0;
        for(int l=0; l<array.length; l++){
            if(array[l] == maxNegative){
                indexOfMaxNegative = l; //индекс макс отриц элемента в первоначальном массиве
                break;
            }
        }
        System.out.println("индекс максимального отрицательного элемента в первоначальном массиве: " + indexOfMaxNegative);

        int minPositive = 0;
        for(int l=0; l<arrayCopy.length; l++){
            if(arrayCopy[l] > 0){
                minPositive = arrayCopy[l]; //мин положительный элемент
                break;
            }
        }
        System.out.println("минимальный положительный элемент: " + minPositive); //минимальный положительный элемент

        int indexOfminPositive = 0;
        for(int l=0; l<array.length; l++){
            if(array[l] == minPositive){
                indexOfminPositive = l; //индекс мин положительного элемента в первоначальном массиве
                break;
            }
        }
        System.out.println("индекс минимального положительного элемента в первоначальном массиве: " + indexOfminPositive);

        array[indexOfMaxNegative] = minPositive; //меняю местами
        array[indexOfminPositive] = maxNegative; //меняю местами


        System.out.println("\nНовый массив: ");
        for(int i = 0; i <  array.length; i++) {
           System.out.print(array[i] + ",  ");
        } // вывод нового массива после того, как поменяла местами элементы


    }

}
