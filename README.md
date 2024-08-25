# MinifyCode

**MinifyCode**, HTML, CSS ve JavaScript dosyalarını küçülten (minify eden) bir araçtır. Bu araç, web projelerinizdeki dosya boyutlarını azaltarak sayfa yükleme sürelerini iyileştirmenize yardımcı olur. Özellikle performans optimizasyonu ve daha hızlı kullanıcı deneyimi sağlamak için geliştirilmiştir.

## Özellikler

- HTML, CSS ve JavaScript dosyalarını küçültme.
- Basit ve kullanıcı dostu arayüz.
- Dosya boyutlarını önemli ölçüde azaltarak daha hızlı yükleme süreleri sağlar.
- Web projelerinde kullanılmak üzere optimize edilmiştir.

## Gereksinimler

- Java 8 veya daha yeni bir sürümü.

## Kullanım

### Komut Satırı Kullanımı

```sh
java -jar MinifyCode.jar <input-dosyasi> <output-dosyasi>
```

## Örnek
```sh
java -jar MinifyCode.jar input.html output.html
java -jar MinifyCode.jar style.css style.min.css
java -jar MinifyCode.jar script.js script.min.js
