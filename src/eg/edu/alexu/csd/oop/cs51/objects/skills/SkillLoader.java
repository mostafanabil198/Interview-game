package eg.edu.alexu.csd.oop.cs51.objects.skills;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.cs51.logger.Logger;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;

public class SkillLoader {
	private String path;
	private List<Class<? extends Movable>> supported;

	public SkillLoader(String path) {
		this.path = path;
	}

	public void load() {
		supported = new ArrayList<Class<? extends Movable>>();
		List<File> jars = getJars();
		for (File jar : jars) {
			loadSkillFromJar(jar.getPath());
		}
	}

	public List<Class<? extends Movable>> getSkills() {
		return supported;
	}

	private void loadSkillFromJar(String JarPath) {
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(JarPath);
			URL[] urls = { new URL("jar:file:" + JarPath + "!/") };

			URLClassLoader loader = new URLClassLoader(urls);

			Enumeration<JarEntry> e = jarFile.entries();
			while (e.hasMoreElements()) {
				JarEntry je = (JarEntry) e.nextElement();
				if (je.isDirectory() || !je.getName().endsWith(".class")) {
					continue;
				}
				String className = je.getName().substring(0, je.getName().length() - 6);
				className = className.replace('/', '.');
				Class c = loader.loadClass(className);
				if (Skill.class.isAssignableFrom(c)) {
					supported.add(c);

					String name = c.getName();
					String[] namearr = name.split("\\.");
					File targetFile = new File("res/" + namearr[namearr.length - 1] + ".png");
					File dir = new File("res");
					if (!dir.exists()) {
						new File("res").mkdirs();
					}
					if (!targetFile.exists()) {
						targetFile.createNewFile();
					}
					String packageName = c.getPackage().getName().replace(".", "/");
					String resName = packageName + "/res/" + namearr[namearr.length - 1] + ".png";
					InputStream is = loader.getResourceAsStream(resName);
					BufferedImage im = ImageIO.read(is);
					ImageIO.write(im, "png", targetFile);
				}
			}
			loader.close();
		} catch (Exception e) {
			try {
				Logger.getInstance().warnning("No classes loaded");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException ex) {
				// TODO Auto-generated catch block
			}
		}
	}

	private List<File> getJars() {
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}
		File[] files = folder.listFiles();
		List<File> jars = new ArrayList<File>();
		for (File f : files) {
			if (f.isFile()) {
				if (f.getName().endsWith(".jar")) {
					jars.add(f);
				}
			}
		}
		return jars;
	}
}
