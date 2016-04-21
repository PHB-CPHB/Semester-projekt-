/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Mappers;

import DataAccessLayer.DBConnector;
import ServiceLayer.Entity.Report;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author philliphbrink
 */
public class ReportMapper {

    public void deleteReports(Report report) {
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("DELETE FROM building_report WHERE report_id = ?");
            pstmt.setInt(1, report.getReportId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
