import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Authorship implements Serializable {
    private String[] data;

    public Authorship(String text)
    {
        text = text.replaceAll("[^а-яА-Я\\s]", "").toLowerCase(Locale.ROOT).
                    replaceAll("\\s+", " ");
        data = text.split("\\s");
    }

    public Authorship()
    {
        setData(new String[]{"null"});
    }

    public Authorship(String[] data)
    {
        setData(data);
    }

    public Authorship(Authorship other)
    {
        setData(other.getData());
    }

    public String[] getData()
    {
        String[] copy = new String[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return copy;
    }

    public void setData(String[] data)
    {
        this.data = new String[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
    }

    public void print()
    {
        for (int i = 0; i < data.length; i++)
        {
            System.out.printf("%s ", data[i]);
            if (i%7 == 0)
            {
                System.out.println();
            }
        }
    }

    public static String readFromFile(String filePath)
    {
        try
        {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            int counter = 0;
            ArrayList<String> data = new ArrayList<>();
            while (scanner.hasNextLine())
            {
                data.add(counter, scanner.nextLine());
                ++counter;
            }
            scanner.close();

            return data.toString();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR");
            e.printStackTrace();
            return null;
        }
    }

    public static String transformAndTokenize(String rawText)
    {
        return rawText.replaceAll("[^а-яА-Я\\s]", "").toLowerCase(Locale.ROOT).
                replaceAll("\\s+", " ");
    }

    public static void writeToFile(String path, String text)
    {
        try
        {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);

            pw.print(text);

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendToFile(String path, String text)
    {
        try
        {
            File file = new File(path);
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.print(text);

            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
