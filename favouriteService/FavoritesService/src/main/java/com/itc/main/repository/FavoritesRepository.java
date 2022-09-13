package com.itc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.itc.main.entity.Favorites;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Integer>{
	
	@Query("SELECT favId FROM Favorites u WHERE u.userId= :userId")
	public List<Integer> getFavoritesByUserId(@Param("userId") Integer userId);

	public Favorites getFavoritesByName(String name);

//	public boolean deleteFavoritesById(int favId);

//	public boolean deleteFavoritesById(int favId);

//	public Favorites getFavoritesByName(String name);
}
