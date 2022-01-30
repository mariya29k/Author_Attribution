import java.util.Objects;

public class AuthorshipTest {
    public static void main(String[] args) throws Exception {
//        String text = Authorship.transformAndTokenize(
//                Objects.requireNonNull(Authorship.readFromFile(
//                        "C:\\Users\\Legion\\IdeaProjects\\regextest\\" +
//                                "src\\AuthorshipAttribution\\jovkov\\" +
//                                "Jordan_Jovkov_-_Staroplaninski_legendi_-_522-b.txt"
//                ))
//        );
//
//        Authorship.writeToFile("C:\\Users\\Legion\\IdeaProjects\\regextest\\src\\jovkovWords.txt", text);
//
        Authorship counterOfWords = new Authorship(
                Authorship.transformAndTokenize(
                        Objects.requireNonNull(Authorship.readFromFile(
                                "C:\\Users\\Legion\\IdeaProjects\\regextest\\src\\jovkovWords.txt"
                        ))
                )
        );

        System.out.printf("%s: %d\n", "Number of words in Jordan Jovkov's texts", counterOfWords.getData().length);

        System.out.printf("%s: %d\n","Number of characters in " +
                "Jordan Jovkov's texts", (Objects.requireNonNull(Authorship.readFromFile(
                        "C:\\Users\\Legion\\IdeaProjects\\regextest\\src\\jovkovWords.txt"
                )).length()));

        Authorship counterOfWords2 = new Authorship(
                Authorship.transformAndTokenize(
                        Objects.requireNonNull(Authorship.readFromFile(
                                "C:\\Users\\Legion\\IdeaProjects\\regextest\\src\\vazovWords.txt"
                        ))
                )
        );

        System.out.println();

        System.out.printf("%s: %d\n", "Number of words in Ivan Vazov's texts", counterOfWords.getData().length);

        System.out.printf("%s: %d\n","Number of characters in " +
                "Ivan Vazov's texts", (Objects.requireNonNull(Authorship.readFromFile(
                "C:\\Users\\Legion\\IdeaProjects\\regextest\\src\\vazovWords.txt"
        )).length()));
    }
}
/*
Jordan Jovkov -  - . Chiflikyt kraj granitsata - 7863
Jordan_Jovkov_-_Pesenta_na_koleletata_-_521-b
Jordan_Jovkov_-_Prikljuchenijata_na_Gorolomov_-_2034-b
Jordan_Jovkov_-_Staroplaninski_legendi_-_522-b
 */