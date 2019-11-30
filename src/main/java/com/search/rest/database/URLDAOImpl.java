package com.search.rest.database;

import com.search.rest.model.URL;
import com.search.rest.util.ConnectionObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class URLDAOImpl implements URLDAO {

    public ArrayList<URL> finalSearchResult(String search, String keyword) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<URL> finalEntries = new ArrayList<URL>();
        try
        {
            conn = ConnectionObj.getConnection();
            String query = "SELECT DISTINCT(urls.url), urls.desc, urls.heading FROM descriptions INNER JOIN urls ON urls.id = descriptions.id WHERE "+ getSearchQuery(search,keyword);
//            String query = "SELECT DISTINCT(urls.url) FROM descriptions INNER JOIN urls ON urls.id = descriptions.id WHERE shifts LIKE \""+ search+"%\"  ";

            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                URL result = new URL(rs.getString(1),rs.getString(2),rs.getString(3));
                finalEntries.add(result);
            }
        }
        catch(Exception e )
        {
            System.out.println("Problem in Searching Index Entry Data ");
            e.printStackTrace();
        }
        return finalEntries;

    }


    private String getSearchQuery(String searchWords, String keyword)
    {
        String resultQuery = "";
        String[] allWords = searchWords.split(" ");
        if(keyword.equalsIgnoreCase("OR"))
        {
            for(int i=0;i<allWords.length;i++)
            {
                if(i==0)
                {
                    resultQuery+=" shifts LIKE '%"+allWords[i]+"%'";
                }
                else
                {
                    resultQuery+=" OR shifts LIKE '%"+allWords[i]+"%'";
                }
            }
        }
        else if(keyword.equalsIgnoreCase("AND"))
        {
            for(int i=0;i<allWords.length;i++)
            {
                if(i==0)
                {
                    resultQuery+=" shifts LIKE '%"+allWords[i]+"%'";
                }
                else
                {
                    resultQuery+=" AND shifts LIKE '%"+allWords[i]+"%'";
                }
            }
        }
        else if(keyword.equalsIgnoreCase("NOT"))
        {
            for(int i=0;i<allWords.length;i++)
            {
                if(i==0)
                {
                    resultQuery+=" shifts NOT LIKE '%"+allWords[i]+"%'";
                }
                else
                {
                    resultQuery+=" AND shifts NOT LIKE '%"+allWords[i]+"%'";
                }
            }
        }


        return resultQuery;
    }

}
