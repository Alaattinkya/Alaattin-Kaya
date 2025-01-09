[README.md](https://github.com/user-attachments/files/18361728/README.md)# Sinema Sistemi Uygulaması

## Proje Özeti
Bu proje, bir sinema sisteminin film, salon ve müşteri yönetimini sağlayan bir simülasyondur. Veriler JSON dosyalarında saklanır ve her çalışma sırasında bu dosyalardan okunarak işlenir. Programın amacı, sinema salonlarının yönetimini kolaylaştırmak ve müşteri bilgilerini takip etmektir.



---

## Özellikler
1. **Film Yönetimi**:
  - Yeni film ekleme.
  - Filmleri listeleme.
2. **Salon Yönetimi**:
  - Yeni salon ekleme.
  - Salonlara film atama.
  - Salonlardaki filmleri listeleme.

3. **Müşteri Yönetimi**:
  - Yeni müşteri ekleme.
  - Salonlardaki müşterileri listeleme.

4. **JSON Tabanlı Veri Saklama**:
   - Filmler, salonlar ve müşteriler
   - JSON dosyalarında saklanır.
     Program kapanıp tekrar açıldığında JSON dosyalarındaki verilerle çalışmaya devam eder..

5. **Kullanıcı Dostu Menü**:
   - Sistem aşağıdaki menü ile çalışır:
     ```
     1. Yeni Müşteri Ekle
     2. Filmleri ve Salonları Listele
     3. Salon Müşterilerini Listele
     4. Çıkış
     ```

---

## Kullanım
### Ana Menü
1. **Yeni Müşteri Ekle**:
   - Kullanıcı, müşterinin adını girer.
   - Kullanıcı, filmleri ve salonları listeleyerek bir salon seçer.
   - Müşteri, seçilen film ve salona kaydedilir.

2. **Filmleri ve Salonları Listele**:
   - Filmler, türü ve süresi ile birlikte listelenir.
   - Her film için gösterildiği salonlar belirtilir.

3. **Salon Müşterilerini Listele**:
   - Kullanıcı, bir salon ID'si girerek kayıtlı müşterileri görüntüleyebilir.

4. **Çıkış**:
   - Programdan çıkılır ve tüm veriler JSON dosyalarına kaydedilir.

---



