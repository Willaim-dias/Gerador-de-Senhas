package entities;

import java.util.Random;

public class GeneratePassword {

    private final String[] ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");//[0]
    private final String[] abc = "abcdefghijklmnopqrstuvwxyz".split("");//[1]
    private final String[] number = "0123456789".split("");//[2]
    private final String[] character = "!@#$%^&*()-_=+[]{};:'\"<>.,/?\\|`~".split("");//[3]

    private final Random random = new Random();

    public GeneratePassword() {
    }

    public String passwordStandard() {
        StringBuilder password = new StringBuilder();
        password.append(ABC[random.nextInt(ABC.length)]);
        password.append(abc[random.nextInt(abc.length)]);
        password.append(number[random.nextInt(number.length)]);
        password.append(character[random.nextInt(character.length)]);

        String[] charactersRemaining = (String.join("", ABC) + String.join("", abc) + String.join("", number) + String.join("", character)).split("");

        for (int i = 0; i < 2; i++) {
            password.append(charactersRemaining[random.nextInt(charactersRemaining.length)]);
        }

        char[] shuffle = password.toString().toCharArray();

        for (int i = 0; i < shuffle.length; i++) {
            int position = random.nextInt(shuffle.length);
            char temp = shuffle[position];
            shuffle[i] = shuffle[position];
            shuffle[position] = temp;
        }
        return new String(password);
    }

    public String passwordWithoutkey(boolean[] option, int size) {
        StringBuilder password = new StringBuilder();
        StringBuilder charactersPool = new StringBuilder();

        if (option[0]) {
            password.append(ABC[random.nextInt(ABC.length)]);
            charactersPool.append(String.join("", ABC));
        }
        if (option[1]) {
            password.append(abc[random.nextInt(abc.length)]);
            charactersPool.append(String.join("", abc));
        }
        if (option[2]) {
            password.append(number[random.nextInt(number.length)]);
            charactersPool.append(String.join("", number));
        }
        if (option[3]) {
            password.append(character[random.nextInt(character.length)]);
            charactersPool.append(String.join("", character));
        }

        String[] poolArrry = charactersPool.toString().split("");

        for (int i = password.length(); i < size; i++) {
            password.append(poolArrry[random.nextInt(poolArrry.length)]);
        }

        char[] shuffle = password.toString().toCharArray();
        for (int i = 0; i < shuffle.length; i++) {
            int position = random.nextInt(shuffle.length);
            char temp = shuffle[i];
            shuffle[i] = shuffle[position];
            shuffle[position] = temp;
        }

        return new String(shuffle);
    }
}
