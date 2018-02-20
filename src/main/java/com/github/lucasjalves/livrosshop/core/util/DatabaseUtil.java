package com.github.lucasjalves.livrosshop.core.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtil {
	public static Connection addConnection(String url, String user, String pwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Map scanTables(Connection connection)
	{
		PreparedStatement pst = null;
		List<String> nomesColunas = new ArrayList<>();
		Map<String, List<String>> infoTables = new HashMap<>();
		try
		{
			pst = connection.prepareStatement("show tables");
			ResultSet resultSet = pst.executeQuery();

			DatabaseMetaData metaData = connection.getMetaData();
			while(resultSet.next())
			{
				String nomeTabela = resultSet.getString(1);
				ResultSet resultSetTables = metaData.getColumns(null,null, nomeTabela, null);
				while(resultSetTables.next())
				{
					System.out.println(resultSetTables.getString(4));
					nomesColunas.add(resultSetTables.getString(4));
				}
				infoTables.put(nomeTabela, nomesColunas);
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		return infoTables;
	}
}
