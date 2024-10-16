package reflection;

import java.io.*;
import java.util.*;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import java.lang.reflect.*;


public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    static {
        try {
            FileHandler file = new FileHandler("exception.log");
            file.setFormatter(new SimpleFormatter());
            logger.addHandler(file);
        } catch (IOException e) {
            System.err.println("Ошибка при инициализации логгера: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FirstClass obj = new FirstClass();
        Method[] methods = FirstClass.class.getDeclaredMethods();
        for (Method method : methods) {
            try {
                int modifiers = method.getModifiers();
                if (java.lang.reflect.Modifier.isPrivate(method.getModifiers())
                || java.lang.reflect.Modifier.isProtected(method.getModifiers())){
                    method.setAccessible(true);
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 0) {
                       method.invoke(obj);
                    } else {
                        Object[] params = new Object[parameterTypes.length];
                        for (int i = 0; i < parameterTypes.length; i++) {
                           if (parameterTypes[i] == int.class) {
                               params[i] = 10;
                             } else if (parameterTypes[i] == String.class) {
                               params[i] = "Hello";
                             } else if (parameterTypes[i] == boolean.class) {
                               params[i] = true;
                             }else if (parameterTypes[i] == double.class) {
                               params[i] = 1.0;
                             } else {
                               try {
                                 params[i] = parameterTypes[i].newInstance();
                               }catch (InstantiationException | IllegalAccessException e) {
                                    System.err.println("Ошибка создания объекта: " + e.getMessage());
                              }
                           }
                        }
                        method.invoke(obj,params);
                    }
                }
            } catch (InvocationTargetException | IllegalAccessException | SecurityException e) {
                logger.log(Level.SEVERE, "Ошибка вызова", e);
            }
        }
    }
}