package tahmin_et;

import java.util.Scanner;
import java.util.ArrayList;

public class SayiTahminOyunu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean devamEt = true;

        while (devamEt) {
            oyunuBaslat();
            System.out.print("Tekrar oynamak ister misiniz? (e=Evet): ");
            String cevap = scanner.next().toLowerCase();
            devamEt = cevap.equals("e");
        }

        System.out.println("Oyun sona erdi. Teşekkür ederiz!");
    }

    static void oyunuBaslat() {
        System.out.println("Sayı Tahmin Oyunu!");
        System.out.println("Bilgisayarın 1 ile 1000 arasında rastgele tuttuğu sayıyı tahmin et.");

        int random_sayi = (int) (Math.random() * 1000) + 1;
        int gir_sayi = 0;
        ArrayList<Integer> tahminListesi = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Tahmininiz: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Geçerli bir sayı giriniz.");
                scanner.next();
            }

            int oyuncuTahmini = scanner.nextInt();
            gir_sayi++;
            tahminListesi.add(oyuncuTahmini);

            if (oyuncuTahmini < random_sayi) {
                System.out.println("Daha büyük bir sayı girmelisiniz.");
            } else if (oyuncuTahmini > random_sayi) {
                System.out.println("Daha küçük bir sayı girmelisiniz.");
            } else {
                System.out.println("Tebrikler! Sayıyı " + gir_sayi+ " tahminde buldunuz.");
                System.out.println("Skorunuz: " + gir_sayi);

                if (!tahminListesi.isEmpty()) {
                    System.out.println("Tahminleriniz: " + tahminListesi);
                }

                int rekorSkor = rekorSkoruAl();
                if (gir_sayi < rekorSkor || rekorSkor == 0) {
                    rekorSkorKaydet(gir_sayi);
                    System.out.println("Tebrikler! Yeni rekor kırdınız!");
                }

                break;
            }
        }
    }

    static int rekorSkoruAl() {
       
      
        return 0;
    }

    static void rekorSkorKaydet(int skor) {
        
        System.out.println("Rekor kaydedildi: " + skor);
    }
}