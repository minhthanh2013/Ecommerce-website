package com.doan2.spring.dao.userinfo;

import com.doan2.spring.entity.UserInfo;
import com.doan2.spring.mapper.UserMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
@Service
@Transactional
public class UserInfoDAOImpl extends JdbcDaoSupport implements UserInfoDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    public UserInfoDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    @Override
    public UserInfo findUserInfo(String userName) {
        String sql = "Select u.username,u.password "//
                + " from users u where u.username = ? ";

        Object[] params = new Object[] { userName };
        UserMapper mapper = new UserMapper();
        try {
            UserInfo userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "Select r.User_Role "//
                + " from User_Roles r where r.Username = ? ";

        Object[] params = new Object[] { userName };

        List<String> roles = this.getJdbcTemplate().queryForList(sql,params, String.class);

        return roles;
    }
    public int getLatestUserId(){
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createSQLQuery("select max(id) from users");
       return (int) query.setMaxResults(1).getResultList().get(0);
    }
    @Override
    public void addUserInfo(UserInfo userInfo){
        Session currentSession = sessionFactory.getCurrentSession();
        int currentId = getLatestUserId()+1;
        String processPass = "{noop}"+userInfo.getPassword();
        String sql = "insert into users values ('"+userInfo.getUserName()+"','"+processPass +"',1,"+currentId+")";
        Query query = currentSession.createSQLQuery(sql);
        addRole(userInfo);
        query.executeUpdate();
    }
    public void addRole(UserInfo userInfo){
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "insert into user_roles values ("  +    "1,'"+userInfo.getUserName()+"','USER'"+")";
        Query query = currentSession.createSQLQuery(sql);
        query.executeUpdate();
    }
}
