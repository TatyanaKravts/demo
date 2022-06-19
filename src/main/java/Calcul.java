import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int value1 = 0;
        int value2 = 0;
        String num_sing;
        int res;
        System.out.print("Введите пример с двумя числами: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] word = str.split(" ");
        if (word.length != 3) {
            System.out.printf("throws Exception");
            scanner.close();
            return;
        }
        String [] rome = new String[]{"", "I","II","III","IV","V","VI","VII","VIII","IX", "X"};
        String [] romePS = new String[]{"", "X","XX","XXX","XL","L","LX","LXX","LXXX","XC", "C"};
        String [] arab = new String[]{"0", "1","2","3","4","5","6","7","8","9","10"};
        String [] arabM = new String[]{"", "-1","-2","-3","-4","-5","-6","-7","-8","-9","-10"};
        int typeChisel = 0;
        int Found = 0;

        for (int i = 0; i <= 10; i++) {
            if (arab[i].equals(word[0])) {
                value1 = i;
                typeChisel = 1;
            }
            if (arabM[i].equals(word[0])) {
                value1 = -i;
                typeChisel = 1;
            }
            if (rome[i].equals(word[0])) {
                value1 = i;
                typeChisel = 2;
            }
        }
        if (typeChisel == 0) {
            System.out.printf("throws Exception");
            scanner.close();
            return;
        }
        num_sing = word[1];
        for (int i = 0; i <= 10; i++){
            if (arab[i].equals(word[2])) {
                value2 = i;
                if (typeChisel == 2) {
                    System.out.printf("throws Exception");
                    scanner.close();
                    return;
                }
                Found = 1;
            }
            if (arabM[i].equals(word[2])) {
                value2 = -i;
                if (typeChisel == 2) {
                    System.out.printf("throws Exception");
                    scanner.close();
                    return;
                }
                Found = 1;
            }
            if (rome[i].equals(word[2])) {
                value2 = i;
                if (typeChisel == 1) {
                    System.out.printf("throws Exception");
                    scanner.close();
                    return;
                }
                Found = 1;
            }
        }
        if (Found == 0) {
            System.out.printf("throws Exception");
            scanner.close();
            return;
        }

        System.out.printf("VALUE1: %d\n", value1);
        System.out.printf("VALUE2: %d\n", value2);
        // System.out.printf(num_sing);
        // вычисление
        switch (num_sing) {
            case "+":
                res = value1 + value2;
                if (typeChisel == 2) {
                    int a = res / 10;
                    int b = res % 10;
                    System.out.print(romePS[a]);
                    System.out.print(rome[b]);
                } else {
                    System.out.print(res);
                }
                break;
            case "-":
                res = value1 - value2;
                if (typeChisel == 2) {
                    if (res < 0) {
                        System.out.printf("throws Exception");
                        scanner.close();
                        return;
                    }
                    int a = res / 10;
                    int b = res % 10;
                    System.out.print(romePS[a]);
                    System.out.print(rome[b]);
                } else {
                    System.out.print(res);
                }
                break;
            case "*":
                res = value1 * value2;
                if (typeChisel == 2) {
                    int a = res / 10;
                    int b = res % 10;
                    System.out.print(romePS[a]);
                    System.out.print(rome[b]);
                } else {
                    System.out.print(res);
                }
                break;
            case "/":
                if (value2 == 0) {
                    System.out.printf("throws Exception");
                    scanner.close();
                    return;
                }
                res = value1 / value2;
                if (typeChisel == 2) {
                    int a = res / 10;
                    int b = res % 10;
                    System.out.print(romePS[a]);
                    System.out.print(rome[b]);
                } else {
                    System.out.print(res);
                }
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
        }
        scanner.close();
        return;
    }
}
