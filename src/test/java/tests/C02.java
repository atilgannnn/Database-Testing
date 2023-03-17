package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C02 {

    //Yazili not ortalamasının 90dan kucuk oldugunu test edın


    @Test
    public void test01() throws SQLException {

        String hostname ="localhost";
        String dbisim ="Databasetesting";
        String username ="postgres";
        String password ="Flrnc555*";

        //1. Adım : Connection
        DBUtils.connectionOlustur(hostname,dbisim,username,password);

        //2. Adım : Statement
        Statement st = DBUtils.statementOlustur();

        //3. Adım : Query Oluştur
        String query = "SELECT AVG(yazili_notu) FROM ogrenciler;";
        ResultSet rs = st.executeQuery(query);

        rs.next();

        double ort = rs.getDouble(1);
        System.out.println(ort);

        Assert.assertTrue(ort<90);

        DBUtils.connectionStatementKapat();
    }
}
