package com.revature.foundation.daos;

import com.revature.foundation.models.ErsUser;
import com.revature.foundation.util.ConnectionFactory;
import com.revature.foundation.util.exceptions.UserNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ErsUserDao implements Dao<ErsUser> {

        private ErsUser ersUser;

        public ErsUser findUserByUserName(String username){

            try  (Connection conn = ConnectionFactory.getInstance().getConnection()){

                PreparedStatement ps =
                        conn.prepareStatement("select * from ers_users where user_name = ?");
                ps.setString(1, username);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    ersUser = new ErsUser();
                    ersUser.setId(rs.getString("user_id"));
                    ersUser.setGivenName(rs.getString("given_name"));
                    ersUser.setSurName(rs.getString("surname"));
                    ersUser.setEmail(rs.getString("email"));
                    ersUser.setUsername(rs.getString("user_name"));
                    ersUser.setIsActive(rs.getBoolean("is_active"));
                    ersUser.setRoleId(rs.getString("role_id"));
                }

                else {
                    throw new UserNotFoundException();
                }
            }

            catch (SQLException ex){
            }

            return ersUser;
        }
}

