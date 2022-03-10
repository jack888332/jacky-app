package demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    private String path;
    private String classLoaderName;
    private final String fileExtension = ".class";

    public MyClassLoader(String classLoaderName) {
        super();// 使用系统类加载器作为父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);// 使用传入的类加载器作为父加载器
        this.classLoaderName = classLoaderName;
    }

    /**
     * 根据文件的地址，以字节的形式加载class文件。
     *
     * @param {String}name
     * @return 加载class的byte数组
     */
    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            name = name.replace(".", "\\");
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("----------------------This is MyClassLoader------------------");
        byte[] data = this.loadClassData(name);
        return super.defineClass(name, data, 0, data.length);
    }

    public void setPath(String path) {
        this.path = path;
    }
}

