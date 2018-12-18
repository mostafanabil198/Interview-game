package eg.edu.alexu.csd.oop.cs51.objects.skills;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import eg.edu.alexu.csd.oop.cs51.objects.Skill;

public class SkillLoader {
    private String path;
    private List<Class<? extends Skill>> supported;
    
    public SkillLoader(String path) {
        this.path = path;
    }
    
    public void load() {
        List<File> jars = getJars();
        for(File jar: jars) {
            loadSkillFromJar(jar.getPath());
        }
    }
    
    public List<Class<? extends Skill>> getSkills() {
        return supported;
    }
    
    private void loadSkillFromJar(String JarPath) {
        JarFile jarFile = null;
        try {
            jarFile = new JarFile(JarPath);
            URL[] urls = { new URL("jar:file:" + JarPath+"!/") };
            
            URLClassLoader loader = new URLClassLoader(urls);
            
            Enumeration<JarEntry> e = jarFile.entries();
            while (e.hasMoreElements()) {
                JarEntry je = (JarEntry) e.nextElement();
                if(je.isDirectory() || !je.getName().endsWith(".class")){
                    continue;
                }
                String className = je.getName().substring(0,je.getName().length()-6);
                className = className.replace('/', '.');
                Class c = loader.loadClass(className);
                if(Skill.class.isAssignableFrom(c)) {
                    supported.add(c);
                    String name = c.getName();
                    String[] namearr = name.split(".");
                    File targetFile = new File("res/"+namearr[namearr.length - 1]+".png");
                    if(!new File("res").exists()) {
                        new File("res").mkdirs();
                    }
                    if(!targetFile.exists()) {
                        targetFile.createNewFile();
                    }
                    OutputStream outStream = new FileOutputStream(targetFile);
                    outStream.write(loader.getResourceAsStream(c.getPackageName().replace(".", "/") +"/res/"+namearr[namearr.length - 1]+".png").readAllBytes());
                    outStream.close();
                }
            }
            loader.close();
        } catch (Exception e) {
        }
    }
    private List<File> getJars(){
        File folder = new File(path);
        if(! folder.exists()) {
            folder.mkdir();
        }
        File[] files = folder.listFiles();
        List<File> jars = new ArrayList<File>();
        for(File f : files) {
            if(f.isFile()) {
                if(f.getName().endsWith(".jar")) {
                    jars.add(f);
                }
            }
        }
        return jars;
    }
}
