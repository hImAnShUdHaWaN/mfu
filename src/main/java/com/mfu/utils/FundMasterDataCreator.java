package com.mfu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfu.domain.funds.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.util.StringUtils;
import springfox.documentation.spring.web.json.Json;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * Created by himanshu dhawan on 01-05-2018.
 */
public class FundMasterDataCreator {

    /*public static void main(String... args) throws Exception {
        HashMap<String, FundPricePoint> initDataMap = getInitdata();
        // HashMap<String, Fund> schemaDataMap = getSchemeData();

    }
*/
    private static HashMap<String,Fund> getSchemeData() throws Exception{
        Mongo mongo = new Mongo("<IP>", 0);
        DB db = mongo.getDB("<DB Name here>");

        DBCollection collection = db.getCollection("<Collection name here>");

        Fund entry = new Fund();
        HashMap<String, Fund> uniqueMap = new HashMap<>();
        URI fileUri = FundMasterDataCreator.class.getResource("/master/schemedata.csv").toURI();
        try (Stream<String> stream = Files.lines(Paths.get(fileUri))) {
            stream.filter(line -> line.trim().length() > 1).forEach( line -> {
                String [] data = line.split(",");
                entry.setAMC(AMC.contains(data[0]));
                entry.setSchemeCode(data[1]);
                entry.setSchemeName(data[2]);
                entry.setType(SchemeType.contains(data[3]));
                entry.setCategory(SchemeCategory.contains(data[4]));
                entry.setDetailedName(data[5]);
                if (data.length >= 7) {
                    if (data[6] != null) {
                        entry.setMinAmount(data[6]);
                    }
                    if (data.length >= 8) {
                        if (data[7] != null && data[7].trim().length() > 5) {
                            entry.setLaunchDate(new Date(data[7]));
                        }
                        if (data.length >= 9) {
                            if (data[8] != null && data[8].trim().length() > 5) {
                                entry.setClosureDate(new Date(data[8]));
                            }
                            if (data.length >= 10 && data[9] != null) {
                                if (data[9].length() > 12) {
                                    entry.setIsin(data[9].substring(0, 11));
                                    entry.setDivReinvestIsin(data[9].substring(12));
                                } else {
                                    entry.setIsin(data[9]);
                                }
                            }
                        }
                    }
                }
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    collection.insert((DBObject) JSON.parse(objectMapper.writeValueAsString(entry)));
                }catch(Exception e){
                    e.printStackTrace();
                }

                });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uniqueMap;
    }

   public static HashMap<String, FundPricePoint> getInitdata() throws Exception {
        FundPricePoint entry = new FundPricePoint();
        HashMap<String, FundPricePoint> uniqueMap = new HashMap<>();
        URI fileUri = FundMasterDataCreator.class.getResource("/master/initdata.txt").toURI();
        try (Stream<String> stream = Files.lines(Paths.get(fileUri))) {
            stream.filter(line -> line.trim().length() > 1).forEach(line -> {
                if (line.split(";").length >= 8) {
                    String[] values = line.split(";");
                    entry.setSchemeCode(values[0]);
                    entry.setNav(getNumberValue(values[4]));
                    entry.setRepPrice(getNumberValue(values[5]));
                    entry.setSalePrice(getNumberValue(values[6]));
                    entry.setDate(new Date(values[7]));
                    System.out.println(entry);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uniqueMap;
    }

    private static Double getNumberValue(String str)
    {
        try
        {
            Double d = Double.parseDouble(str);
            return d;
        }
        catch(NumberFormatException nfe)
        {
            return null;
        }
    }
}
