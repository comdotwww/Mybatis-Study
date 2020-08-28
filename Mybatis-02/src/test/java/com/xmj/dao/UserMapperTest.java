package com.xmj.dao;

import com.xmj.pojo.User;
import com.xmj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getUserListTest(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = null;

        try{
            sqlSession = MybatisUtils.getSqlSession();

            //执行SQL
            //方式一：getMapper     ————推荐使用
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            for (User user : userList) {
                System.out.println(user);
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //关闭SqlSession
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}
