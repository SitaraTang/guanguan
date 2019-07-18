package edu.ustb.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.domain.User;
import edu.ustb.util.JDBCUtils;

public class FavoriteDaoImpl implements FavoriteDao{
	
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	
	public int saveFavorite(User user, String rid) {
		 String sql = "insert into tab_favorite(rid,date,uid) values(?,now(),?)";
		 return template.update(sql,Integer.parseInt(rid),user.getUid());    
	}
	
	public boolean isFavorite(User user, String rid) {
		boolean flag = false;
		String sql = "select count(*) from tab_favorite where rid = ? and uid = ?";
		int num = 0;
		num = template.queryForObject(sql,Integer.class,Integer.parseInt(rid),user.getUid());
		if(num>0)
			flag = true;
		return flag;
	}
	
	public int sqlFavorite(String rid) {
		 String sql = "update tab_route set count = count + 1 WHERE rid = ?;";
		 return template.update(sql,Integer.parseInt(rid));
	}
}
