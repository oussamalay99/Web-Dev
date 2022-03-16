package Absents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Mongodb {
	private MongoClient client;
	MongoCollection<Document>  classroom;
	MongoDatabase database ;
	List<String> absentsList = new ArrayList<String>();
	public Mongodb()  {/*
		ConnectionString connString = new ConnectionString(
			    "mongodb+srv://user:user@cluster0.7itmn.mongodb.net/test?w=majority"
			);
			MongoClientSettings settings = MongoClientSettings.builder()
			    .applyConnectionString(connString)
			    .retryWrites(true)
			    .build();*/
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://user:user@cluster0.7itmn.mongodb.net/test?w=majority"));
			//MongoClient mongoClient = MongoClients.create(settings);
			database = mongoClient.getDatabase("Absents");
			classroom=database.getCollection("INE2-DATA");
			
	
		
	}
	public void insertAbs(String classroom,String date,String time,String Matiere, String[] absents) {
		this.classroom=database.getCollection(classroom);
		Document abs=new Document();
		List<String> absentList = Arrays.asList(absents);
		Document absence = new Document("Matiere", Matiere)
									.append("Prof", Login.teacher.getEmail())
		                            .append("Date", date)
		                            .append("Time", time)
		                            .append("Absents", absentList);
		this.classroom.insertOne(absence);
		
		
	}
	public String getabs(String email) {
		SqlDB sql=new SqlDB();
		FindIterable<Document> iterDoc = classroom.find();
	      Iterator it = iterDoc.iterator();
	      String result="";
	      String[] info;
	      while (it.hasNext()) {
	    	  String abs=it.next().toString();
	         if (abs.contains(email)) {
	        	 result=result+"<tr>";
	        	 info=abs.substring(abs.indexOf(',')+1, abs.indexOf(", Absents")).split(",");
	        	 result=result+"<td class=\"column1\">"+"</td>";
	        	 result=result+"<td class=\"column3\">"+info[2].substring(info[2].indexOf('=')+1)+"</td>";
	        	 result=result+"<td class=\"column3\">"+info[3].substring(info[3].indexOf('=')+1)+"</td>";
	        	 result=result+"<td class=\"column3\">"+info[0].substring(info[0].indexOf('=')+1)+"</td>";
	        	 result=result+"<td class=\"column3\">"+sql.getTeacherName(info[1].substring(info[1].indexOf('=')+1))+"</td>";
	        	 result=result+"<td class=\"column3\">"+info[1].substring(info[1].indexOf('=')+1)+"</td>";
	        	 result=result+"<td class=\"column1\">"+"</td>";
	        	 System.out.println(info);
	        	 result=result+"</tr>";
	         }
	      }
		return result;
	}

}
