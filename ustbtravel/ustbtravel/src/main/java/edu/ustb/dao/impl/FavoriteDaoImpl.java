package edu.ustb.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.domain.User;
import edu.ustb.util.JDBCUtils;

public class FavoriteDaoImpl implements FavoriteDao{
	
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	
	
	@Override
	public int saveFavorite(User user, String rid) {
		 String sql = "insert into tab_favorite(rid,date,uid) values(?,now(),?)";
		 return template.update(sql,Integer.parseInt(rid),user.getUid());
	       
	}
}
