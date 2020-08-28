package com.xmj.dao;

import com.xmj.pojo.User;
import com.xmj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            //方式二：selectOne     ————不推荐使用
//            List<User> userList2 = sqlSession.selectList("com.xmj.dao.UserMapper.getUserList");
//            System.out.println();
//            for (User user : userList2) {
//                System.out.println(user);
//            }

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            //关闭SqlSession
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.getUserById(1);

        System.out.println(userById);

        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.addUser(new User(1, "刘明", "123333"));

        System.out.println("插入结果为：" + i);

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }


    //增删改需要提交事务
    @Test
    public void addUser2Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",5);
        map.put("userName","张晓蓝");
        map.put("userPassword","123qaq123");


        int i = mapper.addUser2(map);

        System.out.println("插入结果为：" + i);

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void getUserByIdTest2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",5);
        map.put("userName","张晓蓝");
        map.put("userPassword","123qaq123");
        User userById = mapper.getUserById2(map);

        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4,"马小跳","123123"));

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(1);

        sqlSession.commit();
        sqlSession.close();


    }
}
