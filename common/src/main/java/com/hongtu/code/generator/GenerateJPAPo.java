package com.hongtu.code.generator;

import com.hongtu.utils.file.FileUtils;
import com.hongtu.utils.string.StringUtils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class GenerateJPAPo {

    public static void main(String[] args) {
        String packageName = "";
        String mysqlConnStr = "";
        String username = "";
        String password = "";
        String outPutDir = "";

        packageName = "citic.c.usrmgt.po";
        mysqlConnStr = "jdbc:mysql://127.0.0.1:3306/clouduser?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";
        username = "hongtu";
        password = "password";
        outPutDir = "/home/hongtu/workspace/zanghongtu/usrmgt/src/main/java/citic/c/usrmgt/po";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<String> tables = new LinkedList<>();

        Connection conn = null;
        ResultSet rsTables = null;
        try {
            conn = DriverManager.getConnection(mysqlConnStr, username, password);
            DatabaseMetaData dbMetaData = conn.getMetaData();
            rsTables = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            while (rsTables.next()) {
                tables.add(rsTables.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rsTables != null) {
                try {
                    rsTables.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(tables);


        for (String tableName : tables) {
            StringBuilder header = new StringBuilder("package " + packageName + ";\n\n");
            header.append("import javax.persistence.Column;\n");
            header.append("import javax.persistence.Entity;\n");
            header.append("import javax.persistence.Id;\n\n");

            StringBuilder parameters = new StringBuilder("@Entity(name = \"" + tableName + "\")\n" +
                    "public class " + StringUtils.underScode2Hungary(tableName) + "Po {\n");
            StringBuilder gettersAndSetters = new StringBuilder();

            String sql = "SELECT * FROM " + tableName + " where 1=2";
            PreparedStatement ps = null;
            ResultSet rs = null;
            boolean hasDate = false;
            try {
                assert conn != null;
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String colName = metaData.getColumnName(i);
                    String colType = metaData.getColumnTypeName(i);
                    if (colType.equals("DATETIME")) {
                        hasDate = true;
                    }
                    if (colName.equalsIgnoreCase("id")) {
                        parameters.append("    @Id\n");
                    } else {
                        parameters.append("    @Column(name = \"").append(colName).append("\")\n");
                    }
                    String camelName = StringUtils.underScode2Camel(colName);
                    String hungaryName = StringUtils.underScode2Hungary(colName);
                    String javaType = JPAJavaClassMapping.map.get(colType);

                    parameters.append("    private ").append(javaType).append(" ").
                            append(StringUtils.underScode2Camel(colName)).append(";\n\n");
                    gettersAndSetters.append("    public ").append(javaType).append(" get").append(hungaryName).
                            append("(").append(") {\n").
                            append("        return ").append("this.").append(camelName).append(";\n").
                            append("    }\n\n");
                    //                            append("        return ").append("this.").append(camelName).append(";\n").
                    gettersAndSetters.append("    public void ").append("set").append(hungaryName).
                            append("(").append(javaType).append(" ").append(camelName).append(") {\n").append("        this.").
                            append(camelName).append(" = ").append(camelName).append(";\n").
                            append("    }\n\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (hasDate) {
                header.append("import java.util.Date;\n");
            }
            gettersAndSetters.append("}\n");
            System.out.println(header.toString());
            System.out.println(parameters.toString());
            System.out.println(gettersAndSetters.toString());

            FileUtils.writerFile(outPutDir + "/" + StringUtils.underScode2Hungary(tableName) + "Po.java",
                   header.append(parameters.toString()).append(gettersAndSetters.toString()).toString(),
                    false);
        }
    }
}
