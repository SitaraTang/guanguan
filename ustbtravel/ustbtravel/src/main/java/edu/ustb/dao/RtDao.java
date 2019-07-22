package edu.ustb.dao;



import java.util.List;

import edu.ustb.domain.Route;



public interface RtDao {
    public List<Route> find(int cid);
}
