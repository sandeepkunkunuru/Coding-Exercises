package me.tingri.libraries.cassandra;

import com.datastax.driver.core.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SimpleClient {
	private Cluster cluster;
	private Session session;

	public void connect(String node) {
		cluster = Cluster.builder().addContactPoint(node).withPort(9042).build();
		Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n",
				metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n",
					host.getDatacenter(), host.getAddress(), host.getRack());
		}

		session = cluster.connect();
	}

	public void close() {
		cluster.close();
	}

	public void createSchema() {
		Session session = getSession();

		session.execute("CREATE KEYSPACE simplex WITH replication "
				+ "= {'class':'SimpleStrategy', 'replication_factor':3};");

		session.execute("CREATE TABLE simplex.songs (" + "items uuid PRIMARY KEY,"
				+ "title text," + "album text," + "artist text,"
				+ "tags set<text>," + "data blob" + ");");

		session.execute("CREATE TABLE simplex.playlists (" + "items uuid,"
				+ "title text," + "album text, " + "artist text,"
				+ "song_id uuid," + "PRIMARY KEY (items, title, album, artist)"
				+ ");");
	}

	public void loadData() {
		Session session = getSession();

		session.execute("INSERT INTO simplex.songs (items, title, album, artist, tags) "
				+ "VALUES ("
				+ "756716f7-2e54-4715-9f00-91dcbea6cf50,"
				+ "'La Petite Tonkinoise',"
				+ "'Bye Bye Blackbird',"
				+ "'Joséphine Baker'," + "{'jazz', '2013'})" + ";");
		session.execute("INSERT INTO simplex.playlists (items, song_id, title, album, artist) "
				+ "VALUES ("
				+ "2cc9ccb7-6221-4ccb-8387-f22b6a1b354d,"
				+ "756716f7-2e54-4715-9f00-91dcbea6cf50,"
				+ "'La Petite Tonkinoise',"
				+ "'Bye Bye Blackbird',"
				+ "'Joséphine Baker'" + ");");
	}

	public void querySchema() {
		Session session = getSession();

		ResultSet results = session.execute("SELECT * FROM simplex.playlists "
				+ "WHERE items = 2cc9ccb7-6221-4ccb-8387-f22b6a1b354d;");

		System.out
				.println(String
						.format("%-30s\t%-20s\t%-20s\n%s", "title", "album",
								"artist",
								"-------------------------------+-----------------------+--------------------"));
		for (Row row : results) {
			System.out.println(String.format("%-30s\t%-20s\t%-20s",
					row.getString("title"), row.getString("album"),
					row.getString("artist")));
		}
		System.out.println();

	}

	public void dropSchema() {
		getSession().execute("DROP KEYSPACE simplex");
	}

	public void loadDataUsingBoundStatements() {
		Session session = getSession();

		PreparedStatement statement = session
				.prepare("INSERT INTO simplex.songs "
						+ "(items, title, album, artist, tags) "
						+ "VALUES (?, ?, ?, ?, ?);");

		BoundStatement boundStatement = new BoundStatement(statement);
		Set<String> tags = new HashSet<String>();

		tags.add("jazz");
		tags.add("2013");

		session.execute(boundStatement.bind(
				UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"),
				"La Petite Tonkinoise'", "Bye Bye Blackbird'",
				"Joséphine Baker", tags));

		statement = getSession().prepare(
				"INSERT INTO simplex.playlists "
						+ "(items, song_id, title, album, artist) "
						+ "VALUES (?, ?, ?, ?, ?);");
		boundStatement = new BoundStatement(statement);

		getSession()
				.execute(
						boundStatement.bind(
								UUID.fromString("2cc9ccb7-6221-4ccb-8387-f22b6a1b354d"),
								UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"),
								"La Petite Tonkinoise", "Bye Bye Blackbird",
								"Joséphine Baker"));
	}

	private Session getSession() {
		return session;
	}

	public static void main(String[] args) {
		SimpleClient client = new SimpleClient();

		// load data using normal statement
		client.connect("localhost");
		client.createSchema();
		client.loadData();
		client.querySchema();
		client.dropSchema();
		client.close();

		// load data using prepared statement
		client.connect("127.0.0.1");
		client.createSchema();
		client.loadDataUsingBoundStatements();
		client.querySchema();
		client.dropSchema();
		client.close();

	}
}