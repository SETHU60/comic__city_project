package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Wishlist;

public interface WishlistRepository extends JpaRepository <Wishlist,Long>{
}
