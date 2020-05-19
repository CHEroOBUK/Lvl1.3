package GB;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int chooseGame;
        int again = 1;
        while (again != 2){
            System.out.println(" Доступно две игры: 1 - Угадай число, 2 - Угадай слово");
            System.out.print("Введите номер игры, в которую хотите сыграть (1 или 2): ");
            chooseGame = check12(scanner.nextInt());
            if ((chooseGame == 1)) {
                gameNumbers();
            } else {
                gameWords();
            }
            System.out.print("Хотите еще поиграть? (1 - Да, 2 - Нет): ");
            again = check12(scanner.nextInt());
            System.out.println();
        }
        scanner.close();
    }

    static void gameNumbers(){
        int hidden = (int) (Math.random() * 10);
        int guess;
        System.out.println("Компьютер загадал число от 0 до 9, попробуйте угадать с 3х попыток:");
        for (int i = 0; i < 3; i++){
            System.out.print("Попытка " + (i + 1) + ": ");
            guess = check09(scanner.nextInt());
            if (hidden == guess){
                System.out.println("Вы угадали");
                return;
            }
            System.out.println("Загаданное число " + ((guess<hidden)? "больше":"меньше"));
        }
        System.out.println("Попытки закончились, Вы проиграли. Загаданное число: " + hidden);
    }

    static int check09 (int check){
        while (check < 0 || check > 9){
            System.out.print("Нужно ввести число от 0 до 9:  ");
            check = scanner.nextInt();
        }
        return check;
    }

    static int check12 (int check){
        while (check != 1 && check != 2){
            System.out.print("Нужно ввести число 1 или 2:  ");
            check = scanner.nextInt();
        }
        return check;
    }

    static void gameWords(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "pepper", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "broccoli", "olive", "pumpkin", "peanut", "pear", "nut", "pineapple", "pea", "potato"};
        String hidden = words[(int) (Math.random() * words.length)];
        byte count = 0;
        String guess = "";
        String[][] forQuestion = new String[5][5];
        for (int i = 0; i < forQuestion.length; i++){
            int x = i;
            for (int j = 0; j < forQuestion.length; j++){
                forQuestion[i][j] = words[x];
                x+=5;
                System.out.print(forQuestion[i][j] + "\t\t");
            }
            System.out.println();
        }

        System.out.println("\nПопробуйте отгадать загаданное слово из верхнего списка");

        while (count < hidden.length() || hidden.length() != guess.length()) { // || + решение ошибки pea - peanut
            char[] answerArray = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
            count = 0;
            System.out.print("\nВаш вариант: ");
            guess = scanner.next();
            for (int i = 0; i < hidden.length() && i < guess.length(); i++) {
                if (guess.charAt(i) == hidden.charAt(i)) {
                    answerArray[i] = guess.charAt(i);
                    count++;
                }
            }
            for (char x : answerArray)
                System.out.print(x);
        }
        System.out.println("\nВы угадали: <" + hidden + ">");
    }
}
