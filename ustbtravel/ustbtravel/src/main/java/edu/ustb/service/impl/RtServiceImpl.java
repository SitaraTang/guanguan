package edu.ustb.service.impl;



import java.util.List;

import edu.ustb.dao.RtDao;
import edu.ustb.dao.impl.RtDaoImpl;
import edu.ustb.domain.Route;
import edu.ustb.service.RtService;



public class RtServiceImpl implements RtService {
    private RtDao dao=new RtDaoImpl();
    
    public List<Route> find(int cid) {
        return dao.find( cid);
    }
}
