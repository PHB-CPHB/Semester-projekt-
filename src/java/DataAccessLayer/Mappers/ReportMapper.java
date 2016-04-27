/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.DBConnector;
import DataAccessLayer.Interfaces.ReportMapperInterface;
import ServiceLayer.Entity.Report;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ejer
 */
public class ReportMapper implements ReportMapperInterface {

    @Override
    public void createReport(Report report) {
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) DBConnector.getConnection().prepareStatement("INSERT INTO building_report (report_id, report_outer_roof, report_outer_wall, report_building_usage, report_building_manager, report_building_condetion) VALUES (?, ?, ?, ?, ?, ?);");
            pstmt.setInt(1, report.getReportId());
            pstmt.setString(2, report.getOuterRoof());
            pstmt.setString(3, report.getOuterWall());
            pstmt.setString(4, report.getUsageOfBuilding());
            pstmt.setString(5, report.getTheBuildingManager());
            pstmt.setInt(6, report.getBuildingCondition());
            pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReportMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void deleteReports(Report report) {
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) DBConnector.getConnection().prepareStatement("DELETE FROM building_report WHERE report_id = ?");
            pstmt.setInt(1, report.getReportId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void setBuildingCondition(Report report) {
        PreparedStatement pstmt;
        try {
            System.out.println("4");
            pstmt = (PreparedStatement) DBConnector.getConnection().prepareStatement("INSERT INTO building_report (report_id, report_building_condetion) VALUES (?, ?);");
            pstmt.setInt(1, report.getBuilding().getBuilding_id());
            pstmt.setInt(2, report.getBuildingCondition());
            System.out.println("5");
            pstmt.executeUpdate();
            System.out.println("6");
        } catch (SQLException ex) {
            System.out.println("7");
            System.out.println(ex);
        }
    }
}
