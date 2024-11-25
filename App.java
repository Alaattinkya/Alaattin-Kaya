import java.util.Scanner;

public class App {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int turk, mat, sosyal, fen, beden, muzik;

        System.out.println("Türkçe Ders Notunuz: ");
        turk = input.nextInt();

        System.out.println("Matematik Ders Notunuz: ");
        mat = input.nextInt();

        System.out.println("Sosyal Ders Notunuz: ");
        sosyal = input.nextInt();

        System.out.println("Fen Bilimleri Ders Notunuz: ");
        fen = input.nextInt();

        System.out.println("Beden Eğitimi Ders Notunuz: ");
        beden = input.nextInt();

        System.out.println("Müzik Ders Notunuz: ");
        muzik = input.nextInt();

        int lessonAvg = (turk + mat + sosyal + fen + beden + muzik) / 6;

        String finalResult;

        finalResult = (lessonAvg >= 60) ? "Sınıfı Geçtiniz!" : "Sınıfta Kaldınız!";

        System.out.println("Ders Ortalamanız: " + lessonAvg + " " + finalResult);
    }
}
