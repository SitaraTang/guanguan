package edu.ustb.service.impl;

import edu.ustb.dao.UserDao;
import edu.ustb.dao.impl.UserDaoImpl;
import edu.ustb.domain.User;
import edu.ustb.service.UserService;
import edu.ustb.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByUserName(user.getUsername());
        //判断u是否为null
        if(u != null){
            //用户名存在，注册失败
            return false;
        }
        //把邮件激活的功能注释掉了
        //2.保存用户信息
       //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("Y");
        userDao.save(user);
//
//        //3.激活邮件发送，邮件正文？
//        String content="<a href='http://localhost:9527/ustbtravel1/user/active?code="+user.getCode()+"'>点击激活【去哪儿网】</a>";
       // MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		//findByUsernameAndPassword自己写！
		//写好了
	}
}

