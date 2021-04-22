# Lab. nr 6 - Baza danych SQLite i kursory

## Opis działania.


1. Widok po uruchomieniu aplikacji.

![Wyglad podstawowy aplikacji](screens/main.png)

2. Przejście do widoku managera użytkowników.

![Wyglad podstawowy aplikacji](screens/v1.png)

3. Widok pustej bazy danych.

![Wyglad podstawowy aplikacji](screens/v1_db.png)

4. Uzupełnione inputy.

![Wyglad podstawowy aplikacji](screens/add_user1.png)

Wypełnienie inputów wymaganych do stworzenia nowego użytkownika.

5. Widok dodanego użytkownika

![Wyglad podstawowy aplikacji](screens/add_user1_view.png)

Po stworzeniu użytkownika, przenosi nas do głównego widoku, w raz z uzupełnionym nowo powstałym wpisem.

6. Dodanie kolejnej osoby.

![Wyglad podstawowy aplikacji](screens/add_user2.png)

7. Uzyskany widok.

![Wyglad podstawowy aplikacji](screens/add_user2_view.png)

Domyślnie cursor ustawiam na 1 element w bazie danych. Zatem aby zobaczyć kolejny wpis, należało kliknąć <i>"NEXT"</i>.
Przycisk <i>"PREVIOUS"</i> przenosi nas z powrotem do 1 użytownika (Adam'a Szreiber).

8. Dodanie fake-użytkownika w celach usuniącia.

![Wyglad podstawowy aplikacji](screens/add_user3_view.png)

9. Widok po usunięciu fake-użytkownika.

![Wyglad podstawowy aplikacji](screens/delete_user3_view.png)

10. Pobieranie cursor'a dla tabeli użytkowników.

![Wyglad podstawowy aplikacji](screens/db_query.png)

[Metoda moveToFirst()](https://developer.android.com/reference/android/database/Cursor#moveToFirst()) <i>
"Move the cursor to the first row.
This method will return false if the cursor is empty."</i>

11. Użycie cursor'a w praktyce.

![Wyglad podstawowy aplikacji](screens/cursor_methods.png)

Metody moveToNext i moveToPrevious są podpięte do eventu onClick przycisków <i>"NEXT" oraz "PREVIOUS"</i>.

[Metoda moveToNext()](https://developer.android.com/reference/android/database/Cursor#moveToNext()) <i>
"Move the cursor to the next row.
This method will return false if the cursor is already past the last entry in the result set."</i>
[Metoda moveToPrevious()](https://developer.android.com/reference/android/database/Cursor#moveToPrevious()) <i>
"Move the cursor to the previous row.
This method will return false if the cursor is already before the first entry in the result set."</i>


12. Wyjaśnienie metody query, użytej w podpunkcie - 10.
```
public Cursor query (
                String table,
                String[] columns,
                String selection,
                String[] selectionArgs,
                String groupBy,
                String having,
                String orderBy)
```

![Wyglad podstawowy aplikacji](screens/query_params.png)



[Metoda Query - DOCS](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase#query(java.lang.String,%20java.lang.String[],%20java.lang.String,%20java.lang.String[],%20java.lang.String,%20java.lang.String,%20java.lang.String))

Dopiero po dokładnym przeczytaniu dokumentacji zauważyłem, iż niepotrzebnie w query tworzyłem tablicę <i>arrayOf( COLUMN_[...] )</i>, ponieważ wstawienie null spowodowało by identyczny efekt - pobranie wszystkich kolumn z tabeli.

13. Metoda INSERT.

![Wyglad podstawowy aplikacji](screens/db_insert.png)


Metoda insert zwraca wartość -1 gdy wystąpił błąd.

[Metoda Insert - DOCS](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase#insert(java.lang.String,%20java.lang.String,%20android.content.ContentValues))

[Krótka instrukcja odnośnie Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts)


14. Metoda DELETE.

![Wyglad podstawowy aplikacji](screens/db_delete.png)

Metoda -> execSQL(sql:String)
<i>"<b>Execute a single SQL statement that is NOT a SELECT or any other SQL statement that returns data. </b>"</i>
<i>"PARAMETR sql: the SQL statement to be executed. Multiple statements separated by semicolons are not supported."</i>

[execSQL - DOCS](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase#execSQL(java.lang.String))

