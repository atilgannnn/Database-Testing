package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C01 {

    //ogrenciler tablosunda Merve Gul isimli ogrencinin oldugunu test edın


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
        String query = "SELECT isim FROM ogrenciler;";

        //4. Adım : Query Çalıştır
        ResultSet rs = st.executeQuery(query);
        List<String> isimler = new ArrayList<>();

        while (rs.next()){

            isimler.add(rs.getString(1));
        }

        Assert.assertTrue(isimler.contains("Merve Gul"));

    }
}
