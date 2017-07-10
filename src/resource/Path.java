package resource;

public class Path {

	public String getPath() {
		return getClass().getResource("").getPath();
	}
}
