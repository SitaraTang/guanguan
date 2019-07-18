package edu.ustb.dao;

import edu.ustb.domain.User;

public interface FavoriteDao {
	public int saveFavorite(User user, String rid);

}
