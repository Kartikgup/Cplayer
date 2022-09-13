package com.itc.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.entity.Favorites;
//import com.itc.main.exception.FavoritesAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;
import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;
import com.itc.main.repository.FavoritesRepository;


@Service
public class FavoritesService {
	
	@Autowired
	private FavoritesRepository favoritesrepository;
//	
//	public Favorites save(Favorites favorites) {
//		return this.favoritesrepository.save(favorites);
//	}
//	
//	public List<Favorites> getAllFavorites(){
//		return this.favoritesrepository.findAll();
//	}
//	
	public Favorites getFavouritesById(int favId) {
		Optional<Favorites> op=this.favoritesrepository.findById(favId);
			if(op.isPresent()) {
				return op.get();
			}else 
				return null;
	}
	public boolean saveFavorites(Favorites favorites) throws  PlayerAlreadyExistsException {
		Optional<Favorites> checkFavorites = this.favoritesrepository.findById(favorites.getFavId());
		if(checkFavorites.isPresent())
			throw new PlayerAlreadyExistsException();
		this.favoritesrepository.save(favorites);
		return true;
	}


//	public List<Favorites> getFavFavoritess()  {
//		return this.favoritesrepository.findAll();
//	}
	public List<Favorites> getAllFavorites(){
		return this.favoritesrepository.findAll();
	}

	public Favorites getFavoritesByName(String name){
			Favorites favorites=this.favoritesrepository.getFavoritesByName(name);
			if(favorites!=null) {
				return favorites;
			}
			else
				return  null;
			}
//	public void deletePlayerById(int favId) {
//		// TODO Auto-generated method stub
//		
//	}
	
//
//	public boolean deleteFavoritesById(int favId) {
//		this.favoritesrepository.deleteById(favId);
//		return true;
	

//	public Player getPlayerByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
}

