package edu.ustb.service.impl;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.impl.FavoriteDaoImpl;
import edu.ustb.domain.User;
import edu.ustb.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService{

	private FavoriteDao favoriteDao = new FavoriteDaoImpl();
	@Override
	public void saveFavorite(User user, String rid) {
		favoriteDao.saveFavorite(user, rid);
	}
	public boolean isFavorite(User user, String rid) {
		return favoriteDao.isFavorite(user, rid);
	}
	public int sqlFavorite(String rid) {
		return favoriteDao.sqlFavorite(rid);
	}
}
