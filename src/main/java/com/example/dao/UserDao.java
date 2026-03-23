package com.example.dao;

import com.example.pojo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // 数据库连接信息（对应你 Docker 的配置）
    private static final String URL = "jdbc:mysql://localhost:3306/smbms?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM smbms_user"; // 确保你的表名是 users

        // 使用 try-with-resources 自动关闭资源，类似 Go 的 defer
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("userName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // 主函数直接运行测试
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        List<User> list = dao.findAll();
        
        System.out.println("--- 数据库查询结果 ---");
        list.forEach(System.out::println);
    }
}