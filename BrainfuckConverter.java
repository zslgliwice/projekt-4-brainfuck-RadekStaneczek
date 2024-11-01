import java.util.Scanner;

public class BrainfuckConverter {
    static int LoopMultiplier = 8;
    public static void main(String args[])
    {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj imie:");

        String imie = scanner.nextLine();
        System.out.print(Convert(imie));
        scanner.close();
    }
    public static String Convert(String Text)
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
            System.out.println(ascii);
        }
        for(int i=0;i< Text.length();i++)
        {
            output += "<";
        }
        output += "-]";
        output += PlusModulo;
        return output;
    }
}