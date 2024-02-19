## Spis Treści

1. [Opis założeń projektu](#1-opis-założeń-projektu)
2. [Specyfikacja wymagań](#2-specyfikacja-wymagań)
3. [Opis struktury projektu](#3-opis-struktury-projektu)
4. [Harmonogram realizacji projektu](#4-harmonogram-realizacji-projektu)
5. [Prezentacja warstwy użytkowej projektu](#5-prezentacja-warstwy-użytkowej-projektu)
6. [Podsumowanie](#6-podsumowanie)
7. [Literatura](#7-literatura)

## 1. Opis założeń projektu

Na rynku istnieją różnorodne sklepy i serwisy aukcyjne, każdy z własnymi regułami. Projekt zakłada zastosowanie kolejki FIFO (first in first out) do zarządzania zamówieniami, co ma na celu szybką realizację i zadowolenie klienta.

## 2. Specyfikacja wymagań

### Wymagania funkcjonalne:

- Logowanie się do systemu
- Rozdzielenie użytkowników na klienta i sprzedawcę
- Obsługa kolejki przez sprzedawcę
- Dodawanie zamówień do listy klienta
- Zapis informacji o kliencie i sprzedawcy w pliku CSV

### Wymagania niefunkcjonalne:

- Wydajność, użyteczność, skalowalność, niezawodność, bezpieczeństwo
- Aplikacja dostępna 24/7/365
- Maksymalny czas oczekiwania na otwarcie nowego okna - 2 sekundy

## 3. Opis struktury projektu

Realizacja w języku Java, wykorzystanie standardowych bibliotek Java. Projekt zawiera klasy takie jak Klient, Sprzedawca, MagazynSklepowy, obsługujące różne aspekty zarządzania sklepem i klientami.

## 4. Harmonogram realizacji projektu

Najwięcej czasu poświęcono na GUI, usprawnienie kolejki i naprawę błędów. Projekt wykorzystuje system kontroli wersji Git.

## 5. Prezentacja warstwy użytkowej projektu

Przedstawiono interfejs użytkownika, w tym okna powitalne, logowania, rejestracji, sklepu, kasy i obsługi sprzedawcy.

## 6. Podsumowanie

Projekt realizuje funkcjonalność zarządzania sklepem, obsługując zarówno sprzedawców jak i klientów. Dane zapisywane są w pliku CSV.

## 7. Literatura

- Java Homework Projects – 11th Edition: A JFC GUI Swing Tutorial, Philip Conrod, Lou Tylee
- Java: Java Front End Programming, Andy Vickler
- [Java GUI](https://www.guru99.com/java-swing-gui.html)
- [Obsługa muzyki w Java](https://4programmers.net/Forum/Newbie/246891-odtwarzanie_muzyki_w_javie)
