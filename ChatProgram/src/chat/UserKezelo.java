package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.midi.Patch;

import com.google.gson.Gson;

public class UserKezelo {

	Gson gson = new Gson();

	public void mentes(User beallitasok) {
		String Json = gson.toJson(beallitasok);

		try {
			PrintWriter writer = new PrintWriter("tarolo.txt", "UTF-8");
			writer.println(Json);
			writer.close();
		} catch (IOException e) {

		}
	}

	public User beolvasas() {
		
		Path path = Paths.get("tarolo.txt");
		System.out.println(path.toString());
		String lines = "";
		try {
			String line = null;
			BufferedReader reader = Files.newBufferedReader(path);
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				lines += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gson.fromJson(lines, User.class);

	}

	
}
