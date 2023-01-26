import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class JavaList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating a Mongo client 
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
		System.out.println("Created Mongo Connection successfully"); 
		
		//MongoDatabase db = mongoClient.getDatabase("youtube");
		//System.out.println("Get database is successful");


	}

}
