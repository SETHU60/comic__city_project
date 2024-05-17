package za.ac.cput.factory;

import za.ac.cput.domain.ComicBook;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;

public class WishlistFactory {
    public static Wishlist buildWishlist(String wishListName, List<ComicBook> comicBooks, LocalDate createdDate, LocalDate updatedDate) {
        if (Helper.isStringNullorEmpty(wishListName) || Helper.isComicBooksListNullOrEmpty(comicBooks) || Helper.isNotAfter(createdDate, LocalDate.now()) || Helper.isNotInPast(updatedDate)) {
            return null;
        }

        return new Wishlist.Builder()
                .setWishlistName(wishListName)
                .setComicBooks(comicBooks)
                .setCreatedDate(createdDate)
                .setUpdatedDate(updatedDate)
                .build();
    }

}
