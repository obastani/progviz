package org.viz.core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Viz<X> {
	private int vizCount = 0;
	private final String filename;
	
	public Viz(String filename) {
		this.filename = filename;
	}
	
	public abstract JSONObject vizJSON(X x);
	public abstract DotObject vizDot(X x);

	public void viz(X x) {
		try {
			File file = File.createTempFile(this.filename + (this.vizCount++), ".dot");
			file.deleteOnExit();
			
			PrintWriter pw = new PrintWriter(file);
			System.out.println(this.vizDot(x).toDotString());
			pw.close();
			
			//Process process = Runtime.getRuntime().exec("");			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
