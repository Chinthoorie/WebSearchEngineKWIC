package com.search.rest.database;

import com.search.rest.model.Description;
import com.search.rest.util.ConnectionObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DescriptionDAOImpl implements DescriptionDAO {

    public ArrayList<Description> getWords(String search) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Description> wordResults = new ArrayList<Description>();
        try
        {
            conn = ConnectionObj.getConnection();
//            String query = "select distinct(x.words) from ( select substr(trim(shifts),1,instr(trim(shifts)||' ',' ')-1) as [words] from descriptions WHERE\""+getSearchQuery(search,"OR")+"%\") as x";
            String query = "select distinct(x.words) from ( select substr(trim(shifts),1,instr(trim(shifts)||' ',' ')-1) as [words] from descriptions WHERE shifts like \""+search+"%\") as x";


            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Description result = new Description(rs.getString(1));
                wordResults.add(result);
            }
        }
        catch(Exception e )
        {
            System.out.println("Problem in Searching Index Entry Data ");
            e.printStackTrace();
        }
        return wordResults;

    }



}
