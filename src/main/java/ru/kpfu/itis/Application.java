package ru.kpfu.itis;

import org.jsoup.Jsoup;

import java.io.IOException;

public class Application {
  public static void main(String[] args) {
    try {
      Jsoup.connect("https://www.re-store.ru/apple-mac/").get();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
