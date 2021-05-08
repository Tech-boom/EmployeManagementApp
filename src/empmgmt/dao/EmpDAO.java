
package empmgmt.dao;
import empmgmt.dbutil.DBconnection;
import empmgmt.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
    public static boolean addEmployee(Employee e) throws SQLException{
        Connection  conn = DBconnection.getConnection();
        PreparedStatement pst =conn.prepareStatement("insert into employee values(?,?,?)");
        int id = e.getEmpNo();
        String name = e.getEmpName();
        double sal = e.getEmpSal();
        pst.setInt(1,id); 
        pst.setString(2,name);
        pst.setDouble(3,sal);
        int cond = pst.executeUpdate();
        if(cond==1)
            return true;
        return false;
        
    }
    public static Employee searchEmployee(int eno) throws SQLException{
        Connection  conn = DBconnection.getConnection();
        PreparedStatement pst =conn.prepareStatement("select * from employee where empid =?");
        pst.setInt(1, eno);
        ResultSet rs = pst.executeQuery();
        Employee e = null;
        if(rs.next()){
            e = new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
        }
        return e;
    }
    public static ArrayList<Employee> displayAll() throws SQLException{
        Connection  conn = DBconnection.getConnection();
        PreparedStatement pst =conn.prepareStatement("select * from employee order by empid");
        ResultSet rs = pst.executeQuery();
        ArrayList<Employee> empList = new ArrayList<>();
        while(rs.next()){
            Employee e = new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
            empList.add(e);
        }
        return empList;
    }
    public static boolean deleteRec(int eno) throws SQLException{
        Connection  conn = DBconnection.getConnection();
        PreparedStatement pst =conn.prepareStatement("delete from employee where empid =?");
        pst.setInt(1, eno);
        int cond;
        cond =pst.executeUpdate();
        if(cond==1)
            return true;
        return false;
    }
    public static boolean updateRec(Employee e) throws SQLException{
        Connection  conn = DBconnection.getConnection();
        PreparedStatement pst =conn.prepareStatement("update employee set empname =?,empsal=? where empid=?");
        pst.setString(1,e.getEmpName());
        pst.setDouble(2, e.getEmpSal());
        pst.setInt(3, e.getEmpNo());
        int cond;
        cond =pst.executeUpdate();
        if(cond==1)
            return true;
        return false;
    }
}
