package net.frozenlogic.mediacenter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationManager {
    private static Map<String, ApplicationContext> contextMap = new HashMap<String, ApplicationContext>();

    public static ApplicationContext getOrRegisterApplicationContext() {
        return getOrRegisterApplicationContext("main");
    }

    public static ApplicationContext getOrRegisterApplicationContext(String name) {
        if (isApplicationContextRegistered(name))
            return getApplicationContext(name);
        else {
            URL url = ConfigurationManager.class.getProtectionDomain().getCodeSource().getLocation();
            String path;
            try {
                path = url.toURI().getPath() + "configuration";
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            }
            File file = new File(path);
            if (!name.equals("main"))
                file = new File(path, name);
            String[] xmlFiles = getFileNames(file);
            ApplicationContext context = new FileSystemXmlApplicationContext(xmlFiles);
            registerContext(name, context);
            return context;
        }
    }

    private static String[] getFileNames(File file) {
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String fileName) {
                return fileName.endsWith(".xml");
            }
        };
        File[] files = file.listFiles(filenameFilter);
        List<String> list = new ArrayList<String>();
        for (File xmlFile : files) {
            list.add("file:" + xmlFile.getPath());
        }

        return list.toArray(new String[list.size()]);
    }

    public static void registerContext(String name, ApplicationContext context) {
        contextMap.put(name, context);
    }

    public static boolean isApplicationContextRegistered(String name) {
        return contextMap.containsKey(name);
    }

    public static ApplicationContext getApplicationContext(String name) {
        return contextMap.get(name);
    }
}
