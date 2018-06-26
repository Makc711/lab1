import java.io.Console;
import java.nio.charset.Charset;
import java.util.Random;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        final Integer ATTEMPTS = 8;

        String charset = System.getProperty("file.encoding");
        String task = new String(String.format("Угадайте число от 1 до 100 за %d попыток", ATTEMPTS).getBytes(), Charset.forName(charset));
        System.out.println(task);

        Random random = new Random();
        int randomValue = random.nextInt(101);

        Console console = System.console();
        if (console != null){
            Integer number;
            for (int i = 1; i <= ATTEMPTS; i++){
                number = parseInt(console.readLine("Введите число:"));
                if (number < randomValue){
                    System.out.println("Введенное число МЕНЬШЕ загаданного");
                    console.printf("Осталось %d попыток\n\n", ATTEMPTS - i);
                } else if (number > randomValue){
                    System.out.println("Введенное число БОЛЬШЕ загаданного");
                    console.printf("Осталось %d попыток\n\n", ATTEMPTS - i);
                } else{
                    System.out.println("Поздравляем! Вы угадали число!");
                    return;
                }
            }
            System.out.println("Вы проиграли!");
            System.out.println("Попытки закончились");
        }
    }
}
