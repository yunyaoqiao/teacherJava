package reflect;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {
    private Map<String, Object> beanMap = new HashMap<String, Object>();
    /**
     * bean工厂的初始化.
     * @param xml xml配置文件
     */
    public void init(String xml) {
        try {
            //读取指定的配置文件
            SAXReader reader = new SAXReader();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            //从class目录下获取指定的xml文件
            InputStream ins = classLoader.getResourceAsStream(xml);
            Document doc = reader.read(ins);
            Element root = doc.getRootElement();
            Element foo;

            //遍历bean
            for (Iterator i = root.elementIterator("bean"); i.hasNext();) {
                foo = (Element) i.next();
                //获取bean的属性id和class
                Attribute id = foo.attribute("id");
                Attribute cls = foo.attribute("class");//class文件的包

                //利用Java反射机制，通过class的名称获取Class对象
                Class bean = Class.forName(cls.getText());//1.Java反射机制中的获取Class对象

                //获取对应class的信息
                java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
                //获取其属性描述
                java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();
                //设置值的方法
                Method mSet = null;
                //创建一个对象
                Object obj = bean.newInstance();//2.创建类的对象

                //遍历该bean的property属性----采用属性注入
                for (Iterator ite = foo.elementIterator("property"); ite.hasNext();) {
                    Element foo2 = (Element) ite.next();
                    //获取该property的name属性
                    Attribute name = foo2.attribute("name");
                    String value = null;

                    //获取该property的子元素value的值
                    for(Iterator ite1 = foo2.elementIterator("value"); ite1.hasNext();) {
                        Element node = (Element) ite1.next();
                        value = node.getText();
                        break;
                    }

                    for (int k = 0; k < pd.length; k++) {
                        if (pd[k].getName().equalsIgnoreCase(name.getText())) {
                            mSet = pd[k].getWriteMethod();//3.获得用于写入属性值的方法。
                            // java.beans类 PropertyDescriptor

                            //利用Java的反射极致调用对象的某个set方法，并将值设置进去
                            mSet.invoke(obj, value);//4.利用修改修饰值的方法，修改对象属性
                        }
                    }
                }

                //将对象放入beanMap中，其中key为id值，value为对象
                beanMap.put(id.getText(), obj);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //other codes
}
