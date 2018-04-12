package com.project.test;

import java.sql.*;  
import java.util.*;  
import javax.swing.*;  
import javax.swing.table.TableColumn;  
import java.awt.Font;  
import javax.swing.event.ListSelectionListener;  
  
public class approve4 {  
    public static void main(String[] args) {  
        Vector columnNames = new Vector();  
        Vector data = new Vector();  
        JPanel panel = new JPanel();   //  
        try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();  
            Connection con = DriverManager.getConnection(  
                    "jdbc:sqlserver://localhost:1433;databaseName=master;integratedSecurity=true");  
            String sql = "SELECT * FROM dbo.manualchecks";  
            Statement statement = con.createStatement();  
            ResultSet resultSet = statement.executeQuery(sql);  
            ResultSetMetaData metaData = resultSet.getMetaData();  
            int columns = metaData.getColumnCount();  
            for (int i = 1; i <= columns; i++) {  
                columnNames.addElement(metaData.getColumnName(i));  
            }  
            while (resultSet.next()) {  
                Vector row = new Vector(columns);  
                for (int i = 1; i <= columns; i++) {  
                    row.addElement(resultSet.getObject(i));  
                }  
                data.addElement(row);  
            }  
            resultSet.close();  
            statement.close();  
        } catch (Exception e) {  
            System.out.println(e);  
        }  
        JTable table = new JTable(data, columnNames);  
        table.setColumnSelectionAllowed(true);  
        table.setCellSelectionEnabled(true);  
                 
        TableColumn column;  
        for (int i = 0; i < table.getColumnCount(); i++) {  
            column = table.getColumnModel().getColumn(i);  
            column.setMaxWidth(250);  
        }  
        panel.setLayout(null);  
        JScrollPane scrollPane = new JScrollPane(table);          
        scrollPane.setBounds(10, 53, 927, 480);panel.add(scrollPane);                 
        JFrame frame = new JFrame();  
        frame.getContentPane().add(panel);         //adding panel to the frame  
          
        JLabel lblNewLabel = new JLabel("Approvals");  
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);  
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));  
        lblNewLabel.setBounds(10, 11, 927, 31);  
        panel.add(lblNewLabel);  
        frame.setSize(963, 600); //setting frame size  
        frame.setVisible(true);  //setting visibility true  
    }  
}  