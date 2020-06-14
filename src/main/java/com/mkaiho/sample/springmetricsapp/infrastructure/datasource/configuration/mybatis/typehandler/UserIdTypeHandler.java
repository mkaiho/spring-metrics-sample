package com.mkaiho.sample.springmetricsapp.infrastructure.datasource.configuration.mybatis.typehandler;

import com.mkaiho.sample.springmetricsapp.domain.model.user.UserId;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserIdTypeHandler extends BaseTypeHandler<UserId> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserId parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.value().toString());
    }

    @Override
    public UserId getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new UserId(rs.getString(columnName));
    }

    @Override
    public UserId getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new UserId(rs.getString(columnIndex));
    }

    @Override
    public UserId getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new UserId(cs.getString(columnIndex));
    }
}
