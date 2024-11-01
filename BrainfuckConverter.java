//Dodatkowe
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BrainfuckConverter {
    static int LoopMultiplier = 8;
    public static void main(String args[])
    {

        Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.print("Podaj imie:");

        String imie = scanner.nextLine();
        
        imie = convertPolishToEnglish(imie);

        System.out.println(imie);
        System.out.print(ToBrainfuck(imie));
        scanner.close();
    }
    public static String ToBrainfuck(String Text)
    {
        char[] TextArray = Text.toCharArray();
        String output = "";
        String PlusModulo = "";
        for(int z=0;z < LoopMultiplier;z++)
        {
            output += "+";
        }
        output += "[";
        for(int i=0; i < Text.length();i++)
        {
            int ascii = (int) TextArray[i];
            output += ">";

            for(int j=0;j < ascii/LoopMultiplier;j++)
            {
                output += "+";
            }
            PlusModulo += ">";

            for(int j=0;j < ascii%LoopMultiplier;j++)
            {
                PlusModulo += "+";
            }
            PlusModulo += ".";

        }
        for(int i=0;i< Text.length();i++)
        {
            output += "<";
        }
        output += "-]";
        output += PlusModulo;
        return output;
    }
    public static String convertPolishToEnglish(String input) {
        Map<Character, String> polishToEnglishMap = new HashMap<>();
        polishToEnglishMap.put('ą', "a");
        polishToEnglishMap.put('ć', "c");
        polishToEnglishMap.put('ę', "e");
        polishToEnglishMap.put('ł', "l");
        polishToEnglishMap.put('ń', "n");
        polishToEnglishMap.put('ó', "o");
        polishToEnglishMap.put('ś', "s");
        polishToEnglishMap.put('ź', "z");
        polishToEnglishMap.put('ż', "z");
        // Add uppercase letters
        polishToEnglishMap.put('Ą', "A");
        polishToEnglishMap.put('Ć', "C");
        polishToEnglishMap.put('Ę', "E");
        polishToEnglishMap.put('Ł', "L");
        polishToEnglishMap.put('Ń', "N");
        polishToEnglishMap.put('Ó', "O");
        polishToEnglishMap.put('Ś', "S");
        polishToEnglishMap.put('Ź', "Z");
        polishToEnglishMap.put('Ż', "Z");

        StringBuilder output = new StringBuilder();
        for (char ch : input.toCharArray()) {
            output.append(polishToEnglishMap.getOrDefault(ch, String.valueOf(ch)));
        }
        return output.toString();
    }
}