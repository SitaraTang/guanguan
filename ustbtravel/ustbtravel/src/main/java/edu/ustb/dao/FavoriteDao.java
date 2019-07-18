package edu.ustb.dao;

import edu.ustb.domain.User;

public interface FavoriteDao {
	public int saveFavorite(User user, String rid);
	public boolean isFavorite(User user, String rid);
	public int sqlFavorite(String rid);
}
