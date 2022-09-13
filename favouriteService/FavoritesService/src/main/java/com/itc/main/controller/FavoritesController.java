package com.itc.main.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.entity.Favorites;
import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;
import com.itc.main.repository.FavoritesRepository;
import com.itc.main.service.FavoritesService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
public class FavoritesController {

	@Autowired
	private FavoritesService favoritesservice;
	
	@Autowired
	private FavoritesRepository favoritesrepository;
	

//	}
	@PostMapping("/save")
	@ApiOperation(value = "SAVE-THE-PLAYER-DETAILS")
	public ResponseEntity<?> savePlayer(@RequestBody Favorites favorites)
	{
		ResponseEntity<?> responseEntity;
		try
		{
			this.favoritesservice.saveFavorites(favorites);
			responseEntity = new ResponseEntity<Favorites>(favorites,HttpStatus.CREATED);
		}
		catch(PlayerAlreadyExistsException e)
		{
			responseEntity = new ResponseEntity<String>("Allready",HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	@GetMapping("/player/{name}")
	@ApiOperation(value="GET-PLAYERBYNAME")
	public ResponseEntity getFavoritesByName(@PathVariable String name) {
		Favorites favorite=this.favoritesservice.getFavoritesByName(name);
		if(favorite!=null) {
			return new ResponseEntity<Favorites>(favorite,HttpStatus.OK);
	}else
		return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
}

	@GetMapping("favorites")
	public ResponseEntity<List<Favorites>> getAllFavourites(){
		List<Favorites> list=this.favoritesservice.getAllFavorites();
		return new ResponseEntity<List<Favorites>>(list, HttpStatus.OK);
	}
	

//	
	@GetMapping("favorite/{userId}")
	public ResponseEntity<List<Favorites>> getFavoritesByUserId(@PathVariable("userId") int userId){
		List<Integer> favIds = favoritesrepository.getFavoritesByUserId(userId);
		List<Favorites> favorites = favIds.stream().map((favorite) -> favoritesrepository.findById(favorite).get()).collect(Collectors.toList());
		return new ResponseEntity<List<Favorites>>(favorites, HttpStatus.OK);
	}
}
