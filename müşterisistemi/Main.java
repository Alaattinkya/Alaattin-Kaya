import java.io.*;
import java.util.*;

// Temel Sınıf
abstract class BaseEntity {
    private int id;
    private String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void bilgiGoster();
}

// Müşteri Sınıfı
class Musteri extends BaseEntity {
    public Musteri(int id, String name) {
        super(id, name);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Müşteri ID: " + getId() + ", Adı: " + getName());
    }
}

// Film Sınıfı
class Film {
    private String ad;
    private int sure;
    private String tur;

    public Film(String ad, int sure, String tur) {
        this.ad = ad;
        this.sure = sure;
        this.tur = tur;
    }

    public String getAd() {
        return ad;
    }

    public int getSure() {
        return sure;
    }

    public String getTur() {
        return tur;
    }

    public void bilgiGoster() {
        System.out.println("Film Adı: " + ad + ", Süresi: " + sure + " dakika, Türü: " + tur);
    }
}

// Salon Sınıfı
class Salon extends BaseEntity {
    private Film film;
    private List<Musteri> musteriler;

    public Salon(int id, String name, Film film) {
        super(id, name);
        this.film = film;
        this.musteriler = new ArrayList<>();
    }

    public Film getFilm() {
        return film;
    }

    public List<Musteri> getMusteriler() {
        return musteriler;
    }

    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Salon ID: " + getId() + ", Adı: " + getName());
        System.out.println("Gösterimdeki Film:");
        film.bilgiGoster();
        System.out.println("Kayıtlı Müşteriler:");
        for (Musteri musteri : musteriler) {
            musteri.bilgiGoster();
        }
    }
}

// JSON Yardımcı Sınıfı
class JsonUtils {
    public static <T> void writeToJsonFile(String fileName, List<T> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("[");
            for (int i = 0; i < data.size(); i++) {
                writer.write(data.get(i).toString());
                if (i < data.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readFromJsonFile(String fileName, Function<String, T> mapper) {
        List<T> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(mapper.apply(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

// Sinema Sistemi
class SinemaSistemi {
    private List<Musteri> musteriler;
    private List<Film> filmler;
    private List<Salon> salonlar;

    public SinemaSistemi() {
        this.musteriler = new ArrayList<>();
        this.filmler = new ArrayList<>();
        this.salonlar = new ArrayList<>();
    }

    public void yeniMusteriEkle(Musteri musteri, int salonIndex) {
        musteriler.add(musteri);
        salonlar.get(salonIndex).musteriEkle(musteri);
        System.out.println("Yeni müşteri eklendi: " + musteri.getName() + ", Salon: " + salonlar.get(salonIndex).getName() + ", Film: " + salonlar.get(salonIndex).getFilm().getAd());
    }

    public void yeniFilmEkle(Film film) {
        filmler.add(film);
        System.out.println("Yeni film eklendi: " + film.getAd());
    }

    public void yeniSalonEkle(Salon salon) {
        salonlar.add(salon);
        System.out.println("Yeni salon eklendi: " + salon.getName());
    }

    public void filmVeSalonlariListele() {
        System.out.println("=== Filmler ve Salonlar ===");
        for (Film film : filmler) {
            film.bilgiGoster();
            System.out.println("Gösterildiği Salonlar:");
            for (Salon salon : salonlar) {
                if (salon.getFilm().equals(film)) {
                    System.out.println("   - Salon: " + salon.getName() + " (Salon ID: " + salon.getId() + ")");
                }
            }
            System.out.println();
        }
    }

    public void salonMusterileriniListele(int salonId) {
        for (Salon salon : salonlar) {
            if (salon.getId() == salonId) {
                salon.bilgiGoster();
                return;
            }
        }
        System.out.println("Salon bulunamadı.");
    }

    public List<Film> getFilmler() {
        return filmler;
    }

    public List<Salon> getSalonlar() {
        return salonlar;
    }
}

// Main Sınıfı
public class Main {
    public static void main(String[] args) {
        SinemaSistemi sistem = new SinemaSistemi();
        Scanner scanner = new Scanner(System.in);

        // Varsayılan Filmler
        sistem.yeniFilmEkle(new Film("Inception", 148, "Bilim Kurgu"));
        sistem.yeniFilmEkle(new Film("Titanic", 195, "Romantik"));
        sistem.yeniFilmEkle(new Film("The Dark Knight", 152, "Aksiyon"));
        sistem.yeniFilmEkle(new Film("Interstellar", 169, "Bilim Kurgu"));
        sistem.yeniFilmEkle(new Film("Forrest Gump", 142, "Dram"));
        sistem.yeniFilmEkle(new Film("Avengers: Endgame", 181, "Aksiyon"));

        // Varsayılan Salonlar
        sistem.yeniSalonEkle(new Salon(1, "Salon 1", sistem.getFilmler().get(0)));
        sistem.yeniSalonEkle(new Salon(2, "Salon 2", sistem.getFilmler().get(1)));
        sistem.yeniSalonEkle(new Salon(3, "Salon 3", sistem.getFilmler().get(2)));
        sistem.yeniSalonEkle(new Salon(4, "Salon 4", sistem.getFilmler().get(3)));
        sistem.yeniSalonEkle(new Salon(5, "Salon 5", sistem.getFilmler().get(4)));
        sistem.yeniSalonEkle(new Salon(6, "Salon 6", sistem.getFilmler().get(5)));

        while (true) {
            System.out.println("\nMenü:");
            System.out.println("1. Yeni Müşteri Ekle");
            System.out.println("2. Filmleri ve Salonları Listele");
            System.out.println("3. Salon Müşterilerini Listele");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Enter'ı tüketmek için

            switch (secim) {
                case 1: // Yeni Müşteri Ekle
                    System.out.print("Müşteri Adı: ");
                    String musteriAdi = scanner.nextLine();
                    sistem.filmVeSalonlariListele();
                    System.out.print("Salon Seçiniz (ID): ");
                    int salonId = scanner.nextInt() - 1;

                    if (salonId >= 0 && salonId < sistem.getSalonlar().size()) {
                        Musteri yeniMusteri = new Musteri(sistem.getSalonlar().get(salonId).getMusteriler().size() + 1, musteriAdi);
                        sistem.yeniMusteriEkle(yeniMusteri, salonId);
                    } else {
                        System.out.println("Geçersiz seçim.");
                    }
                    break;

                case 2: // Filmleri ve Salonları Listele
                    sistem.filmVeSalonlariListele();
                    break;

                case 3: // Salon Müşterilerini Listele
                    System.out.print("Salon ID: ");
                    int id = scanner.nextInt();
                    sistem.salonMusterileriniListele(id);
                    break;

                case 4: // Çıkış
                    System.out.println("Programdan çıkılıyor...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
}
