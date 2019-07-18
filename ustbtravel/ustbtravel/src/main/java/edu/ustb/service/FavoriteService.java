package edu.ustb.service;

import edu.ustb.domain.User;

public interface FavoriteService {

	public void saveFavorite(User user, String rid);
	public boolean isFavorite(User user, String rid);
	public int sqlFavorite(String rid);
}
