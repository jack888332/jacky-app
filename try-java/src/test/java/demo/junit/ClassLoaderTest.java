package demo.junit;

import demo.classloader.MyClassLoader;
import org.junit.Test;

public class ClassLoaderTest {
    /**
     * 测试类加载器的双亲委托机制
     * 假设，类加载器A是类加载器B的父加载器，
     * 某class如果先前已用A加载，则后续当用B加载时，则B会自动委托A加载; 否则B直接加载。
     * 比对测试方法：
     * 1、先编译User.java, 再加载out中User.class
     * 2、删除编译后的User.class, 再加载out中User.class
     */
    @Test
    public void test1() throws ClassNotFoundException {
        MyClassLoader loader = new MyClassLoader("loader1");
        loader.setPath("D:\\eclipse-workspace\\jacky-app\\out\\any\\");
        Class<?> clazz = loader.loadClass("demo.domain.User");
        System.out.println(clazz.getClassLoader());
    }

    /**
     * 在前面定义子在实例另一个类加载器，给这个实例化加载器设置一个不存在的路径
     * 把这个新实例的类加载器，作为之前类加载器的父类加载器，用第二个类加载器去加载实例
     * 条件：
     * (1)项目目录下的class文件已经删除
     * (2)第一个类加载器的路径不粗不在或者路径存在，当路径下没有要加载的class文件
     * (3)第二个类加载器指定的目录下存在要加载的class文件
     **/
    @Test
    public void test2() throws ClassNotFoundException {
        MyClassLoader loader1 = new MyClassLoader("loader");
        loader1.setPath("C:\\Users\\13559\\Desktop\\jvmtest\\***\\");
        MyClassLoader loader = new MyClassLoader(loader1, "loader1");
        loader.setPath("C:\\Users\\13559\\Desktop\\jvmtest\\");
        // com.programer.wenbin.jvm.TestUse这个类是自己建立的一个普通java类，可以没有任何一个属性和方法
        Class<?> clazz = loader.loadClass("com.programer.wenbin.jvm.TestUse");
        System.out.println(clazz.getClassLoader());
    }
}
