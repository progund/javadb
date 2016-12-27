package db.app;
/**
 * A class that represents a municipality.
 */
public class Municipality{
    private int id;
    private String name;
    private boolean supportsHTTPS;
    private String url;
    private String server;
    /**
     * @param name The name of the municipality
     * @param url The URL of the municipality web page
     * @param server The web server this municipality is running
     * @param https A boolean value representing whether this municipality supports HTTPS in its web server
     */
    public Municipality(String name, String url,
			String server, boolean https){
	this.name=name;
	this.url=url;
	this.server=server;
	this.supportsHTTPS=https;
    }

    /**
     * Returns the id of this Municipality. The ID could mean an internal id for an application creating a record of municipalities for instance.
     * @return the id of this Municipality as an int (or 0 if it's not been set)
     */
    public int id(){return this.id;}

    /**
     * Returns the name of this Municipality
     * @return The name of the municipality as a String
     *
     */
    public String name(){return this.name;}

    /**
     * Returns the URL of this Municipality
     * @return The URL of the municipality as a String
     *
     */
    public String url(){return this.url; }

    /**
     * Returns the web server name of this Municipality
     * @return The web server name of the municipality as a String
     *
     */
    public String server(){return this.server;}

    /**
     * Returns a boolean representing whether this municipality supports HTTPS for its web server
     * @return true if this Municipality supports HTTPS, otherwise false
     *
     */
    public boolean supportsHTTPS(){return this.supportsHTTPS;}
    
    /**
     * Returns a String representation of this municipality
     * @return A String representing the state of this municipality
     */
    @Override
    public String toString(){
	return name + " | " + url + " | " +
	    server + " | " + 
	    (supportsHTTPS?"HTTPS support":"only HTTP");
    }

    /**
     * A mutator method to change the HTTPS capability of this Municipality
     * @param https a boolean value representing the new indication of whether this Municipality supports HTTPS
     */
    public void setHTTPS(boolean https){
	this.supportsHTTPS = https;
    }
    /**
     * A mutator to set or change the ID of this Municipality. The id defaults to 0 while not set.
     * @param id The new id as an int
     */
    public void setID(int id){
	this.id=id;
    }
}
