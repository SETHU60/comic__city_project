package za.ac.cput.factory;



import za.ac.cput.domain.Author;
import za.ac.cput.domain.ComicBook;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;

public class ComicBookFactory {
    public static ComicBook buildBuilder(String sku, String name, double wieght, LocalDate releaseDate, List<Author> authors, double price) {
        if (Helper.isStringNullorEmpty(sku) || Helper.isStringNullorEmpty(name) || wieght <= 0.0 || Helper.isValidDate(releaseDate) || Helper.arrayListNullorEmpty(authors) || price <= 0.0) {

            return null;
        }

        return new ComicBook.ComicBookBuilder().setSKU(sku)
                .setName(name)
                .setWieght(wieght)
                .setReleaseDate(releaseDate)
                .setAuthor(authors)
                .setPrice(price)
                .build();
    }
}