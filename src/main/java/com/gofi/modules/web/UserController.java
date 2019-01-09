package com.gofi.modules.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gofi.common.web.BaseController;
import com.gofi.modules.dao.UserDao;
import com.gofi.modules.entity.UserEntity;

@RestController
public class UserController extends BaseController{
	
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping("/index")
	public ModelAndView getUsers(ModelAndView mv) {
		mv.setViewName("/login");
		mv.addObject("title","欢迎使用Thymeleaf!");
		//List<UserEntity> users=userDao.getAll();
		return mv;
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userDao.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
    	userDao.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userDao.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userDao.delete(id);
    }
    
    
}